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
                                    <label for="versionNumber">Versjonsnummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'versionNumber','errors')}">
                                    <input type="text" id="versionNumber" name="versionNumber" value="${fieldValue(bean:dokumentobjektInstance,field:'versionNumber')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="variantFormat">Variantformat:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'variantFormat','errors')}">
                                    <input type="text" id="variantFormat" name="variantFormat" value="${fieldValue(bean:dokumentobjektInstance,field:'variantFormat')}"/>
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
                                    <label for="formatDetails">Formatdetaljer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'formatDetails','errors')}">
                                    <input type="text" id="formatDetails" name="formatDetails" value="${fieldValue(bean:dokumentobjektInstance,field:'formatDetails')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdDate">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'createdDate','errors')}">
                                    <g:datePicker name="createdDate" value="${dokumentobjektInstance?.createdDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:dokumentobjektInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentDescription">DocumentDescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'documentDescription','errors')}">
                                    <g:select optionKey="id" from="${DocumentDescription.list()}" name="documentDescription.id" value="${dokumentobjektInstance?.documentDescription?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="record">Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'record','errors')}">
                                    <g:select optionKey="id" from="${SimplifiedRecord.list()}" name="record.id" value="${dokumentobjektInstance?.record?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentFile">Referansedokumentfil:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'documentFile','errors')}">
                                    <input type="text" id="documentFile" name="documentFile" value="${fieldValue(bean:dokumentobjektInstance,field:'documentFile')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="checksum">Sjekksumdokument:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'checksum','errors')}">
                                    <input type="text" id="checksum" name="checksum" value="${fieldValue(bean:dokumentobjektInstance,field:'checksum')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="checksumAlgorithm">Sjekksumalgoritme:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'checksumAlgorithm','errors')}">
                                    <input type="text" id="checksumAlgorithm" name="checksumAlgorithm" value="${fieldValue(bean:dokumentobjektInstance,field:'checksumAlgorithm')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fileSize">Filstørrelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentobjektInstance,field:'fileSize','errors')}">
                                    <input type="text" id="fileSize" name="fileSize" value="${fieldValue(bean:dokumentobjektInstance,field:'fileSize')}"/>
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
