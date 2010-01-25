<%! import no.friark.ds.* %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Arkiv</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Basismappe List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Basismappe</g:link></span>
        </div>
        <div class="body">
            <h1>Arkiv</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
														<td valign="top" class="value">${arkiv.systemID}</td>
                        </tr>
											
												<tr class="prop">
                            <td valign="top" class="name">Tittle:</td>
                            <td valign="top" class="value">${arkiv.tittel}</td>
                        </tr>
 
												<tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            <td valign="top" class="value">${arkiv.beskrivelse}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Arkivstatus:</td>
                            <td valign="top" class="value">${arkiv.arkivstatus}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Dokument medium:</td>
                            <td valign="top" class="value">${arkiv.dokumentmedium}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Opprettet dato:</td>
                            <td valign="top" class="value">${arkiv.opprettetdato}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Opprettet av:</td>
                            <td valign="top" class="value">${arkiv.opprettetav}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Avsluttet dato::</td>
                            <td valign="top" class="value">${arkiv.avsluttetdato}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Avsluttet av:</td>
                            <td valign="top" class="value">${arkiv.avsluttetav}</td>
                        </tr>
												<tr class="prop">
                            <td valign="top" class="name">Forelder arkiv:</td>
                            <td valign="top" class="value"><g:if test="${arkiv.forelder}"><g:link action="show" id="${arkiv.forelder.id}">${arkiv.forelder}</g:link></g:if></td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name">Arkivskaper:</td>
                            <td valign="top" class="value"><g:if test="${arkiv.arkivskaper}"><g:link action="show" controller="arkivskaper" id="${arkiv.arkivskaper.id}">${arkiv.arkivskaper}</g:link></g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Oppbevaringssted:</td>
                            <td valign="top" class="value"><ul>
															<g:each in="${arkiv.oppbevaringssted}" var="sted">
																<li>${sted}</li>
															</g:each></ul>
														</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name">Arkivdeler:</td>
                            <td valign="top" class="value"><ul>
                              <g:each in="${arkiv.referansebarnArkivdel}" var="arkivdel">
                                <li><g:link controller="arkivdel" action="show" id="${arkivdel.id}">${arkivdel}</g:link></li>
                              </g:each></ul>
                            </td>
                        </tr>

											<tr class="prop">
                            <td valign="top" class="name">Underarkiv:</td>
                            <td valign="top" class="value"><ul>
                              <g:each in="${arkiv.subArkiv}" var="sub">
                                <li><g:link action="show" id="${arkiv.sub.id}">${sub}</g:link></li>
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
