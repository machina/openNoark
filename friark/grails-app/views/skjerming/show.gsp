
<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Skjerming</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Skjerming List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Skjerming</g:link></span>
        </div>
        <div class="body">
            <h1>Show Skjerming</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:skjermingInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tilgangsrestriksjon:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:skjermingInstance, field:'tilgangsrestriksjon')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Skjermingshjemmel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:skjermingInstance, field:'skjermingshjemmel')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Skjermingmetadata:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:skjermingInstance, field:'skjermingmetadata')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Skjermingdokument:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:skjermingInstance, field:'skjermingdokument')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Skjermingsvarighet:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:skjermingInstance, field:'skjermingsvarighet')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Skjermingopphørerdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:skjermingInstance, field:'skjermingopphørerdato')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${skjermingInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
