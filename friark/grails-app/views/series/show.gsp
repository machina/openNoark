<%! import no.friark.ds.* %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Arkivdel</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Arkivdel Liste</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">Ny Arkivdel</g:link></span>
        </div>
        <div class="body">
            <h1>Arkivdel</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
														<td valign="top" class="value">${arkivdel.systemID}</td>
                        </tr>
											
												<tr class="prop">
                            <td valign="top" class="name">Tittle:</td>
                            <td valign="top" class="value">${arkivdel.title}</td>
                        </tr>
 
												<tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            <td valign="top" class="value">${arkivdel.description}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Arkivdelstatus:</td>
                            <td valign="top" class="value">${arkivdel.recordSectionStatus}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Dokument medium:</td>
                            <td valign="top" class="value">${arkivdel.documentMedium}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Opprettet dato:</td>
                            <td valign="top" class="value">${arkivdel.createdDate}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Opprettet av:</td>
                            <td valign="top" class="value">${arkivdel.createdBy}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Avsluttet dato::</td>
                            <td valign="top" class="value">${arkivdel.finalisedDate}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Avsluttet av:</td>
                            <td valign="top" class="value">${arkivdel.finalisedBy}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Start arkivperiode:</td>
                            <td valign="top" class="value">${arkivdel.recordsPeriodStartDate}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Slutt arkivperiode:</td>
                            <td valign="top" class="value">${arkivdel.recordsPeriodEndDate}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Forelder arkiv:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.parent}"><g:link action="show" controller="arkiv" id="${arkivdel.parent.id}">${arkivdel.parent.title}</g:link></g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Forløper:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.precursor}"><g:link action="show" id="${arkivdel.precursor.id}">${arkivdel.precursor}</g:link></g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Arvtaker:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.successor}"><g:link action="show" id="${arkivdel.successor.id}">${arkivdel.successor}</g:link></g:if></td>
                        </tr>

		
												<tr class="prop">
                            <td valign="top" class="name">Klassifikasjonsystem:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.classificationSystem}"><g:link action="show" controller="klassifikasjonsSystem" id="${arkivdel.classificationSystem.id}">${arkivdel.classificationSystem}</g:link></g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Bevaring og kassasjon:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.preservationAndDisposal}"><g:link action="show" controller="bevaringOgKassasjon" id="${arkivdel.preservationAndDisposal.id}">${arkivdel.preservationAndDisposal}</g:link></g:if></td>
                        </tr>


												

												<tr class="prop">
                            <td valign="top" class="name">Oppbevaringssted:</td>
                            <td valign="top" class="value"><ul>
															<g:each in="${arkivdel.storageLocation}" var="sted">
																<li>${sted}</li>
															</g:each></ul>
														</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Mapper:</td>
                            <td valign="top" class="value"><ul>
                              <g:each in="${arkivdel.file}" var="mappe">
                                <li><g:link controller="basismappe" action="show" id="${mappe.id}">${mappe.title}</g:link></li>
                              </g:each></ul>
                            </td>
                        </tr>

											<tr class="prop">
                            <td valign="top" class="name">Registreringer:</td>
                            <td valign="top" class="value"><ul>
                              <g:each in="${arkivdel.record}" var="reg">
                                <li><g:link action="show" controller="registrering" id="${reg.id}">${reg}</g:link></li>
                              </g:each></ul>
                            </td>
                        </tr>


                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${arkivdel.id}" />
                    <span class="button"><g:actionSubmit id="${arkivdel.id}" class="edit" value="Edit" /> </span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
<%--								<g:form controller="merknad" action="create" method="get">
                    <input type="hidden" name="systemID" value="${arkiv?.systemID}" />
                    <span class="button"><g:submitButton class="create" name="create_merknad" value="Legg til merknad" /></span>
                </g:form> --%>
            </div>
        </div>
    </body>
</html>
