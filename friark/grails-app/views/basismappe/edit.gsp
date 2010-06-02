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
            <h1>Edit Basismappe</h1>
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
                                    <input type="text" id="systemID" name="systemID" value="${fieldValue(bean:basismappeInstance,field:'systemID')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappeid">Mappeid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'mappeid','errors')}">
                                    <input type="text" id="mappeid" name="mappeid" value="${fieldValue(bean:basismappeInstance,field:'mappeid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappetype">Mappetype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'mappetype','errors')}">
                                    <input type="text" id="mappetype" name="mappetype" value="${fieldValue(bean:basismappeInstance,field:'mappetype')}"/>
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
                                    <label for="offentligtitle">Offentligtitle:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'offentligtitle','errors')}">
                                    <input type="text" id="offentligtitle" name="offentligtitle" value="${fieldValue(bean:basismappeInstance,field:'offentligtitle')}"/>
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
																		<g:each in="${basismappeInstance.nøkkelord}" var="ord">
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
                                    <label for="referanseparentKlasse">Referanseparent Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseparentKlasse','errors')}">
                                    <g:select optionKey="id" from="${Klasse.list()}" name="referanseparentKlasse.id" value="${basismappeInstance?.referanseparentKlasse?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseparentBasismappe">Referanseparent Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseparentBasismappe','errors')}">
                                    <g:select optionKey="id" from="${Basismappe.list()}" name="referanseparentBasismappe.id" value="${basismappeInstance?.referanseparentBasismappe?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansebarnBasismappe">Referansebarn Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referansebarnBasismappe','errors')}">
                                    
<ul>
<g:each var="r" in="${basismappeInstance?.referansebarnBasismappe?}">
    <li><g:link controller="basismappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="basismappe" params="['basismappe.id':basismappeInstance?.id]" action="create">Add Basismappe</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansearkivdel">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referansearkivdel','errors')}">
                                    <g:select optionKey="id" from="${Series.list()}" name="referansearkivdel.id" value="${basismappeInstance?.referansearkivdel?.id}" optionvalue="title" ></g:select>
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
