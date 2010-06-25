<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit MerknadType</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">MerknadType List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New MerknadType</g:link></span>
        </div>
        <div class="body">
            <h1>Edit MerknadType</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${merknadTypeInstance}">
            <div class="errors">
                <g:renderErrors bean="${merknadTypeInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${merknadTypeInstance?.id}" />
                <input type="hidden" name="version" value="${merknadTypeInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Navn:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadTypeInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:merknadTypeInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="merknad">Merknad:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadTypeInstance,field:'merknad','errors')}">
                                    
<ul>
<g:each var="m" in="${merknadTypeInstance?.merknad?}">
    <li><g:link controller="merknad" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="merknad" params="['merknadType.id':merknadTypeInstance?.id]" action="create">Add Merknad</g:link>

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
