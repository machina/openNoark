<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Merknad</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Merknad List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Merknad</g:link></span>
        </div>
        <div class="body">
            <h1>Show Merknad</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:merknadInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Merknadstekst:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:merknadInstance, field:'remarkText')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Merknadsdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:merknadInstance, field:'remarkDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Merknadregistrertav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:merknadInstance, field:'remarkRegisteredBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="basisbasicFile" action="show" id="${merknadInstance?.basicFile?.id}">${merknadInstance?.basicFile?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Basis Registrering:</td>
                            
                            <td valign="top" class="value"><g:link controller="basisregistrering" action="show" id="${merknadInstance?.basicRecord?.id}">${merknadInstance?.basicRecord?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokument Beskrivelse:</td>
                            
                            <td valign="top" class="value"><g:link controller="documentDescription" action="show" id="${merknadInstance?.documentDescription?.id}">${merknadInstance?.documentDescription?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Merknadstype:</td>
                            
                            <td valign="top" class="value"><g:link controller="merknadType" action="show" id="${merknadInstance?.remarkType?.id}">${merknadInstance?.remarkType?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${merknadInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
