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
                            <td valign="top" class="value">${arkivdel.tittel}</td>
                        </tr>
 
												<tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            <td valign="top" class="value">${arkivdel.beskrivelse}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Arkivdelstatus:</td>
                            <td valign="top" class="value">${arkivdel.arkivdelstatus}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Dokument medium:</td>
                            <td valign="top" class="value">${arkivdel.dokumentmedium}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Opprettet dato:</td>
                            <td valign="top" class="value">${arkivdel.opprettetdato}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Opprettet av:</td>
                            <td valign="top" class="value">${arkivdel.opprettetav}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Avsluttet dato::</td>
                            <td valign="top" class="value">${arkivdel.avsluttetdato}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Avsluttet av:</td>
                            <td valign="top" class="value">${arkivdel.avsluttetav}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Start arkivperiode:</td>
                            <td valign="top" class="value">${arkivdel.arkivperiodestartdato}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Slutt arkivperiode:</td>
                            <td valign="top" class="value">${arkivdel.arkivperiodesluttdato}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Forelder arkiv:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.referanseforelder}"><g:link action="show" controller="arkiv" id="${arkivdel.referanseforelder.id}">${arkivdel.referanseforelder}</g:link></g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Forløper:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.referanseforløper}"><g:link action="show" id="${arkivdel.referanseforløper.id}">${arkivdel.referanseforløper}</g:link></g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Arvtaker:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.referansearvtaker}"><g:link action="show" id="${arkivdel.referansearvtaker.id}">${arkivdel.referansearvtaker}</g:link></g:if></td>
                        </tr>

		
												<tr class="prop">
                            <td valign="top" class="name">Klassifikasjonssystem:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.referanseklassifikasjonsSystem}"><g:link action="show" controller="klassifikasjonsSystem" id="${arkivdel.referanseklassifikasjonsSystem.id}">${arkivdel.referanseklassifikasjonsSystem}</g:link></g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Bevaring og kassasjon:</td>
                            <td valign="top" class="value"><g:if test="${arkivdel.bevaringOgKassasjon}"><g:link action="show" controller="bevaringOgKassasjon" id="${arkivdel.bevaringOgKassasjon.id}">${arkivdel.bevaringOgKassasjon}</g:link></g:if></td>
                        </tr>


												

												<tr class="prop">
                            <td valign="top" class="name">Oppbevaringssted:</td>
                            <td valign="top" class="value"><ul>
															<g:each in="${arkivdel.oppbevaringssted}" var="sted">
																<li>${sted}</li>
															</g:each></ul>
														</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Mapper:</td>
                            <td valign="top" class="value"><ul>
                              <g:each in="${arkivdel.referansemappe}" var="mappe">
                                <li><g:link controller="basismappe" action="show" id="${mappe.id}">${mappe}</g:link></li>
                              </g:each></ul>
                            </td>
                        </tr>

											<tr class="prop">
                            <td valign="top" class="name">Registreringer:</td>
                            <td valign="top" class="value"><ul>
                              <g:each in="${arkivdel.referanseregistrering}" var="reg">
                                <li><g:link action="show" controller="forenkletRegistrering" id="${reg.id}">${reg}</g:link></li>
                              </g:each></ul>
                            </td>
                        </tr>


                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${arkiv?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
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
