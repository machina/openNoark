<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Kryssreferanse</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Kryssreferanse List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Kryssreferanse</g:link></span>
        </div>
        <div class="body">
            <h1>Show Kryssreferanse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:kryssreferanseInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Til Klass:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${kryssreferanseInstance?.toClass?.id}">${kryssreferanseInstance?.toClass?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fra Klass:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${kryssreferanseInstance?.fromClass?.id}">${kryssreferanseInstance?.fromClass?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fra Mappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="mappe" action="show" id="${kryssreferanseInstance?.fromFile?.id}">${kryssreferanseInstance?.fromFile?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Til Mappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="mappe" action="show" id="${kryssreferanseInstance?.toFile?.id}">${kryssreferanseInstance?.toFile?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fra Registrering:</td>
                            
                            <td valign="top" class="value"><g:link controller="registrering" action="show" id="${kryssreferanseInstance?.fromRecord?.id}">${kryssreferanseInstance?.fromRecord?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Til Registrering:</td>
                            
                            <td valign="top" class="value"><g:link controller="registrering" action="show" id="${kryssreferanseInstance?.toRecord?.id}">${kryssreferanseInstance?.toRecord?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${kryssreferanseInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
