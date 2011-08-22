
<%@ page import="org.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Korrespondansepart</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Korrespondansepart List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Korrespondansepart</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Korrespondansepart</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${korrespondansepartInstance}">
            <div class="errors">
                <g:renderErrors bean="${korrespondansepartInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${korrespondansepartInstance?.id}" />
                <input type="hidden" name="version" value="${korrespondansepartInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="korrespondanseparttype">Korrespondanseparttype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'korrespondanseparttype','errors')}">
                                    <input type="text" id="korrespondanseparttype" name="korrespondanseparttype" value="${fieldValue(bean:korrespondansepartInstance,field:'korrespondanseparttype')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="korrespondansepartnavn">Korrespondansepartnavn:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'korrespondansepartnavn','errors')}">
                                    <input type="text" id="korrespondansepartnavn" name="korrespondansepartnavn" value="${fieldValue(bean:korrespondansepartInstance,field:'korrespondansepartnavn')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="postadresse">Postadresse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'postadresse','errors')}">
                                    <input type="text" id="postadresse" name="postadresse" value="${fieldValue(bean:korrespondansepartInstance,field:'postadresse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="postnummer">Postnummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'postnummer','errors')}">
                                    <input type="text" id="postnummer" name="postnummer" value="${fieldValue(bean:korrespondansepartInstance,field:'postnummer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="poststed">Poststed:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'poststed','errors')}">
                                    <input type="text" id="poststed" name="poststed" value="${fieldValue(bean:korrespondansepartInstance,field:'poststed')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="utenlandsadresse">Utenlandsadresse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'utenlandsadresse','errors')}">
                                    <input type="text" id="utenlandsadresse" name="utenlandsadresse" value="${fieldValue(bean:korrespondansepartInstance,field:'utenlandsadresse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="epostadresse">Epostadresse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'epostadresse','errors')}">
                                    <input type="text" id="epostadresse" name="epostadresse" value="${fieldValue(bean:korrespondansepartInstance,field:'epostadresse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="telefonnummer">Telefonnummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'telefonnummer','errors')}">
                                    <input type="text" id="telefonnummer" name="telefonnummer" value="${fieldValue(bean:korrespondansepartInstance,field:'telefonnummer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="kontaktperson">Kontaktperson:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:korrespondansepartInstance,field:'kontaktperson','errors')}">
                                    <input type="text" id="kontaktperson" name="kontaktperson" value="${fieldValue(bean:korrespondansepartInstance,field:'kontaktperson')}"/>
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
