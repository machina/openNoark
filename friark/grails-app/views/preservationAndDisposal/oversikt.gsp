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
									<span><g:select name="disposalDecision" from="${['Bevares', 'Kasseres', 'Vurderes senere']}" value="${vedtak}"/></span><br/>
									<g:submitButton name="søk" value="Søk" />
								</g:form>	
							</div>
            </div>
						<g:if test="${liste}">
							<div class="drilldowns">
								<div class=="drilldownCat">
									<h2>Klassr</h2>
										<ul>
											<g:each in="${klassr}" var="klass">
												<g:form action="oversikt">
													<friark:hiddenDateField name="fra" date="${fra}"/>
                          <friark:hiddenDateField name="til" date="${til}"/>
                          <g:hiddenField name="disposalDecision" value="${vedtak}" />
                          <g:hiddenField name="filter" value="klass(id: ${klass.id})" />
													<li><g:submitButton name="${klass}" value="{klass}"/></li>
												</g:form>
											</g:each>
										</ul>
								</div>
								<div class=="drilldownCat">
	                <h2>Arkivdeler</h2>
									<ul>
										<g:each in="${serieser}" var="series">
											<g:form action="oversikt">
                          <friark:hiddenDateField name="fra" date="${fra}"/>
                          <friark:hiddenDateField name="til" date="${til}"/>
                          <g:hiddenField name="disposalDecision" value="${vedtak}" />
                          <g:hiddenField name="filter" value="series(id: ${series.id})" />
                          <li><g:submitButton name="${series}" value="${series}"/></li>
                      </g:form>
										</g:each>
									</ul>
                </div>

								<div class=="drilldownCat">
                  <h2>Mapper</h2>
										<ul>
                      <g:each in="${filer}" var="file">
												<g:form action="oversikt">
													<friark:hiddenDateField name="fra" date="${fra}"/>
													<friark:hiddenDateField name="til" date="${til}"/>
													<g:hiddenField name="disposalDecision" value="${vedtak}" />
													<g:hiddenField name="filter" value="file(id: ${file.id})" />
	                        <li><g:submitButton name="${file}" value="${file}"/></li>
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

                            <g:sortableColumn property="documentType" title="Dokumenttype" />

                            <g:sortableColumn property="documentStatus" title="Dokumentstatus" />

                            <g:sortableColumn property="title" title="Tittel" />

                            <g:sortableColumn property="description" title="Beskrivelse" />

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${liste}" var="dokumentdescriptionInstance" status="i">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                            <td><g:link action="show" controller="documentDescription" id="${dokumentdescriptionInstance.id}">${fieldValue(bean:dokumentdescriptionInstance, field:'id')}</g:link></td>

                            <td>${fieldValue(bean:dokumentdescriptionInstance, field:'systemID')}</td>

                            <td>${fieldValue(bean:dokumentdescriptionInstance, field:'documentType')}</td>

                            <td>${fieldValue(bean:dokumentdescriptionInstance, field:'documentStatus')}</td>

                            <td>${fieldValue(bean:dokumentdescriptionInstance, field:'title')}</td>

                            <td>${fieldValue(bean:dokumentdescriptionInstance, field:'description')}</td>

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
