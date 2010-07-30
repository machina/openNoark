package org.friark

import org.friark.ds.*

class ClassificationSystemService {
    static transactional = true

    def commonService

    def create( def params ){
        
        def klassifikasjonssystemInstance
        if(params.classificationSystem) klassifikasjonssystemInstance = new ClassificationSystem(params.classificationSystem)
        else klassifikasjonssystemInstance = new ClassificationSystem(params)
        commonService.setCreated(klassifikasjonssystemInstance)
        commonService.setNewSystemID(klassifikasjonssystemInstance)
        if(!klassifikasjonssystemInstance.hasErrors() && klassifikasjonssystemInstance.save()) {
        	return [klassifikasjonssystemInstance, true]
	}
        else {
		return [klassifikasjonssystemInstance, false]
        }
    }

    def retrieve( def id ){

    }

    def update( def params ){
	if(params.classificationSystem) params = params.classificationSystem
        def klassifikasjonssystemInstance = ClassificationSystem.get( params.id )
        params.createdDate =  klassifikasjonssystemInstance.createdDate//can not change created date
        klassifikasjonssystemInstance.properties = params
        if(!klassifikasjonssystemInstance.hasErrors() && klassifikasjonssystemInstance.save()) {
            return [klassifikasjonssystemInstance, true]
        } else {
            return [klassifikasjonssystemInstance, false]
        }

    }

}
