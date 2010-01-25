<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Dokumentobjekt</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Dokumentobjekt List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Dokumentobjekt</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Dokumentobjekt</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${dokumentobjektInstance}">
            <div class="errors">
                <g:renderErrors bean="${dokumentobjektInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${dokumentobjektInstance?.id}" />
                <input type="hidden" name="version" value="${dokumentobjektInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="versjonsnummer">Versjonsnummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'versjonsnummer','errors')}">
                                    <input type="text" id="versjonsnummer" name="versjonsnummer" value="${fieldValue(bean:dokumentobjektInstance,field:'versjonsnummer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="variantformat">Variantformat:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'variantformat','errors')}">
                                    <input type="text" id="variantformat" name="variantformat" value="${fieldValue(bean:dokumentobjektInstance,field:'variantformat')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="format">Format:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'format','errors')}">
                                    <input type="text" id="format" name="format" value="${fieldValue(bean:dokumentobjektInstance,field:'format')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="formatdetaljer">Formatdetaljer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'formatdetaljer','errors')}">
                                    <input type="text" id="formatdetaljer" name="formatdetaljer" value="${fieldValue(bean:dokumentobjektInstance,field:'formatdetaljer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${dokumentobjektInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:dokumentobjektInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansedokumentBeskrivelse">Dokumentbeskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'referansedokumentBeskrivelse','errors')}">
                                    <g:select optionKey="id" from="${Dokumentbeskrivelse.list()}" name="referansedokumentBeskrivelse.id" value="${dokumentobjektInstance?.referansedokumentBeskrivelse?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseregistrering">Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'referanseregistrering','errors')}">
                                    <g:select optionKey="id" from="${ForenkletRegistrering.list()}" name="referanseregistrering.id" value="${dokumentobjektInstance?.referanseregistrering?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansedokumentfil">Referansedokumentfil:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'referansedokumentfil','errors')}">
                                    <input type="text" id="referansedokumentfil" name="referansedokumentfil" value="${fieldValue(bean:dokumentobjektInstance,field:'referansedokumentfil')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sjekksumdokument">Sjekksumdokument:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'sjekksumdokument','errors')}">
                                    <input type="text" id="sjekksumdokument" name="sjekksumdokument" value="${fieldValue(bean:dokumentobjektInstance,field:'sjekksumdokument')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sjekksumalgoritme">Sjekksumalgoritme:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'sjekksumalgoritme','errors')}">
                                    <input type="text" id="sjekksumalgoritme" name="sjekksumalgoritme" value="${fieldValue(bean:dokumentobjektInstance,field:'sjekksumalgoritme')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="filstørrelse">Filstørrelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'filstørrelse','errors')}">
                                    <input type="text" id="filstørrelse" name="filstørrelse" value="${fieldValue(bean:dokumentobjektInstance,field:'filstørrelse')}"/>
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
