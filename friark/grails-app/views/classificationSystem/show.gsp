<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show ClassificationSystem</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ClassificationSystem List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ClassificationSystem</g:link></span>
        </div>
        <div class="body">
            <h1>Show ClassificationSystem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'systemID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Klassifikasjonstype:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'classificationType')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tittel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'title')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'createdDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'createdBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'finalisedDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klassifikasjonssystemInstance, field:'finalisedBy')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${klassifikasjonssystemInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
