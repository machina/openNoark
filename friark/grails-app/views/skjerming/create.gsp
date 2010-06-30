
<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Skjerming</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Skjerming List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Skjerming</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${skjermingInstance}">
            <div class="errors">
                <g:renderErrors bean="${skjermingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post"> 
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accessRestriction">Tilgangsrestriksjon:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'accessRestriction','errors')}">
                                    <input type="text" id="accessRestriction" name="accessRestriction" value="${fieldValue(bean:skjermingInstance,field:'accessRestriction')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="screeningAuthority">Skjermingshjemmel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'screeningAuthority','errors')}">
                                    <input type="text" id="screeningAuthority" name="screeningAuthority" value="${fieldValue(bean:skjermingInstance,field:'screeningAuthority')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="screeningDocument">Skjermingdokument:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'screeningDocument','errors')}">
                                    <input type="text" id="screeningDocument" name="screeningDocument" value="${fieldValue(bean:skjermingInstance,field:'screeningDocument')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="screeningDuration">Skjermingsvarighet:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'screeningDuration','errors')}">
                                    <input type="text" id="screeningDuration" name="screeningDuration" value="${fieldValue(bean:skjermingInstance,field:'screeningDuration')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="screeningCeasesDate">Skjermingopphørerdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'screeningCeasesDate','errors')}">
                                    <g:datePicker name="screeningCeasesDate" value="${skjermingInstance?.screeningCeasesDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr>
														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="screeningCeasesDate">Klasser:</label>
                                </td>
                                <td valign="top" class="value">
																		<friark:mselect id="klasser" name="klasser" type="select" from="${Klass.list()}"/>  
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
