
<%@ page import="no.friark.ds.Arkivskaper" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Arkivskaper</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Arkivskaper List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Arkivskaper</g:link></span>
        </div>
        <div class="body">
            <h1>Show Arkivskaper</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:arkivskaperInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Arkivskaperid:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:arkivskaperInstance, field:'arkivskaperid')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Arkivskapernavn:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:arkivskaperInstance, field:'arkivskapernavn')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:arkivskaperInstance, field:'beskrivelse')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Arkiv:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="a" in="${arkivskaperInstance.arkiv}">
                                    <li><g:link controller="arkiv" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${arkivskaperInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
