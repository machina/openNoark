<%! import no.friark.ds.* %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title><g:message code="fonds" default="Fonds"/></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="fonds.list" default="Fonds list"</g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="fonds.new" default="New fonds"</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="fonds" default="Fonds"</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.system.id" default="SystemID"/>:</td>
														<td valign="top" class="value">${arkiv.systemID}</td>
                        </tr>
											
												<tr class="prop">
                            <td valign="top" class="name"><g:message code="title" default="Title"/>:</td>
                            <td valign="top" class="value">${arkiv.tittel}</td>
                        </tr>
 
												<tr class="prop">
                            <td valign="top" class="name"><g:message code="description" default="Description"/>:</td>
                            <td valign="top" class="value">${arkiv.beskrivelse}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.status" default="Fonds status"/>:</td>
                            <td valign="top" class="value">${arkiv.arkivstatus}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.document.medium" default="Document Medium"/>:</td>
                            <td valign="top" class="value">${arkiv.dokumentmedium}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.created.date" default="Created Date"/>:</td>
                            <td valign="top" class="value">${arkiv.opprettetdato}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.created.by" default="Created By"/>:</td>
                            <td valign="top" class="value">${arkiv.opprettetav}</td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name"><g:mesage code="fonds.finalised.date" default="Finalised Date"/>:</td>
                            <td valign="top" class="value">${arkiv.avsluttetdato}</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.finalised.by" default="Finalised By"/>:</td>
                            <td valign="top" class="value">${arkiv.avsluttetav}</td>
                        </tr>
												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.parent" default="Parent Fonds"/>:</td>
                            <td valign="top" class="value"><g:if test="${arkiv.forelder}"><g:link action="show" id="${arkiv.forelder.id}">${arkiv.forelder.tittel}</g:link></g:if></td>
                        </tr>


												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.creator" default="Fonds Creator"/>:</td>
                            <td valign="top" class="value"><g:if test="${arkiv.arkivskaper}">
															<ul>
																<g:each in="${arkiv.arkivskaper}" var="arkivskaper">
																	<li><g:link action="show" controller="arkivskaper" id="${arkivskaper.id}">${arkivskaper.arkivskapernavn}</g:link></li>
																</g:each>
															</ul>
														</g:if></td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.storage.location" default="Storage Location"/>:</td>
                            <td valign="top" class="value"><ul>
															<g:each in="${arkiv.oppbevaringssted}" var="sted">
																<li>${sted}</li>
															</g:each></ul>
														</td>
                        </tr>

												<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.parts" default="Fonds parts"/>:</td>
                            <td valign="top" class="value"><ul>
                              <g:each in="${arkiv.referansebarnArkivdel}" var="arkivdel">
                                <li><g:link controller="arkivdel" action="show" id="${arkivdel.id}">${arkivdel.tittel}</g:link></li>
                              </g:each></ul>
                            </td>
                        </tr>

											<tr class="prop">
                            <td valign="top" class="name"><g:message code="fonds.subfonds" default="Subfonds"/>:</td>
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
                <g:form controller="arkiv">
                    <input type="hidden" name="id" value="${arkiv?.id}" />
                    <span class="button"><g:actionSubmit action="Edit" class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
<%--								<g:form controller="merknad" action="create" method="get">
                    <input type="hidden" name="systemID" value="${arkiv?.systemID}" />
                    <span class="button"><g:submitButton class="create" name="create_merknad" value="${message(code:'fonds.add.note')}:" /></span>
                </g:form> 
--%>
            </div>
        </div>
    </body>
</html>
