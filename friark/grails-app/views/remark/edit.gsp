<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Merknad</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Merknad List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Merknad</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Merknad</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${merknadInstance}">
            <div class="errors">
                <g:renderErrors bean="${merknadInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${merknadInstance?.id}" />
                <input type="hidden" name="version" value="${merknadInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkText">Merknadstekst:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkText','errors')}">
                                    <input type="text" id="remarkText" name="remarkText" value="${fieldValue(bean:merknadInstance,field:'remarkText')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkDate">Merknadsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkDate','errors')}">
                                    <g:datePicker name="remarkDate" value="${merknadInstance?.remarkDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkRegisteredBy">Merknadregistrertav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkRegisteredBy','errors')}">
                                    <input type="text" id="remarkRegisteredBy" name="remarkRegisteredBy" value="${fieldValue(bean:merknadInstance,field:'remarkRegisteredBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="basicFile">Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'basicFile','errors')}">
                                    <g:select optionKey="id" from="${BasicFile.list()}" name="basicFile.id" value="${merknadInstance?.basicFile?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="basicRecord">Basis Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'basicRecord','errors')}">
                                    <g:select optionKey="id" from="${BasicRecord.list()}" name="basicRecord.id" value="${merknadInstance?.basicRecord?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentDescription">Dokument Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'documentDescription','errors')}">
                                    <g:select optionKey="id" from="${DocumentDescription.list()}" name="documentDescription.id" value="${merknadInstance?.documentDescription?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkType">Merknadstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkType','errors')}">
                                    <g:select optionKey="id" from="${RemarkType.list()}" name="remarkType.id" value="${merknadInstance?.remarkType?.id}" ></g:select>
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
