
<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Journalpost</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Journalpost List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Journalpost</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Journalpost</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${forenkletRegistreringInstance}">
            <div class="errors">
                <g:renderErrors bean="${forenkletRegistreringInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${forenkletRegistreringInstance?.id}" />
                <input type="hidden" name="version" value="${forenkletRegistreringInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
												 <g:render template="forenkletReg_form"/>
												 <g:if test="${forenkletRegistreringInstance instanceof BasicRecord}">
														 <g:render template="basisReg_form"/>
													</g:if>
													<g:if test="${forenkletRegistreringInstance instanceof RegistryEntry}">
                             <g:render template="journalpost_form"/>
                          </g:if>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
