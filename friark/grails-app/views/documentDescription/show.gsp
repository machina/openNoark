<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Documentdescription</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Documentdescription List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Documentdescription</g:link></span>
        </div>
        <div class="body">
            <h1>Show Documentdescription</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'systemID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Documenttype:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'documentType')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Documentstatus:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'documentStatus')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tittel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'title')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Forfatter:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'author')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'createdDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'createdBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Documentmedium:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'documentMedium')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Oppbevaringssted:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'storageLocation')}</td>
                            
                        </tr>
                    
												<tr class="prop">
                            <td valign="top" class="name">Kassert:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'disposalDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Kassert av:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:documentDescriptionInstance, field:'disposedBy')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Referansedocument Objekt:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${documentDescriptionInstance.documentObject}">
                                    <li><g:link controller="documentObject" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Registreringer:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${documentDescriptionInstance.records}">
                                    <li><g:link controller="registrering" action="show" id="${r.referenceRecord.id}">${r?.referenceRecord?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>

                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${documentDescriptionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
