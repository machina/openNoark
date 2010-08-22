package org.friark.controllers

import grails.converters.XML
import javax.annotation.Generated

import org.friark.ds.Fonds

class FondsController {
	def fondsService
	 
	
	@Generated(value="org.friark.mvcore.generators.grails.GrailsGenerator")
	def create = {
		
		def fondsInstance = new Fonds()
		fondsInstance.properties = params
		return [fondsInstance: fondsInstance]
		
	}
		
	
}