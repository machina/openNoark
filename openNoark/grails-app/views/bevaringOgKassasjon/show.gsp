<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show BevaringOgKassasjon</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">BevaringOgKassasjon List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New BevaringOgKassasjon</g:link></span>
        </div>
        <div class="body">
            <h1>Show BevaringOgKassasjon</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:bevaringOgKassasjonInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Kassasjonsvedtak:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:bevaringOgKassasjonInstance, field:'kassasjonsvedtak')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Kassasjonshjemmel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:bevaringOgKassasjonInstance, field:'kassasjonshjemmel')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Bevaringstid:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:bevaringOgKassasjonInstance, field:'bevaringstid')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Kassasjonsdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:bevaringOgKassasjonInstance, field:'kassasjonsdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Registrering:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${bevaringOgKassasjonInstance.registrering}">
                                    <li><g:link controller="forenkletRegistrering" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Arkivdel:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="a" in="${bevaringOgKassasjonInstance.arkivdel}">
                                    <li><g:link controller="arkivdel" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mappe:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="m" in="${bevaringOgKassasjonInstance.mappe}">
                                    <li><g:link controller="basismappe" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Klasse:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="k" in="${bevaringOgKassasjonInstance.klasse}">
                                    <li><g:link controller="klasse" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokument Beskrivelse:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="d" in="${bevaringOgKassasjonInstance.dokumentBeskrivelse}">
                                    <li><g:link controller="dokumentbeskrivelse" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${bevaringOgKassasjonInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:link class="edit" action="referanser" id="${bevaringOgKassasjonInstance?.id}" value="Referanser">Referanser</g:link></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
