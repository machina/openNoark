
<%@ page import="no.friark.ds.FondsCreator" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit FondsCreator</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">FondsCreator List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New FondsCreator</g:link></span>
        </div>
        <div class="body">
            <h1>Edit FondsCreator</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${fondsCreatorInstance}">
            <div class="errors">
                <g:renderErrors bean="${fondsCreatorInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${fondsCreatorInstance?.id}" />
                <input type="hidden" name="version" value="${fondsCreatorInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fondsCreatorid">FondsCreatorid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'fondsCreatorid','errors')}">
                                    <input type="text" id="fondsCreatorid" name="fondsCreatorid" value="${fieldValue(bean:fondsCreatorInstance,field:'fondsCreatorid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fondsCreatornavn">FondsCreatornavn:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'fondsCreatornavn','errors')}">
                                    <input type="text" id="fondsCreatornavn" name="fondsCreatornavn" value="${fieldValue(bean:fondsCreatorInstance,field:'fondsCreatornavn')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:fondsCreatorInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkiv">Fonds:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'arkiv','errors')}">
                                    <g:select name="arkiv"
from="${no.friark.ds.Fonds.list()}"
size="5" multiple="yes" optionKey="id"
value="${fondsCreatorInstance?.arkiv}" />

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
