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
import org.apache.shiro.SecurityUtils
import no.friark.ds.*
import org.friark.FondsService

/**
 * CRUD for Arkiv
 */
class ArkivController {
    def final static FINALISED = "Avsluttet"
    def final static CREATED = "Opprettet"

    def fondsService
    def commonService

    def index = {redirect(action:list,params:params)}

    def create = {
    }

    def retrieve = {
        withFormat{
            html { return [arkiv: Fonds.get(params.id)] }
            xml { render Fonds.get(params.id) as XML }
        }
    }

    def update = { UpdateFondsCommand updateCommand ->
        commonService.log( 'Edit fonds ' + params.id + ', ' + params + ' method: ' + request.method)

        switch(request.method){
            case 'GET':
            return [arkiv: Fonds.get(params.id)]
            break
            case 'POST':
            def arkiv = Fonds.get(params.id)

            if(updateCommand.createdDate){
                arkiv.errors.rejectValue "createdDate", "USER_ERROR",  message(code:'fonds.cannot.change.created.date')
                return [errors: arkiv.errors, arkiv: arkiv]
            }

            if(arkiv.finalisedDate != null && updateCommand.finalisedDate == null){
                arkiv.errors.rejectValue "finalisedDate", "USER_ERROR",  message(code:'fonds.cannot.remove.finalised.date')
                return [errors: arkiv.errors, arkiv: arkiv]
            } else if(updateCommand.finalisedDate == null){
                params.finalisedDate = null
            }

            //           fondsService.stripParent(params, arkiv)
            stripParent(params, arkiv)

            if(arkiv.fondsStatus != params.fondsStatus && params.fondsStatus == FINALISED){
                params.finalisedBy = SecurityUtils.subject.principal
                params.finalisedDate = new Date()
            }

            arkiv.properties = params

            def hasErrors = arkiv.hasErrors()
            def validates = arkiv.validate()
            def isSaved = arkiv.save()

            commonService.log( '>>>>>>>>>>>>>>> hasErrrors: '  + hasErrors + ', validates: ' + validates +', isSaved: ' + isSaved )

            if(!hasErrors && validates && isSaved){
                commonService.log('11 >>>>>>>>>>>>>>>>>>>>>>>>>> ARKIV: ' + arkiv)

                withFormat {
                    html { render(view: "show", model: [arkiv: arkiv]) }
                    xml { render arkiv as XML }
                }
            } else {
                commonService.log('22 >>>>>>>>>>>>>>>>>>>>>>>>>> ARKIV: ' + arkiv)
                withFormat{
                    html { render(view: "update", model: [errors: arkiv.errors, arkiv: arkiv]) }
                    xml { render text:"<errors>${arkiv.errors}</errors>", contentType:"text/xml",encoding:"UTF-8" }
                }
            }
            break
            case 'PUT':
            params.fonds.title = params.fonds.title.trim();
            params.fonds.fondsStatus = params.fonds.fondsStatus.trim();
            params.fonds.systemID = params.fonds.systemID.trim();

            def arkiv = Fonds.get(params.fonds.id)
            params.fonds.createdDate = arkiv.createdDate  //cannot change created date

            if(arkiv.finalisedDate != null && params.fonds.finalisedDate == null){
                arkiv.errors.rejectValue "finalisedDate", "USER_ERROR",  message(code:'fonds.cannot.remove.finalised.date')
                return [errors: arkiv.errors, arkiv: arkiv]
            } else if(params.fonds.finalisedDate == null || params.fonds.finalisedDate == ""){
                params.fondsfinalisedDate = null
            }

            stripParent(params.fonds, arkiv)
            if(arkiv.fondsStatus != params.fonds.fondsStatus && params.fonds.fondsStatus == FINALISED){
                params.fonds.finalisedBy = SecurityUtils.subject.principal
                params.fondsfinalisedDate = new Date()
            }

            arkiv.properties = params.fonds
            if(!arkiv.hasErrors() && arkiv.validate() && arkiv.save()){
                render arkiv as XML
            } else {
                render text:"<errors>${arkiv.errors}</errors>", contentType:"text/xml",encoding:"UTF-8"
            }
            break
        }
    }

    def delete = {
        commonService.log( params )
        fondsService.delete( params.id )
        render (view:'list', model:[arkiver: Fonds.list(),arkivTotal:Fonds.count()])
    }

    def show = {
        retrieve()
    }

    def edit = {
        render (view: "update", model: [arkiv: Fonds.get(params.id)])
    }

    /**
     *Lagrer arkiv basert på params. Feltene fondsStatus, systemtID, opprettetDato og createdBy settet automatisk til hhv "Opprettet", en UUID, dagens dato og den inloggede brukerens brukernavn.
     */
    def save = {
        def (arkiv, success) = fondsService.create( params )

        if( success ){

            commonService.log( 'fonds created ' + arkiv)

            withFormat {
                html { render(view: "show", model: [arkiv: arkiv]) }
                form { render(view: "show", model: [arkiv: arkiv]) }
                xml { render arkiv as XML }
            }

        } else {
            withFormat{
                form { render(view: "create", model: [errors: arkiv.errors]) }
                html { render(view: "create", model: [errors: arkiv.errors]) }
                xml { render text:"<errors>${arkiv.errors}</errors>", contentType:"text/xml",encoding:"UTF-8" }
            }
        }
    }

    def list = {
        def arkiver = fondsService.list(params)

        withFormat{
            html { [ arkiver: arkiver, arkivTotal: Fonds.count() ] }
            xml { render arkiver as XML  }
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

    String toString() { "createdDate ${createdDate}, finalisedDate ${finalisedDate}" }
}