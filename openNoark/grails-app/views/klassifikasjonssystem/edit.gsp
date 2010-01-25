<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Klassifikasjonssystem</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Klassifikasjonssystem List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Klassifikasjonssystem</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Klassifikasjonssystem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${klassifikasjonssystemInstance}">
            <div class="errors">
                <g:renderErrors bean="${klassifikasjonssystemInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${klassifikasjonssystemInstance?.id}" />
                <input type="hidden" name="version" value="${klassifikasjonssystemInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klassifikasjonstype">Klassifikasjonstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'klassifikasjonstype','errors')}">
                                    <input type="text" id="klassifikasjonstype" name="klassifikasjonstype" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'klassifikasjonstype')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tittel">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'tittel','errors')}">
                                    <input type="text" id="tittel" name="tittel" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'tittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beskrivelse">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'beskrivelse','errors')}">
                                    <input type="text" id="beskrivelse" name="beskrivelse" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'beskrivelse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${klassifikasjonssystemInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="avsluttetdato">Avsluttetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'avsluttetdato','errors')}">
                                    <g:datePicker name="avsluttetdato" value="${klassifikasjonssystemInstance?.avsluttetdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="avsluttetav">Avsluttetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'avsluttetav','errors')}">
                                    <input type="text" id="avsluttetav" name="avsluttetav" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'avsluttetav')}"/>
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
