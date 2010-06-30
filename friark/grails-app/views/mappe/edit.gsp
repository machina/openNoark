<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Basismappe</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Basismappe List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Basismappe</g:link></span>
        </div>
        <div class="body">
            <h1>Edit mappe</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${basismappeInstance}">
            <div class="errors">
                <g:renderErrors bean="${basismappeInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${basismappeInstance?.id}" />
                <input type="hidden" name="version" value="${basismappeInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="systemID">SystemID:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'systemID','errors')}">
                                    ${fieldValue(bean:basismappeInstance,field:'systemID')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fileType">Mappetype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'fileType','errors')}">
                                    ${fieldValue(bean:basismappeInstance,field:'fileType')}
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:basismappeInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officialTitle">Offentligtitle:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'officialTitle','errors')}">
                                    <input type="text" id="officialTitle" name="officialTitle" value="${fieldValue(bean:basismappeInstance,field:'officialTitle')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:basismappeInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                        
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nøkkelord">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'nøkkelord','errors')}">
                                 	<ul>
																		<g:each in="${basismappeInstance.keyword}" var="ord">
																			<li>${ord}</li>
																		</g:each>
																			<li><g:link controller="keyword" action="edit" id="${basismappeInstance.systemID}">Rediger nøkkelord</g:link>
																	</ul> 
                                </td>
                            </tr> 
                        		
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentMedium">Dokumentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'documentMedium','errors')}">
                                    <input type="text" id="documentMedium" name="documentMedium" value="${fieldValue(bean:basismappeInstance,field:'documentMedium')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="storageLocation">Oppbevaringssted:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'storageLocation','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdDate">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'createdDate','errors')}">
                                    <g:datePicker name="createdDate" value="${basismappeInstance?.createdDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:basismappeInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="finalisedDate">Avsluttetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'finalisedDate','errors')}">
                                    <g:datePicker name="finalisedDate" value="${basismappeInstance?.finalisedDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="finalisedBy">Avsluttetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'finalisedBy','errors')}">
                                    <input type="text" id="finalisedBy" name="finalisedBy" value="${fieldValue(bean:basismappeInstance,field:'finalisedBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentClass">Referanseparent Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'parentClass','errors')}">
                                    <g:select optionKey="id" from="${Klass.list()}" name="parentClass.id" value="${basismappeInstance?.parentClass?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentFile">Referanseparent Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'parentFile','errors')}">
                                    <g:select optionKey="id" from="${BasicFile.list()}" name="parentFile.id" value="${basismappeInstance?.parentFile?.id}" ></g:select>
                                </td>
                            </tr> 
                       <%-- 
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="childFile">Referansebarn Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'childFile','errors')}">
                                    
<ul>
<g:each var="r" in="${basismappeInstance?.childFile?}">
    <li><g:link controller="mappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="mappe" params="['basismappe.id':basismappeInstance?.id]" action="create">Add Basismappe</g:link>

                                </td>
                            </tr>  --%>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="recordSection">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'recordSection','errors')}">
                                    <g:select optionKey="id" from="${Series.list()}" name="recordSection.id" value="${basismappeInstance?.recordSection?.id}" optionvalue="title" ></g:select>
                                </td>
                            </tr> 
                        		<g:if test="${basismappeInstance.fileType == 'Saksmappe'}">
															<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nøkkelord">Sekundærklasser:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'secondaryClassification','errors')}">
                                  <ul>
                                    <g:each in="${basismappeInstance.secondaryClassification}" var="klasse">
                                      <li>${klasse.title}</li>
                                    </g:each>
                                      <li><g:link controller="mappe" action="sekundærKlasse" id="${basismappeInstance.id}">Rediger sekundærklasser</g:link>
                                  </ul>
                                </td>
															</tr>
														</g:if>
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
