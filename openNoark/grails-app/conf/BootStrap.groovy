import org.apache.shiro.crypto.hash.Sha1Hash
import grails.converters.*
import grails.util.Environment

import no.friark.ds.*
class BootStrap {

     def init = { servletContext ->
			if(Environment.current == Environment.TEST){
					ExpandoMetaClass.enableGlobally()
					grails.test.GrailsUnitTestCase.metaClass.saveOrFail = { obj ->
					if(!obj.save()){
						println obj.errors
						fail "unable to save: ${obj.errors}"
					}		
				}
			}
/*			InputStream.metaClass.eachBytes = {Integer buffSize, Closure closure ->
																					byte[] buffer = new byte[buffSize]
																					byte[] tmp = null
																					while(true){
																						int n = read(buffer)
																						if(n == -1) break;
																						if(n != buffer.lenght) tmp = new byte[n];
																						System.arraycopy(buffer, 0, tmp, 0, n);
																						closure.call(tmp != null ? tmp : buffer);
																						tmp = null
																					}
																				}*/

			JSON.registerObjectMarshaller(Klasse){	klasse, json ->
			json.build{
				"class(klasse)"
				id(klasse.id)
				fullId(klasse.fullId)
			}
		}
		


			// Administrator user and role. 
				def adminRole = new ShiroRole(name: "administrator") 
				adminRole.addToPermissions("user")
				if(!adminRole.save()){
					println adminRole.errors
				}
				def adminUser = new ShiroUser(username: "admin", passwordHash: new Sha1Hash("admin").toHex()).save()
				adminUser.addToRoles(ShiroRole.findByName("administrator"))
				adminUser.save()
				if(!adminUser.save()){
					println adminUser.errors
				}
     }
     def destroy = {
     }
} 
