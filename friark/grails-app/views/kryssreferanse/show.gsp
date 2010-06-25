<%! import no.friark.ds.* %>


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
                            <td valign="top" class="name">Til Klasse:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${kryssreferanseInstance?.tilKlasse?.id}">${kryssreferanseInstance?.tilKlasse?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fra Klasse:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${kryssreferanseInstance?.fraKlasse?.id}">${kryssreferanseInstance?.fraKlasse?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fra Mappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="mappe" action="show" id="${kryssreferanseInstance?.fraMappe?.id}">${kryssreferanseInstance?.fraMappe?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Til Mappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="mappe" action="show" id="${kryssreferanseInstance?.tilMappe?.id}">${kryssreferanseInstance?.tilMappe?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fra Registrering:</td>
                            
                            <td valign="top" class="value"><g:link controller="forenkletRegistrering" action="show" id="${kryssreferanseInstance?.fraRegistrering?.id}">${kryssreferanseInstance?.fraRegistrering?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Til Registrering:</td>
                            
                            <td valign="top" class="value"><g:link controller="forenkletRegistrering" action="show" id="${kryssreferanseInstance?.tilRegistrering?.id}">${kryssreferanseInstance?.tilRegistrering?.encodeAsHTML()}</g:link></td>
                            
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
