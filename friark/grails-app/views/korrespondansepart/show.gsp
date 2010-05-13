
<%@ page import="no.friark.ds.Korrespondansepart" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Korrespondansepart</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Korrespondansepart List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Korrespondansepart</g:link></span>
        </div>
        <div class="body">
            <h1>Show Korrespondansepart</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Korrespondanseparttype:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'korrespondanseparttype')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Korrespondansepartnavn:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'korrespondansepartnavn')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Postadresse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'postadresse')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Postnummer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'postnummer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Poststed:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'poststed')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Utenlandsadresse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'utenlandsadresse')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Epostadresse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'epostadresse')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Telefonnummer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'telefonnummer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Kontaktperson:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:korrespondansepartInstance, field:'kontaktperson')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${korrespondansepartInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
