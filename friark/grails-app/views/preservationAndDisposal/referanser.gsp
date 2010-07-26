<%! import org.friark.ds.* %>


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
																	<g:select optionKey="id" from="${DocumentDescription.list()}" name="documentDescription.id" noSelection="['null':'']"></g:select>
                                </td>
                          </tr>
						              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="record">Registrering:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${SimplifiedRecord.list()}" name="record.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="series">Arkivdel:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${Series.list()}" name="series.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="file">Mappe:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${BasicFile.list()}" name="file.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klass">Klass:</label>
                                </td>
                                <td valign="top" class="value">
																	<g:select optionKey="id" from="${Klass.list()}" name="klass.id" noSelection="['null':'']"></g:select>
                                </td>
                            </tr>
										</tbody>
									</table>
									<div class="buttons">
										<g:hiddenField name="id" value="${preservationAndDisposalInstance.id}"/>
                    <span class="button"><input class="save" type="submit" value="Legg til" /></span>
                </div>

								</g:form>
 								  <table>
                    <tbody>
												<tr class="prop">
                            <td valign="top" class="name">Dokumenter:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="d" in="${preservationAndDisposalInstance.documentDescription}">
                                    <li><g:link controller="DocumentDescription" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Registreringer:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${preservationAndDisposalInstance.record}">
                                    <li><g:link controller="registrering" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
    
                        <tr class="prop">
                            <td valign="top" class="name">Arkivdeler:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="a" in="${preservationAndDisposalInstance.series}">
                                    <li><g:link controller="series" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mapper:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="m" in="${preservationAndDisposalInstance.file}">
                                    <li><g:link controller="file" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
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

