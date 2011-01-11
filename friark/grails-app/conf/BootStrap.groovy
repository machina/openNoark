import org.apache.shiro.crypto.hash.Sha1Hash
import grails.converters.*
import grails.util.Environment

import org.friark.ds.*
import org.friark.shiro.*
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

		   grails.test.GrailsUnitTestCase.metaClass.loginTestUser = { isPermitted = {true}->
		      def testRole = new ShiroRole(name: "test")
		      testRole.addToPermissions("user")

		      if(!testRole.save()){
		         println testRole.errors
		      }

		      def testUser
		      if(ShiroUser.findByUsername("testuser")){
			 testUser = ShiroUser.findByUsername("testuser")
		      }else{
			 testUser = new ShiroUser(username: "testuser", passwordHash: new Sha1Hash("testpassword").toHex())
			 if(!testUser.save()) println "testUser.errors"
			    testUser.addToRoles(ShiroRole.findByName("administrator"))
			    testUser.save()
					
			    if(!testUser.save()){
  	    		       println testUser.errors
			    }
		      }

	  	      def subject = [ getPrincipal: { "testuser" },
                				    isAuthenticated: { true },
						    isPermitted: isPermitted
              			    ] as org.apache.shiro.subject.Subject

		      org.apache.shiro.util.ThreadContext.put( org.apache.shiro.util.ThreadContext.SECURITY_MANAGER_KEY, [getSubject:{subject}] as org.apache.shiro.mgt.SecurityManager )
		    	def authToken = new org.apache.shiro.authc.UsernamePasswordToken("testuser", "testpassword")
		  }
	        }

		SeleniumHelper.metaClass.acceptFile = { File file ->
		   return !file.isHidden() && file.isFile()
		}

		SeleniumHelper.metaClass.acceptDirectory = {File file ->
		   return (file.isDirectory() && !(file.isHidden() || file.name.startsWith('.') || file.name == 'inc' ))
	        }

		JSON.registerObjectMarshaller(Klass){	klasse, json ->
		   json.build{
			"class(klasse)"
			id(klasse.id)
			fullId(klasse.fullId)
		   }
		}

		// Administrator user and role. 
		def adminRole = new ShiroRole(name: "administrator") 
		adminRole.addToPermissions("user")
		adminRole.addToPermissions("klasser")

		if(!adminRole.save()){
		   println adminRole.errors
		}

		adminRole.addToPermissions("klasser")

		if(!adminRole.save()){
	           println adminRole.errors
       	        }

		def adminUser = new ShiroUser(username: "admin", passwordHash: new Sha1Hash("admin").toHex()).save()
		adminUser.addToRoles(ShiroRole.findByName("administrator"))
		adminUser.save()

		if(!adminUser.save()){
		   println adminUser.errors
		}

	      println "USERS: ${ShiroUser.list()}"
    }

    def destroy = {
    }
} 
