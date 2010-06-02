<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit ClassificationSystem</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ClassificationSystem List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ClassificationSystem</g:link></span>
        </div>
        <div class="body">
            <h1>Edit ClassificationSystem</h1>
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
                                    <label for="classificationType">Klassifikasjonstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'classificationType','errors')}">
                                    <input type="text" id="classificationType" name="classificationType" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'classificationType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdDate">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'createdDate','errors')}">
                                    <g:datePicker name="createdDate" value="${klassifikasjonssystemInstance?.createdDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'createdBy')}"/>
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
