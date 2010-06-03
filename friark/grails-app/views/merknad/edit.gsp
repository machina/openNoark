<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Merknad</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Merknad List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Merknad</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Merknad</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${merknadInstance}">
            <div class="errors">
                <g:renderErrors bean="${merknadInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${merknadInstance?.id}" />
                <input type="hidden" name="version" value="${merknadInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="merknadstekst">Merknadstekst:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'merknadstekst','errors')}">
                                    <input type="text" id="merknadstekst" name="merknadstekst" value="${fieldValue(bean:merknadInstance,field:'merknadstekst')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="merknadsdato">Merknadsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'merknadsdato','errors')}">
                                    <g:datePicker name="merknadsdato" value="${merknadInstance?.merknadsdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="merknadregistrertav">Merknadregistrertav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'merknadregistrertav','errors')}">
                                    <input type="text" id="merknadregistrertav" name="merknadregistrertav" value="${fieldValue(bean:merknadInstance,field:'merknadregistrertav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappe">Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'mappe','errors')}">
                                    <g:select optionKey="id" from="${Basismappe.list()}" name="mappe.id" value="${merknadInstance?.mappe?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="basisRegistrering">Basis Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'basisRegistrering','errors')}">
                                    <g:select optionKey="id" from="${Basisregistrering.list()}" name="basisRegistrering.id" value="${merknadInstance?.basisRegistrering?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentBeskrivelse">Dokument Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'dokumentBeskrivelse','errors')}">
                                    <g:select optionKey="id" from="${DocumentDescription.list()}" name="dokumentBeskrivelse.id" value="${merknadInstance?.dokumentBeskrivelse?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="merknadstype">Merknadstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'merknadstype','errors')}">
                                    <g:select optionKey="id" from="${MerknadType.list()}" name="merknadstype.id" value="${merknadInstance?.merknadstype?.id}" ></g:select>
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
