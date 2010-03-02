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

package no.friark

class FilterBuilder extends BuilderSupport {

		Filter filter = new Filter()

	  void setParent(Object parent, Object child){

		}
    
		Object createNode(Object name){
			
		}
    Object createNode(Object name, Object value){

		}
    Object createNode(Object name, Map attributes){
			switch(name){
				case "mappe":
					attributes.keySet().toArray().each{	key ->
						filter.mappe[key] = attributes[key]
					}
					break
				case "klasse":
					attributes.keySet().toArray().each{ key ->
   	        filter.klasse[key] = attributes[key]
          }
					break
				case "arkivdel":
          attributes.keySet().toArray().each{ key ->
   	        filter.arkivdel[key] = attributes[key]
          }
					break
			}
		}
    Object createNode(Object name, Map attributes, Object value){

		}
    Object getName(String methodName){
			return methodName
		}
}
