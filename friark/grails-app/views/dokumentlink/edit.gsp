<%! import no.friark.ds.* %>


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
                                    <label for="referanseregistrering">Referanseregistrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'referanseregistrering','errors')}">
                                    <g:select optionKey="id" from="${ForenkletRegistrering.list()}" name="referanseregistrering.id" value="${dokumentlinkInstance?.referanseregistrering?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tilknyttetregistreringSom">Tilknyttetregistrering Som:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'tilknyttetregistreringSom','errors')}">
                                    <input type="text" id="tilknyttetregistreringSom" name="tilknyttetregistreringSom" value="${fieldValue(bean:dokumentlinkInstance,field:'tilknyttetregistreringSom')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentnummer">Dokumentnummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'dokumentnummer','errors')}">
                                    <input type="text" id="dokumentnummer" name="dokumentnummer" value="${fieldValue(bean:dokumentlinkInstance,field:'dokumentnummer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tilknyttetdato">Tilknyttetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'tilknyttetdato','errors')}">
                                    <g:datePicker name="tilknyttetdato" value="${dokumentlinkInstance?.tilknyttetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tilknyttetav">Tilknyttetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'tilknyttetav','errors')}">
                                    <input type="text" id="tilknyttetav" name="tilknyttetav" value="${fieldValue(bean:dokumentlinkInstance,field:'tilknyttetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentbeskrivelse">Dokumentbeskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentlinkInstance,field:'dokumentbeskrivelse','errors')}">
                                    <g:select optionKey="id" from="${Dokumentbeskrivelse.list()}" name="dokumentbeskrivelse.id" value="${dokumentlinkInstance?.dokumentbeskrivelse?.id}" noSelection="['null':'']"></g:select>
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
