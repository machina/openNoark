<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Documentdescription</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Documentdescription List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Documentdescription</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Documentdescription</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${documentDescriptionInstance}">
            <div class="errors">
                <g:renderErrors bean="${documentDescriptionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${documentDescriptionInstance?.id}" />
                <input type="hidden" name="version" value="${documentDescriptionInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentType">Documenttype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'documentType','errors')}">
                                    <input type="text" id="documentType" name="documentType" value="${fieldValue(bean:documentDescriptionInstance,field:'documentType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentStatus">Documentstatus:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'documentStatus','errors')}">
                                    <input type="text" id="documentStatus" name="documentStatus" value="${fieldValue(bean:documentDescriptionInstance,field:'documentStatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:documentDescriptionInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:documentDescriptionInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="author">Forfatter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'author','errors')}">
                                    <input type="text" id="author" name="author" value="${fieldValue(bean:documentDescriptionInstance,field:'author')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdDate">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'createdDate','errors')}">
                                    <g:datePicker name="createdDate" value="${documentDescriptionInstance?.createdDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:documentDescriptionInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentMedium">Documentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'documentMedium','errors')}">
                                    <input type="text" id="documentMedium" name="documentMedium" value="${fieldValue(bean:documentDescriptionInstance,field:'documentMedium')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="storageLocation">Oppbevaringssted:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'storageLocation','errors')}">
                                    <input type="text" id="storageLocation" name="storageLocation" value="${fieldValue(bean:documentDescriptionInstance,field:'storageLocation')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentObject">Referansedocument Objekt:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:documentDescriptionInstance,field:'documentObject','errors')}">
                                    
<ul>
<g:each var="r" in="${documentDescriptionInstance?.documentObject?}">
    <li><g:link controller="documentObject" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="documentObject" params="['documentDescription.id':documentDescriptionInstance?.id]" action="create">Add Documentobjekt</g:link>

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
