<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Dokumentobjekt</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Dokumentobjekt List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Dokumentobjekt</g:link></span>
        </div>
        <div class="body">
            <h1>Show Dokumentobjekt</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'systemID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Versjonsnummer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'versjonsnummer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Variantformat:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'variantformat')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Format:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'format')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Formatdetaljer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'formatdetaljer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'opprettetdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'opprettetav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansedokument Beskrivelse:</td>
                            
                            <td valign="top" class="value"><g:link controller="dokumentbeskrivelse" action="show" id="${dokumentobjektInstance?.referansedokumentBeskrivelse?.id}">${dokumentobjektInstance?.referansedokumentBeskrivelse?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseregistrering:</td>
                            
                            <td valign="top" class="value"><g:link controller="forenkletRegistrering" action="show" id="${dokumentobjektInstance?.referanseregistrering?.id}">${dokumentobjektInstance?.referanseregistrering?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansedokumentfil:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'referansedokumentfil')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sjekksumdokument:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'sjekksumdokument')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sjekksumalgoritme:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'sjekksumalgoritme')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Filstørrelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentobjektInstance, field:'filstørrelse')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${dokumentobjektInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
