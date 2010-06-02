
<%@ page import="no.friark.ds.FondsCreator" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create FondsCreator</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">FondsCreator List</g:link></span>
        </div>
        <div class="body">
            <h1>Create FondsCreator</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${fondsCreatorInstance}">
            <div class="errors">
                <g:renderErrors bean="${fondsCreatorInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
