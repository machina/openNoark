package org.friark

import org.friark.ds.*

class ArkivService {
    static transactional = true

    def final static CREATED = "Opprettet"
    def final static FINALISED = "Avsluttet"
    def commonService

    def create( def params ){
        fixParent(params)

        def arkiv = getFonds(params)
        def success = false

        arkiv.fondsStatus = CREATED

        commonService.setNewSystemID(arkiv)
        commonService.setCreated(arkiv)

        stripParent(params, arkiv)

        if(arkiv.parent){
            arkiv.parent.addToSubFonds(arkiv)
        }

        if(!arkiv.hasErrors() && arkiv.validate() && arkiv.save()){
            success = true
        }

        return [arkiv,success]
    }

    def retrieve( def id ){

    }

    def update( def params ){
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
	
	if(arkiv.save()){
		return [arkiv, true]
	}else {
		return [arkiv, false]
	}
    }

    def delete( def id ){
        def success = false
        def fonds = Fonds.get(id)

        if( fonds != null ){
            fonds.delete()
            success = true
        }

        commonService.log( 'Deleting Fonds id :' + id + ' status: ' +success)

        return success
    }

    def list( def params ){
          if (!params.sort){
            params.sort = "title"
        }

        if (!params.order) {
            params.order = "asc"
        }

        def arkiver = Fonds.withCriteria {
            if(params.sort == "parentTittel"){
                parent { order('title', params.order) }
            } else {
                order(params.sort, params.order)
            }
        }

        return arkiver
    }

    def getFonds(def params){
        def arkiv = (params.fonds ) ? new Fonds(params.fonds) : new Fonds( params)
        return arkiv
    }

    def stripParent(params, arkiv) {
        if( commonService.isNull(params.parent) || "".equals(params.parent) ){
            params.parent = null
            arkiv.parent = null
        } else if(params.parent instanceof String){
            arkiv.parent = Fonds.get(Integer.parseInt(params.parent))
        }
    }
    def fixParent(params){
        if( commonService.isNull(params.parent)){
            params.parent = null
        } else if(params.parent instanceof String){
            params.parent = Fonds.get(Integer.parseInt(params.parent))
        } else {
            params.parent.merge()
        }
    }
}
