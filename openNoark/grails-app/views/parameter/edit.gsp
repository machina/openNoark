
<%@ page import="no.friark.ds.Parameter" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Parameter</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Parameter List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Parameter</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Parameter</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${parameterInstance}">
            <div class="errors">
                <g:renderErrors bean="${parameterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${parameterInstance?.id}" />
                <input type="hidden" name="version" value="${parameterInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="key">Key:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:parameterInstance,field:'key','errors')}">
                                    <input type="text" id="key" name="key" value="${fieldValue(bean:parameterInstance,field:'key')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="value">Value:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:parameterInstance,field:'value','errors')}">
                                    <input type="text" id="value" name="value" value="${fieldValue(bean:parameterInstance,field:'value')}"/>
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
