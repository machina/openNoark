
<%@ page import="no.friark.ds.Arkivskaper" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title><g:message code="title" default="Title"/>Edit Arkivskaper</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="fondscreator.list" default="Fonds creator list"/></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="action.new" default="New"/>New Arkivskaper</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="action.edit" default="Edit"/>Edit Arkivskaper</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${arkivskaperInstance}">
            <div class="errors">
                <g:renderErrors bean="${arkivskaperInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${arkivskaperInstance?.id}" />
                <input type="hidden" name="version" value="${arkivskaperInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivskaperid"><g:message code="id" default="ID"/>:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:arkivskaperInstance,field:'arkivskaperid','errors')}">
                                    <input type="text" id="arkivskaperid" name="arkivskaperid" value="${fieldValue(bean:arkivskaperInstance,field:'arkivskaperid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivskapernavn"><g:message code="name" default="Name"/>:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:arkivskaperInstance,field:'arkivskapernavn','errors')}">
                                    <input type="text" id="arkivskapernavn" name="arkivskapernavn" value="${fieldValue(bean:arkivskaperInstance,field:'arkivskapernavn')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beskrivelse"><g:message code="description" default="Description"/>:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:arkivskaperInstance,field:'beskrivelse','errors')}">
                                    <input type="text" id="beskrivelse" name="beskrivelse" value="${fieldValue(bean:arkivskaperInstance,field:'beskrivelse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkiv"><g:message code="fonds" default="Fonds"/>:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:arkivskaperInstance,field:'arkiv','errors')}">
                                    <g:select name="arkiv"
from="${no.friark.ds.Arkiv.list()}"
size="5" multiple="yes" optionKey="id"
value="${arkivskaperInstance?.arkiv}" />

                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="${message(code:'action.update'}" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="${message(code:'action.delete'}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
