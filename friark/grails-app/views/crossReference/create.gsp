<%! import org.friark.ds.* %>


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
                                    <label for="toClass">Til Klass:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'toClass','errors')}">
                                    <g:select optionKey="id" from="${Klass.list()}" name="toClass.id" value="${kryssreferanseInstance?.toClass?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fromClass">Fra Klass:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'fromClass','errors')}">
                                    <g:select optionKey="id" from="${Klass.list()}" name="fromClass.id" value="${kryssreferanseInstance?.fromClass?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fromFile">Fra Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'fromFile','errors')}">
                                    <g:select optionKey="id" from="${BasicFile.list()}" name="fromFile.id" value="${kryssreferanseInstance?.fromFile?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="toFile">Til Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'toFile','errors')}">
                                    <g:select optionKey="id" from="${BasicFile.list()}" name="toFile.id" value="${kryssreferanseInstance?.toFile?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fromRecord">Fra Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'fromRecord','errors')}">
                                    <g:select optionKey="id" from="${SimplifiedRecord.list()}" name="fromRecord.id" value="${kryssreferanseInstance?.fromRecord?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="toRecord">Til Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:kryssreferanseInstance,field:'toRecord','errors')}">
                                    <g:select optionKey="id" from="${SimplifiedRecord.list()}" name="toRecord.id" value="${kryssreferanseInstance?.toRecord?.id}" noSelection="['null':'']"></g:select>
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
