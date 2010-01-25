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
            <h1>Oversikt over bevaringer og kassasjnet i et tidsintervall</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
							<div class="oversikt_form">
								<g:form action="oversikt" method="GET">
									<span>Fra: <g:datePicker name="fra" value="${fra == null ? new Date() : fra}" precision="day"/> Til: <g:datePicker name="til" value="${til == null ? new Date() : til}" precision="day"/></span><br/>
									<span><g:select name="kassasjonsvedtak" from="${['Bevares', 'Kasseres', 'Vurderes senere']}" value="${vedtak}"/></span><br/>
									<g:submitButton name="søk" value="Søk" />
								</g:form>	
							</div>
            </div>
						<g:if test="${liste}">
							<div class="drilldowns">
								<div class=="drilldownCat">
									<h2>Klasser</h2>
										<ul>
											<g:each in="${klasser}" var="klasse">
												<g:form action="oversikt">
													<friark:hiddenDateField name="fra" date="${fra}"/>
                          <friark:hiddenDateField name="til" date="${til}"/>
                          <g:hiddenField name="kassasjonsvedtak" value="${vedtak}" />
                          <g:hiddenField name="filter" value="klasse(id: ${klasse.id})" />
													<li><g:submitButton name="${klasse}" value="{klasse}"/></li>
												</g:form>
											</g:each>
										</ul>
								</div>
								<div class=="drilldownCat">
	                <h2>Arkivdeler</h2>
									<ul>
										<g:each in="${arkivdeler}" var="arkivdel">
											<g:form action="oversikt">
                          <friark:hiddenDateField name="fra" date="${fra}"/>
                          <friark:hiddenDateField name="til" date="${til}"/>
                          <g:hiddenField name="kassasjonsvedtak" value="${vedtak}" />
                          <g:hiddenField name="filter" value="arkivdel(id: ${arkivdel.id})" />
                          <li><g:submitButton name="${arkivdel}" value="${arkivdel}"/></li>
                      </g:form>
										</g:each>
									</ul>
                </div>

								<div class=="drilldownCat">
                  <h2>Mapper</h2>
										<ul>
                      <g:each in="${mapper}" var="mappe">
												<g:form action="oversikt">
													<friark:hiddenDateField name="fra" date="${fra}"/>
													<friark:hiddenDateField name="til" date="${til}"/>
													<g:hiddenField name="kassasjonsvedtak" value="${vedtak}" />
													<g:hiddenField name="filter" value="mappe(id: ${mappe.id})" />
	                        <li><g:submitButton name="${mappe}" value="${mappe}"/></li>
												</g:form>
                      </g:each>
                    </ul>
                </div>
							</div>
							<div class="oversikt_liste">
								<h2>Treff</h2>
								<table>
                    <thead>
                        <tr>

                            <g:sortableColumn property="id" title="Id" />

                            <g:sortableColumn property="systemID" title="SystemID" />

                            <g:sortableColumn property="dokumenttype" title="Dokumenttype" />

                            <g:sortableColumn property="dokumentstatus" title="Dokumentstatus" />

                            <g:sortableColumn property="tittel" title="Tittel" />

                            <g:sortableColumn property="beskrivelse" title="Beskrivelse" />

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${liste}" var="dokumentbeskrivelseInstance" status="i">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                            <td><g:link action="show" controller="dokumentbeskrivelse" id="${dokumentbeskrivelseInstance.id}">${fieldValue(bean:dokumentbeskrivelseInstance, field:'id')}</g:link></td>

                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'systemID')}</td>

                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'dokumenttype')}</td>

                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'dokumentstatus')}</td>

                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'tittel')}</td>

                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'beskrivelse')}</td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>

							</div>
						</g:if>
        </div>
    </body>
</html>
