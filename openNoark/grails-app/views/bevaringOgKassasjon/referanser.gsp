<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show BevaringOgKassasjon</title>
    </head>
    <body>

        <div class="nav">
            <%-- <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span> --%>
            <span class="menuButton"><g:link class="list" action="list">BevaringOgKassasjon List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New BevaringOgKassasjon</g:link></span>
        </div>
        <div class="body">
            <h1>Show BevaringOgKassasjon</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
							<g:form action="referanser">
						     <table>
  		             <tbody>
													<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentobjekt">Dokument:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${Dokumentbeskrivelse.list()}" name="dokumentBeskrivelse.id" noSelection="['null':'']"></g:select>
                                </td>
                          </tr>
						              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="registrering">Registrering:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${ForenkletRegistrering.list()}" name="referanseregistrering.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivdel">Arkivdel:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${Arkivdel.list()}" name="arkivdel.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappe">Mappe:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${Basismappe.list()}" name="basismappe.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klasse">Klasse:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${Klasse.list()}" name="klasse.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>
										</tbody>
									</table>
									<div class="buttons">
										<g:hiddenField name="id" value="${bevaringOgKassasjonInstance.id}"/>
                    <span class="button"><input class="save" type="submit" value="Legg til" /></span>
                </div>

								</g:form>
 								  <table>
                    <tbody>
												<tr class="prop">
                            <td valign="top" class="name">Dokumenter:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="d" in="${bevaringOgKassasjonInstance.dokumentBeskrivelse}">
                                    <li><g:link controller="Dokumentbeskrivelse" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Registreringer:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${bevaringOgKassasjonInstance.registrering}">
                                    <li><g:link controller="forenkletRegistrering" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
    
                        <tr class="prop">
                            <td valign="top" class="name">Arkivdeler:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="a" in="${bevaringOgKassasjonInstance.arkivdel}">
                                    <li><g:link controller="arkivdel" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mapper:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="m" in="${bevaringOgKassasjonInstance.mappe}">
                                    <li><g:link controller="basismappe" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table> 
            </div>
        </div>
    </body>
</html>     

