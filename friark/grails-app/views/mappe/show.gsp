<%! import no.friark.ds.* %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Basismappe</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Liste</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">Ny Mappe</g:link></span>
        </div>
        <div class="body">
            <h1>Show Basismappe</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'systemID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mappeid:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'fileID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mappetype:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'fileType')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tittel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'title')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Offentligtitle:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'officialTitle')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Nøkkelord:</td>
                            
                            <td valign="top" class="value">
															<ul>
															<g:each in="${basismappeInstance.keyword}">
																<li>${it}</li>
															</g:each>
															</ul>
														</td>
															
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokumentmedium:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'documentMedium')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Oppbevaringssted:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'storageLocation')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'createdDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'createdBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'finalisedDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'finalisedBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseparent Klasse:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${basismappeInstance?.parentClass?.id}">${basismappeInstance?.parentClass?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseparent Basismappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="mappe" action="show" id="${basismappeInstance?.parentFile?.id}">${basismappeInstance?.parentFile?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansebarn Basismappe:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${basismappeInstance.childFile}">
                                    <li><g:link controller="mappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansearkivdel:</td>
                            
                            <td valign="top" class="value"><g:link controller="arkivdel" action="show" id="${basismappeInstance?.recordSection?.id}">${basismappeInstance?.recordSection?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name">Registeringer</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${basismappeInstance.childRecord}">
                                    <li><g:link controller="registrering" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
											<tr class="prop">
                            <td valign="top" class="name">Merknader</td>
														<td  valign="top" style="text-align:left;" class="value">
                                <ul>
																	<g:each var="m" in="${basismappeInstance.merknad}">
																		<li><g:link controller="merknad" action="show" id="${m.id}">${r?.encodeAsHTML()}</g:link></li>
																	</g:each>
																</ul>
														</td>
																
											</tr>
 
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${basismappeInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
								<g:form controller="registrering" action="create" method="get">
										<input type="hidden" name="mappe_id" value="${basismappeInstance?.id}" />
										<span class="button"><g:submitButton class="create" name="create" value="Legg til registrering" /></span>
								</g:form>
								<g:form controller="merknad" action="create" method="get">
                    <input type="hidden" name="systemID" value="${basismappeInstance?.systemID}" />
                    <span class="button"><g:submitButton class="create" name="create_merknad" value="Legg til merknad" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
