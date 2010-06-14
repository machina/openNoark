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

import grails.converters.*
import no.friark.ds.*

/**
* CRUD for Serieser
*/
class SeriesController {
		def commonService
		def arkivdelService

    def index = { redirect(action:list,params:params)}

		def create = {
			[arkiver: Fonds.list()]
		}


		/**
		* Lager en ny arkivdel. Denne funksjonen setter automatisk verdiene dor systemID, recordSectionStatus og createdBy
		*/
		def save = {
			def arkivdel
			def parent

			if(params.series){  
				parent = params.series.parent	
				params.series.parent = null
			}
      else {	
				parent = params.parent
				params.parent = null
			}
			
			if(params.series)  arkivdel = new Series(params.series)
			else arkivdel = new Series(params)
			arkivdel.recordSectionStatus = "Opprettet"
			commonService.setNewSystemID(arkivdel)
			commonService.setCreated(arkivdel)
			println parent
			if(parent == null || parent == "null") {
				arkivdel.parent = null
			} else {
				arkivdel.parent = Fonds.get(parent)
			}
			if(!arkivdel.save()){
				withFormat {
	        html {
						render(view: "create", model: [errors: arkivdel.errors])
					}
					xml {
						render text:"<errors>${arkivdel.errors}</errors>", contentType:"text/xml",encoding:"UTF-8"
					}
				}
			} else {
				withFormat {
	        html {
						render(view: "show", model: [arkivdel: arkivdel])
					}
					xml {
          	render arkivdel as XML
        	}
				}
			}
		}
	
		def show = {
			withFormat {
          html { return [arkivdel: Series.get(params.id)] }
					xml {render Series.get(params.id) as XML }
			}
		}
		
		def list = {
			if (!params.sort) params.sort = "title"
	    if (!params.order) params.order = "asc"

			def arkivdeler = Series.withCriteria {
  	    if(params.sort == "forelder"){
    	    parent {
        	  order('title', params.order)
      	  }
		    } else {
  	      order(params.sort, params.order)
				}
			}      

			withFormat {
	      html {
  	      return [arkivdeler: arkivdeler]
        }
        xml {
    	    render Series.findAll() as XML
        }
        json {
       		 println Series.findAll() as JSON
           render Series.findAll() as JSON
        }
     }

			return [arkivdeler: arkivdeler]
		}

	def edit = {
		render(view: 'update', model: [arkivdel: Series.get(params.id)])
	}

	def update = { UpdateSeriesCommand updateCommand ->

		switch(request.method){
      case 'GET':
        return [arkivdel: Series.get(params.id)]
        break
      case 'POST':
				def arkivdel = Series.get(params.id)
				if(updateCommand.finalisedDate == null){
          params.finalisedDate = null
        }
				if(updateCommand.recordsPeriodStartDate == null) params.recordsPeriodStartDate = null
        if(updateCommand.recordsPeriodEndDate == null) params.recordsPeriodEndDate = null
				if(updateCommand.createdDate != null && updateCommand.createdDate == arkivdel.createdDate){
					params.createdDate = null
				}
				arkivdel.properties = params
        if(!arkivdel.hasErrors() && arkivdel.validate() && arkivdel.save()){
          render(view: "show", model: [arkivdel: arkivdel])
        } else {
          render(view: "update", model: [errors: arkivdel.errors, arkivdel: arkivdel])
        }
        break
			case 'PUT':
				println params
				def arkivdel = Series.get(params.series.id)
				params.series.createdDate = arkivdel.createdDate
				params.series.recordSectionStatus = params.series.recordSectionStatus.trim()
				params.series.parent = Fonds.get(params.series.'parent.id')
				println params.series.parent
				arkivdel.properties = params.series
				println arkivdel.parent
				if(!arkivdel.hasErrors() && arkivdel.validate() && arkivdel.save()){
          render arkivdel as XML
        } else {
          render text:"<errors>${arkivdel.errors}</errors>", contentType:"text/xml",encoding:"UTF-8"
        }
				break
    }

	}
	
	def håndterOppbevaringsted = {
		return [arkivdel: Series.get(params.id)]
	}

	def fjernOppbevaringsted = {
		def arkivdel = Series.get(params.arkivdelid)
		arkivdel.storageLocation.remove  params.sted
		if(arkivdel.save()){
			println arkivdel.errors
			render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel]
		}else{
			render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel, errors: arkivdel.errors]
			println arkivdel.errors
		}
	}

	def leggTilOppbevaringsted = {
		def arkivdel = Series.get(params.arkivdelid)
    arkivdel.storageLocation.add params.sted
		if(arkivdel.save()){
      println arkivdel.errors
      render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel]
    }else{
      render view: 'håndterOppbevaringsted', model: [arkivdel: arkivdel, errors: arkivdel.errors]
      println arkivdel.errors
    }


  }


	/**
	* TODO: read spec and find out if delete should be posssible on this object
	*/
  def delete = {
    def series = Series.get(params.id)
    series.delete()
    render "success"
  }


}
class UpdateSeriesCommand {
  Date createdDate
  Date finalisedDate
	Date recordsPeriodStartDate
	Date recordsPeriodEndDate
}
