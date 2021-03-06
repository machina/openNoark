
<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Skjerming</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Skjerming List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Skjerming</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Skjerming</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${skjermingInstance}">
            <div class="errors">
                <g:renderErrors bean="${skjermingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${skjermingInstance?.id}" />
                <input type="hidden" name="version" value="${skjermingInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tilgangsrestriksjon">Tilgangsrestriksjon:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'tilgangsrestriksjon','errors')}">
                                    <input type="text" id="tilgangsrestriksjon" name="tilgangsrestriksjon" value="${fieldValue(bean:skjermingInstance,field:'tilgangsrestriksjon')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="skjermingshjemmel">Skjermingshjemmel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'skjermingshjemmel','errors')}">
                                    <input type="text" id="skjermingshjemmel" name="skjermingshjemmel" value="${fieldValue(bean:skjermingInstance,field:'skjermingshjemmel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="skjermingmetadata">Skjermingmetadata:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'skjermingmetadata','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="skjermingdokument">Skjermingdokument:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'skjermingdokument','errors')}">
                                    <input type="text" id="skjermingdokument" name="skjermingdokument" value="${fieldValue(bean:skjermingInstance,field:'skjermingdokument')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="skjermingsvarighet">Skjermingsvarighet:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'skjermingsvarighet','errors')}">
                                    <input type="text" id="skjermingsvarighet" name="skjermingsvarighet" value="${fieldValue(bean:skjermingInstance,field:'skjermingsvarighet')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="skjermingopphørerdato">Skjermingopphørerdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:skjermingInstance,field:'skjermingopphørerdato','errors')}">
                                    <g:datePicker name="skjermingopphørerdato" value="${skjermingInstance?.skjermingopphørerdato}" precision="minute" ></g:datePicker>
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
