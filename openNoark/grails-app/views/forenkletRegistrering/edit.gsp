

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit ForenkletRegistrering</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ForenkletRegistrering List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ForenkletRegistrering</g:link></span>
        </div>
        <div class="body">
            <h1>Edit ForenkletRegistrering</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${forenkletRegistreringInstance}">
            <div class="errors">
                <g:renderErrors bean="${forenkletRegistreringInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${forenkletRegistreringInstance?.id}" />
                <input type="hidden" name="version" value="${forenkletRegistreringInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="systemID">SystemID:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'systemID','errors')}">
                                    <input type="text" id="systemID" name="systemID" value="${fieldValue(bean:forenkletRegistreringInstance,field:'systemID')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="registreringstype">Registreringstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'registreringstype','errors')}">
                                    <input type="text" id="registreringstype" name="registreringstype" value="${fieldValue(bean:forenkletRegistreringInstance,field:'registreringstype')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${forenkletRegistreringInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:forenkletRegistreringInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivertdato">Arkivertdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'arkivertdato','errors')}">
                                    <g:datePicker name="arkivertdato" value="${forenkletRegistreringInstance?.arkivertdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivertav">Arkivertav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'arkivertav','errors')}">
                                    <input type="text" id="arkivertav" name="arkivertav" value="${fieldValue(bean:forenkletRegistreringInstance,field:'arkivertav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderBasismappe">Referanseforelder Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referanseforelderBasismappe','errors')}">
                                    <g:select optionKey="id" from="${Basismappe.list()}" name="referanseforelderBasismappe.id" value="${forenkletRegistreringInstance?.referanseforelderBasismappe?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlasse">Referanseforelder Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referanseforelderKlasse','errors')}">
                                    <g:select optionKey="id" from="${Klasse.list()}" name="referanseforelderKlasse.id" value="${forenkletRegistreringInstance?.referanseforelderKlasse?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansearkivdel">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referansearkivdel','errors')}">
                                    <g:select optionKey="id" from="${Arkivdel.list()}" name="referansearkivdel.id" value="${forenkletRegistreringInstance?.referansearkivdel?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansedokumentBeskrivelse">Referansedokument Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referansedokumentBeskrivelse','errors')}">
                                    <g:select name="referansedokumentBeskrivelse"
from="${Dokumentbeskrivelse.list()}"
size="5" multiple="yes" optionKey="id"
value="${forenkletRegistreringInstance?.referansedokumentBeskrivelse}" />

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansedokumentObjekt">Referansedokument Objekt:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referansedokumentObjekt','errors')}">
                                    
<ul>
<g:each var="r" in="${forenkletRegistreringInstance?.referansedokumentObjekt?}">
    <li><g:link controller="dokumentobjekt" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="dokumentobjekt" params="['forenkletRegistrering.id':forenkletRegistreringInstance?.id]" action="create">Add Dokumentobjekt</g:link>

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
