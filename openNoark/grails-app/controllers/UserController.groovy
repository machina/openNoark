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

import org.apache.shiro.crypto.hash.Sha1Hash
import no.friark.ds.*

/**
* Operasjoner for å håndtere brukere, roller og tilganger.
* TODO: Roller burde hatt en egen CRUD-kontroller
*
* @author Kent Inge Fagerland Simonsen
*/
class UserController {

    def index = {redirect(action: 'list', params: params) }
	
		/**
		* Lister ut alle brukere 
		*/
		def list = {
			[users: ShiroUser.findAll()]
		}

		/**
    * Lister ut alle roller
    */
		def roles = {
			[roles: ShiroRole.findAll()]
		}
		
		def edit_role = {	
			def role = ShiroRole.get(params.id)
			if(params.del_perm){
				role.permissions.remove(params.perm)
				if(role.save()){
					flash.message = "Permission removed"
				}
			}
			if(params.add_perm){
				role.permissions << params.perm
				if(role.save()){
          flash.message = "Permission added"
        }
			}
			[role: role]
		}
		
		def create_role = {
			if(request.method == 'POST'){
				def role = new ShiroRole(name: params.name)
				if(!role.hasErrors() && role.save()){
					flash.message = "Rollen er opprettet"
					render(view: "edit_role", model: [role: role])
				} else {
					return [role: role]
				}
			}
			else {
				return [role: new ShiroRole()]
			}
		}

		def create = {
			[user: new ShiroUser(username: params.username), errors: params.errors]
		}

		def save = {
			def user = new ShiroUser(params)
			user.passwordHash = new Sha1Hash(params.passwd).toHex()
			if(!user.save()){
				render(view: "create", model: [user: user])
			} else {
				redirect(action: 'list', params: params)
			}
		}

		def edit = {
			if(request.method == 'POST'){
				def user = ShiroUser.get(params.id)
				if(params.del_role){
					user.removeFromRoles(ShiroRole.get(params.roleId))
					user.save()
				} else if(params.add_role){
					user.addToRoles(ShiroRole.get(params.roleId))
					user.save()
				} else if(params.passwd != null && params.passwd != null){
					user.passwordHash = new Sha1Hash(params.passwd).toHex()
					if(!user.save()){
						flash.message = "Cound not edit user"
    		    render(view: "create", model: [user: user])
		      } else {
						flash.message = "User is changed"
		        redirect(action: 'list', params: params)
    		  }
				}
				return [user: user]
			}
			else {
				return [user: ShiroUser.get(params.id)]
			}
		}
}
