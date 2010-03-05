<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Merknad</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Merknad List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Merknad</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${merknadInstance}">
            <div class="errors">
                <g:renderErrors bean="${merknadInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                                    <g:datePicker name="merknadsdato" value="${merknadInstance?.merknadsdato}" precision="day" ></g:datePicker>
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
                                    <label for="merknadstype">Merknadstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'merknadstype','errors')}">
                                    <g:select optionKey="id" optionValue="navn" from="${MerknadType.list()}" name="merknadstype.id" noSelection="${[null:'Velg type']}" value="${merknadInstance?.merknadstype?.id}" ></g:select>
                                </td>
                            </tr> 
														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="merknadstype">Baismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'mappe','errors')}">
                                    <g:select optionKey="id" optionValue="tittel" from="${Basismappe.list()}" name="mappe.id" noSelection="${[null:'Velg type']}" value="${merknadInstance?.mappe?.id}" ></g:select>
                                </td>
                            </tr> 
														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="merknadstype">Dokumentbeskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'dokumentBeskrivelse','errors')}">
                                    <g:select optionKey="id" optionValue="systemID" from="${Dokumentbeskrivelse.list()}" name="dokumentBeskrivelse.id" noSelection="${[null:'Velg type']}" value="${merknadInstance?.dokumentBeskrivelse?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
