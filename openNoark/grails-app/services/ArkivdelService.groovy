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

import no.friark.ds.*

/**
* Metoder for å gjøre operasjoner på Arkivdel objekter.
*/
class ArkivdelService {

    boolean transactional = true
		def commonService

		/**
		* Finner alle Mapper under den inkommende arkivdelen som ikke er avsluttet.
    * @param del Arkivdelen som inneholder mapppene
    * @return en Liste av alle mappene under del som har avsluttetdato lik null
		*/
		def findOpenMappe(Arkivdel del){
			def retval = []
			del.referansemappe.each{
				if(it.avsluttetdato == null) retval << it
			}
			return retval
		}
	
}
