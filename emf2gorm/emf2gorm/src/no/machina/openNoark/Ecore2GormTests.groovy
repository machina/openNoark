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

package no.machina.openNoark;

public class Ecore2GormTests {

	def transform(def pack){
		def name
	}


	def getPackageName(def pack){
		def name = ""
		pack.eContents().each{
			if(it.getClass().name == "org.eclipse.emf.ecore.impl.EAnnotationImpl" && it.name == "package"){
				return it.details.value[0] //TODO: make safer
			}
		}
	}
}