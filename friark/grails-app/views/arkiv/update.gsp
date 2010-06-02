<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1><g:message code="fonds.edit" default="Edit fonds"/></h1>
				<g:if test="${errors}">
					<ul id="error_list">
						<g:each in="${errors}">
							<li>${it}</li>
						</g:each>
					</ul>
				</g:if>
				<g:form name='archive' id='${arkiv.id}' action="update">
					<table>
						<tr>
							<td><label for="tittel"><g:messageTittel code="title" default="Title"/></label></td>
							<td><g:textField id="tittel" name="tittel" value="${arkiv.tittel}"/></td>
						</tr>
						<tr>
							<td><label for="beskrivelse"><g:message code="description" default="Description"/></label></td>
							<td><g:textField id="beskrivelse"  name="beskrivelse" value="${arkiv.beskrivelse}"/></td>
						</tr>
						<tr>
              <td><label for="dokumentmedium"><g:message code="fonds.document.medium" default="Document Medium"</label></td>
              <td><g:textField id="dokumentmedium" name="dokumentmedium" value="${arkiv.dokumentmedium}"/></td>
            </tr>
            <%-- <tr>
              <td><label for="opprettetdato"><g:message code="created" default="Created"/></label></td>
              <td><g:datePicker precision="day" name="opprettetdato" value="${arkiv.opprettetdato}"/></td>
            </tr> --%>
						<tr>
              <td><label for="arkivskaper"><g:message code="fonds.creator" default="Fonds creator"</label></td>
              <td><g:select name="arkivskaper" noSelection="${['':'Velg arkivskaper']}" from='${Arkivskaper.list()}' optionKey="id" optionValue="arkivskapernavn"></g:select>
            </tr>

						<%-- <tr>
              <td><label for="opprettetav"><g:message code="fonds.created.by" default="Created by"/></label></td>
              <td><g:textField id="opprettetav" name="opprettetav" value="${arkiv.opprettetav}"/></td>
            </tr> --%>
						<tr>
							<td><label for="forelder"><g:message code="parent" default="Parent"/></label></td>
							<td><g:select name="forelder" value="${arkiv.forelder}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
						</tr>
						<tr>
							<td><label for="arkivstatus"><g:message code="status" default="Status"/></label></td>
              <td><g:select name="arkivstatus" value="${arkiv.arkivstatus}" from='${["Opprettet", "Avsluttet"]}'></g:select></td>
						</tr>
						<%-- <tr>
              <td><label for="avsluttetav"><g:message code="fonds.finalised.by" default="Finalised by"/></label></td>
              <td><g:textField id="avsluttetav" name="avsluttetav" value="${arkiv.avsluttetav}"/></td>
            </tr>
						<tr>
              <td><label for="avsluttetdato"><g:message code="fonds.finalised.date" default="Finalised date"/></label></td>
              <td><fa:datePicker precision="day" default="none" name="avsluttetdato" noSelection="${['none':'Ikke valgt']}" value="${arkiv.avsluttetdato}"/></td>
            </tr> --%>
						<tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="${message(code:'fonds.save')}"/></td>
            </tr>

					</table>
				</g:form>
    </body>
</html>
