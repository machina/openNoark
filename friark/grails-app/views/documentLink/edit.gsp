<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Dokumentlink</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Dokumentlink List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Dokumentlink</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Dokumentlink</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${dokumentlinkInstance}">
            <div class="errors">
                <g:renderErrors bean="${dokumentlinkInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${dokumentlinkInstance?.id}" />
                <input type="hidden" name="version" value="${dokumentlinkInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referenceRecord">Referanseregistrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'referenceRecord','errors')}">
                                    <g:select optionKey="id" from="${SimplifiedRecord.list()}" name="referenceRecord.id" value="${dokumentlinkInstance?.referenceRecord?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="linkedRecordAs">Tilknyttetregistrering Som:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'linkedRecordAs','errors')}">
                                    <input type="text" id="linkedRecordAs" name="linkedRecordAs" value="${fieldValue(bean:dokumentlinkInstance,field:'linkedRecordAs')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentNumber">Dokumentnummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'documentNumber','errors')}">
                                    <input type="text" id="documentNumber" name="documentNumber" value="${fieldValue(bean:dokumentlinkInstance,field:'documentNumber')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="linkedDate">Tilknyttetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'linkedDate','errors')}">
                                    <g:datePicker name="linkedDate" value="${dokumentlinkInstance?.linkedDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="linkedBy">Tilknyttetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'linkedBy','errors')}">
                                    <input type="text" id="linkedBy" name="linkedBy" value="${fieldValue(bean:dokumentlinkInstance,field:'linkedBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentDescription">Dokumentdescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'documentDescription','errors')}">
                                    <g:select optionKey="id" from="${DocumentDescription.list()}" name="documentDescription.id" value="${dokumentlinkInstance?.documentDescription?.id}" noSelection="['null':'']"></g:select>
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
