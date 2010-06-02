/*
This file is part of Friark.

Friark is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Friark is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Friark.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.apache.shiro.SecurityUtils
import no.friark.ds.*

/**
 * CRUD for Arkiv
 */
class ArkivController {
    def commonService
    def index = {redirect(action:list,params:params)}
		
    def create = {
			
    }

	/**
	*Lagrer arkiv basert på params. Feltene fondsStatus, systemtID, opprettetDato og createdBy settet automatisk til hhv "Opprettet", en UUID, dagens dato og den inloggede brukerens brukernavn.
	*/
	def save = {
			fixParent(params)
			def arkiv = new Fonds(params)
			arkiv.fondsStatus = "Opprettet"
			commonService.setNewSystemID(arkiv)
			commonService.setCreated(arkiv)
			stripParent(params, arkiv)
			if(arkiv.parent) arkiv.parent.addToSubFonds(arkiv)
			if(!arkiv.hasErrors() && arkiv.validate() && arkiv.save()){
				flash.message = "Arkiv opprettet"
				render(view: "show", model: [arkiv: arkiv])

        } else {
            render(view: "create", model: [errors: arkiv.errors])

        }
    }

	def list = {
		if (!params.sort) params.sort = "title"
    if (!params.order) params.order = "asc"
		def arkiver = Fonds.withCriteria {
			if(params.sort == "parentTittel"){
				parent {
					order('title', params.order)
				}
			} else {
				order(params.sort, params.order)
			}
			
        }
        [ arkiver: arkiver, arkivTotal: Fonds.count() ]
    }

    def show = {
        return [arkiv: Fonds.get(params.id)]
    }

    def edit = {
        render (view: "update", model: [arkiv: Fonds.get(params.id)])
    }

	def update = { UpdateFondsCommand updateCommand ->
		switch(request.method){
			case 'GET':
				return [arkiv: Fonds.get(params.id)]	
				break
			case 'POST':
				def arkiv = Fonds.get(params.id)
				if(updateCommand.createdDate){
						arkiv.errors.rejectValue "createdDate", "USER_ERROR",  "Kan ikke endre dato for opprettelse av arkiv."
						return [errors: arkiv.errors, arkiv: arkiv]
				}
				if(arkiv.finalisedDate != null && updateCommand.finalisedDate == null){
						arkiv.errors.rejectValue "finalisedDate", "USER_ERROR",  "Kan ikke fjerne finalisedDate."
						return [errors: arkiv.errors, arkiv: arkiv]
				} else if(updateCommand.finalisedDate == null){
					params.finalisedDate = null
				}
				stripParent(params, arkiv)
				if(arkiv.fondsStatus != params.fondsStatus && params.fondsStatus == "Avsluttet"){
					params.finalisedBy = SecurityUtils.subject.principal
					params.finalisedDate = new Date()
				}
				arkiv.properties = params
				if(!arkiv.hasErrors() && arkiv.validate() && arkiv.save()){
					render(view: "show", model: [arkiv: arkiv])
    	  } else {
					render(view: "update", model: [errors: arkiv.errors, arkiv: arkiv])
				}
				break
		}
	}

	def stripParent(params, arkiv) {
		if(!params.parent || params.parent == "null") {
				params.parent = null
        arkiv.parent = null
      } else if(params.parent instanceof String){
        arkiv.parent = Fonds.get(Integer.parseInt(params.parent))
      }
	}
	def fixParent(params){
		if(!params.parent || params.parent == "null") {
			params.parent = null
		} else if(params.parent instanceof String){
			println params.parent
			params.parent = Fonds.get(Integer.parseInt(params.parent))
		} else {
			params.parent.merge()
		}
	}
}

class UpdateFondsCommand {
    Date createdDate
    Date finalisedDate
}
