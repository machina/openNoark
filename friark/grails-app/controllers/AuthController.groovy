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

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.web.SavedRequest
import org.apache.shiro.web.WebUtils

/**
* Denne kontrolleren er skapt av Shiro-plugin'en. Den tar seg av authentisering.
*/
class AuthController {
    def shiroSecurityManager

    def index = { redirect(action: "login", params: params) }

		/**
    * Viser login skjermen
    */
    def login = {
				if(SecurityUtils.subject?.isAuthenticated()){
					render view: '/index'
				} else {
	        return [ username: params.username, rememberMe: (params.rememberMe != null), targetUri: params.targetUri ]
				}
   }

    /**
    * Sjekker inkommende kredentialer og utfører inlogging.
    */
    def signIn = {

        def authToken = new UsernamePasswordToken(params.username, params.password)

        // Support for "remember me"
        if (params.rememberMe) {
            authToken.rememberMe = true
       }
        
        // If a controller redirected to this page, redirect back
        // to it. Otherwise redirect to the root URI.
        def targetUri = params.targetUri ?: "/"
        
        // Handle requests saved by Shiro filters.
        def savedRequest = WebUtils.getSavedRequest(request)
        if (savedRequest) {
            targetUri = savedRequest.requestURI - request.contextPath
            if (savedRequest.queryString) targetUri = targetUri + '?' + savedRequest.queryString
       }
        
        try{
            // Perform the actual login. An AuthenticationException
            // will be thrown if the username is unrecognised or the
            // password is incorrect.
            SecurityUtils.subject.login(authToken)

            log.info "Redirecting to '${targetUri}'."
            redirect(uri: targetUri)
       }
        catch (AuthenticationException ex){
            // Authentication failed, so display the appropriate message
            // on the login page.
            log.info "Authentication failure for user '${params.username}'."
            flash.message = message(code: "login.failed")

            // Keep the username and "remember me" setting so that the
            // user doesn't have to enter them again.
            def m = [ username: params.username ]
            if (params.rememberMe) {
                m["rememberMe"] = true
           }

            // Remember the target URI too.
            if (params.targetUri) {
                m["targetUri"] = params.targetUri
           }

            // Now redirect back to the login page.
            redirect(action: "login", params: m)
       }
   }

		/**
    * Logger ut nåværende bruker for denne sessjonen.
    */
    def signOut = {
        // Log the user out of the application.
        SecurityUtils.subject?.logout()

        // For now, redirect back to the home page.
        redirect(uri: "/")
   }

    /**
    * Denne blir kallt når brukeren ikke har tilgang på en ønsket resurs.
    */
    def unauthorized = {
        //render "You do not have permission to access this page."
        render message(code: "auth.unauthorised")
   }
}
