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

package org.friark.services

import org.friark.ds.*
import org.apache.shiro.SecurityUtils

/**
 * Contains common helper methods which are used by several controllers
 */
class CommonService {

    boolean transactional = true

    /**
    * Sets the system ID on an incoming object to a random UUID
    * @param obj An object with a "systemId" field
    */
    def setNewSystemID(def obj) {
        obj.systemID = UUID.randomUUID().toString()
    }

    /**
     * Determines if the incoming object is null or an the string "null"
     * @param obj An object 
     * @return true if the object is null or the string "null", else false
     */
    boolean isNull(def obj){
        return obj == null || obj == 'null'
    }

    def log( def obj ){
        println 'LOG: ' + obj
    }

    /**
     * Sets the fields "createdBy" and "createdDate" for the incoming object 
     * with the name of the user currently logged in and today's date 
     * respectively
     * @param obj, et objekt med feltene createdBy og createdDate
     */
    void setCreated(obj) {
        setCreatedBy("createdBy", obj)
        setCreatedAt("createdDate", obj)
    }
	
    private void setCreatedBy(field, obj){
        obj."$field" = SecurityUtils.subject.principal
    }

    private void setCreatedAt(field, obj){
        obj."$field" = new Date()
    }

    /**
     * Gets the configuration parameter specified by the key
     * @param key The key of the parameter wanted 
     * @ @return The parameter value as a string
     */
    String getParameter(def key){
        def param = Parameter.findByKey(key.toString())
        if(param && param.value) return param.value
        return defaults."${key}"
    }

    void trimAll(def map){
	map.keySet().each{
		if(map[it] instanceof String) map[it] = map[it].trim()
	}
    }  

    def defaults = [
        autorisert_ny_versjon_av_ekspedert: "false",
        autorisert_slette_inaktive_doumenter: "false",
        tilgjengelige_fileTypes: "BasicFile, CaseFile",
        tilgjengelige_recordTyper: "Forenkletregistrering, RegistryEntry"
    ]
}
