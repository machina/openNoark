<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Klasse</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Klasse List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Klasse</g:link></span>
        </div>
        <div class="body">
            <h1>Show Klasse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'systemID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Klasseid:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'klasseid')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tittel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'tittel')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'beskrivelse')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Nøkkelord:</td>
                            
                            <td valign="top" class="value">
															<ul>
																		<g:each in="${klasseInstance.nøkkelord}" var="ord">
																			<li>${ord}</li>
																		</g:each>
																	</ul>   
														</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'opprettetdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'opprettetav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'avsluttetdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'avsluttetav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseforelder Klassifikasjonssystem:</td>
                            
                            <td valign="top" class="value"><g:link controller="klassifikasjonssystem" action="show" id="${klasseInstance?.referanseforelderKlassifikasjonssystem?.id}">${klasseInstance?.referanseforelderKlassifikasjonssystem?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseforelder Klasse:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${klasseInstance?.referanseforelderKlasse?.id}">${klasseInstance?.referanseforelderKlasse?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansebarn Klasse:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${klasseInstance.referansebarnKlasse}">
                                    <li><g:link controller="klasse" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    <tr class="prop">
                            <td valign="top" class="name">Bevaring og kassasjon:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:klasseInstance, field:'bevaringOgKassasjon')}</td>
                            
                        </tr>

                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${klasseInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
