
<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Journalpost</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Registreingsliste</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">Ny registrering</g:link></span>
        </div>
        <div class="body">
            <h1>Show Journalpost</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:forenkletRegistreringInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">System ID:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:forenkletRegistreringInstance, field:'systemID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansearkivdel:</td>
                            
                            <td valign="top" class="value"><g:link controller="arkivdel" action="show" id="${forenkletRegistreringInstance?.referansearkivdel?.id}">${forenkletRegistreringInstance?.referansearkivdel?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseforelder Basismappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="basismappe" action="show" id="${forenkletRegistreringInstance?.referanseforelderBasismappe?.id}">${forenkletRegistreringInstance?.referanseforelderBasismappe?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Registreringstype:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:forenkletRegistreringInstance, field:'registreringstype')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:forenkletRegistreringInstance, field:'opprettetdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:forenkletRegistreringInstance, field:'opprettetav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Arkivertdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:forenkletRegistreringInstance, field:'arkivertdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Arkivertav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:forenkletRegistreringInstance, field:'arkivertav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseforelder Klasse:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${forenkletRegistreringInstance?.referanseforelderKlasse?.id}">${forenkletRegistreringInstance?.referanseforelderKlasse?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokumenter:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="d" in="${forenkletRegistreringInstance.dokumenter}">
                                    <li><g:link controller="dokumentlink" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansedokument Objekt:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${forenkletRegistreringInstance.referansedokumentObjekt}">
                                    <li><g:link controller="dokumentobjekt" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Bevaring Og Kassasjon:</td>
                            
                            <td valign="top" class="value"><g:link controller="bevaringOgKassasjon" action="show" id="${forenkletRegistreringInstance?.bevaringOgKassasjon?.id}">${forenkletRegistreringInstance?.bevaringOgKassasjon?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    
                    		<g:if test="${forenkletRegistreringInstance instanceof Basisregistrering}">
													<g:render template="basisreg_show"/>
												</g:if>
												<g:if test="${forenkletRegistreringInstance instanceof Journalpost}">
                          <g:render template="journalpost_show"/>
                        </g:if>
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${forenkletRegistreringInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
