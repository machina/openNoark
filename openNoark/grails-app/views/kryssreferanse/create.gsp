

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Kryssreferanse</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Kryssreferanse List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Kryssreferanse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${kryssreferanseInstance}">
            <div class="errors">
                <g:renderErrors bean="${kryssreferanseInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tilKlasse">Til Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'tilKlasse','errors')}">
                                    <g:select optionKey="id" from="${Klasse.list()}" name="tilKlasse.id" value="${kryssreferanseInstance?.tilKlasse?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fraKlasse">Fra Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'fraKlasse','errors')}">
                                    <g:select optionKey="id" from="${Klasse.list()}" name="fraKlasse.id" value="${kryssreferanseInstance?.fraKlasse?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fraMappe">Fra Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'fraMappe','errors')}">
                                    <g:select optionKey="id" from="${Basismappe.list()}" name="fraMappe.id" value="${kryssreferanseInstance?.fraMappe?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tilMappe">Til Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'tilMappe','errors')}">
                                    <g:select optionKey="id" from="${Basismappe.list()}" name="tilMappe.id" value="${kryssreferanseInstance?.tilMappe?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fraRegistrering">Fra Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'fraRegistrering','errors')}">
                                    <g:select optionKey="id" from="${ForenkletRegistrering.list()}" name="fraRegistrering.id" value="${kryssreferanseInstance?.fraRegistrering?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tilRegistrering">Til Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'tilRegistrering','errors')}">
                                    <g:select optionKey="id" from="${ForenkletRegistrering.list()}" name="tilRegistrering.id" value="${kryssreferanseInstance?.tilRegistrering?.id}" noSelection="['null':'']"></g:select>
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
