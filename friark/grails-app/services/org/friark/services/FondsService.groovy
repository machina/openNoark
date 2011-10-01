package org.friark.services

import org.friark.ds.*

class FondsService {
    static transactional = true

    def final static CREATED = "Opprettet"
    def final static FINALISED = "Avsluttet"
    def commonService

    def create( def params ){
        fixParent(params)

        def fonds = getFonds(params)
        def success = false

        fonds.fondsStatus = CREATED

        commonService.setNewSystemID(fonds)
        commonService.setCreated(fonds)

        stripParent(params, fonds)

        if(fonds.parent){
            fonds.parent.addToSubFonds(fonds)
        }

        if(!fonds.hasErrors() && fonds.validate() && fonds.save()){
            success = true
        }

        return [fonds,success]
    }

    def retrieve( def id ){

    }

    def update( def params ){
        def fonds = Fonds.get(params.fonds.id)
        params.fonds.createdDate = fonds.createdDate  //cannot change created date

        if(fonds.finalisedDate != null && params.fonds.finalisedDate == null){
            fonds.errors.rejectValue "finalisedDate", "USER_ERROR",  message(code:'fonds.cannot.remove.finalised.date')
            return [errors: fonds.errors, fonds: fonds]
        } else if(params.fonds.finalisedDate == null || params.fonds.finalisedDate == ""){
            params.fondsfinalisedDate = null
        }

        stripParent(params.fonds, fonds)
        if(fonds.fondsStatus != params.fonds.fondsStatus && params.fonds.fondsStatus == FINALISED){
            params.fonds.finalisedBy = SecurityUtils.subject.principal
            params.fondsfinalisedDate = new Date()
        }

        fonds.properties = params.fonds
	
	if(fonds.save()){
		return [fonds, true]
	}else {
		return [fonds, false]
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

        def fondser = Fonds.withCriteria {
            if(params.sort == "parentTittel"){
                parent { order('title', params.order) }
            } else {
                order(params.sort, params.order)
            }
        }

        return fondser
    }

    def getFonds(def params){
        def fonds = (params.fonds ) ? new Fonds(params.fonds) : new Fonds( params)
        return fonds
    }

    def stripParent(params, fonds) {
        if( commonService.isNull(params.parent) || "".equals(params.parent) ){
            params.parent = null
            fonds.parent = null
        } else if(params.parent instanceof String){
            fonds.parent = Fonds.get(Integer.parseInt(params.parent))
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
