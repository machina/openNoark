
<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Saksansvar</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Saksansvar List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Saksansvar</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Saksansvar</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${saksansvarInstance}">
            <div class="errors">
                <g:renderErrors bean="${saksansvarInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${saksansvarInstance?.id}" />
                <input type="hidden" name="version" value="${saksansvarInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="administrativenhet">Administrativenhet:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:saksansvarInstance,field:'administrativenhet','errors')}">
                                    <input type="text" id="administrativenhet" name="administrativenhet" value="${fieldValue(bean:saksansvarInstance,field:'administrativenhet')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="saksbehandler">Saksbehandler:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:saksansvarInstance,field:'saksbehandler','errors')}">
                                    <input type="text" id="saksbehandler" name="saksbehandler" value="${fieldValue(bean:saksansvarInstance,field:'saksbehandler')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="journalenhet">Journalenhet:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:saksansvarInstance,field:'journalenhet','errors')}">
                                    <input type="text" id="journalenhet" name="journalenhet" value="${fieldValue(bean:saksansvarInstance,field:'journalenhet')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="journalpost">Journalpost:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:saksansvarInstance,field:'journalpost','errors')}">
                                    
<ul>
<g:each var="j" in="${saksansvarInstance?.journalpost?}">
    <li><g:link controller="journalpost" action="show" id="${j.id}">${j?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="journalpost" params="['saksansvar.id':saksansvarInstance?.id]" action="create">Add Journalpost</g:link>

                                </td>
                            </tr> 
                        
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
