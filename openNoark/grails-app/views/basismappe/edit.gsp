

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
                                    <label for="tittel">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'tittel','errors')}">
                                    <input type="text" id="tittel" name="tittel" value="${fieldValue(bean:basismappeInstance,field:'tittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="offentligtittel">Offentligtittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'offentligtittel','errors')}">
                                    <input type="text" id="offentligtittel" name="offentligtittel" value="${fieldValue(bean:basismappeInstance,field:'offentligtittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beskrivelse">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'beskrivelse','errors')}">
                                    <input type="text" id="beskrivelse" name="beskrivelse" value="${fieldValue(bean:basismappeInstance,field:'beskrivelse')}"/>
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
                                    <label for="dokumentmedium">Dokumentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'dokumentmedium','errors')}">
                                    <input type="text" id="dokumentmedium" name="dokumentmedium" value="${fieldValue(bean:basismappeInstance,field:'dokumentmedium')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="oppbevaringssted">Oppbevaringssted:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'oppbevaringssted','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${basismappeInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:basismappeInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="avsluttetdato">Avsluttetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'avsluttetdato','errors')}">
                                    <g:datePicker name="avsluttetdato" value="${basismappeInstance?.avsluttetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="avsluttetav">Avsluttetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'avsluttetav','errors')}">
                                    <input type="text" id="avsluttetav" name="avsluttetav" value="${fieldValue(bean:basismappeInstance,field:'avsluttetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlasse">Referanseforelder Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseforelderKlasse','errors')}">
                                    <g:select optionKey="id" from="${Klasse.list()}" name="referanseforelderKlasse.id" value="${basismappeInstance?.referanseforelderKlasse?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderBasismappe">Referanseforelder Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseforelderBasismappe','errors')}">
                                    <g:select optionKey="id" from="${Basismappe.list()}" name="referanseforelderBasismappe.id" value="${basismappeInstance?.referanseforelderBasismappe?.id}" ></g:select>
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
                                    <g:select optionKey="id" from="${Arkivdel.list()}" name="referansearkivdel.id" value="${basismappeInstance?.referansearkivdel?.id}" optionvalue="tittel" ></g:select>
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
