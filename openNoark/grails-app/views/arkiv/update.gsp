<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Lag et nytt arkiv</h1>
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
							<td><label for="tittel">Tittel</label></td>
							<td><g:textField id="tittel" name="tittel" value="${arkiv.tittel}"/></td>
						</tr>
						<tr>
							<td><label for="beskrivelse">Beskrivelse</label></td>
							<td><g:textField id="beskrivelse"  name="beskrivelse" value="${arkiv.beskrivelse}"/></td>
						</tr>
						<tr>
              <td><label for="dokumentmedium">Dokument Medium</label></td>
              <td><g:textField id="dokumentmedium" name="dokumentmedium" value="${arkiv.dokumentmedium}"/></td>
            </tr>
            <tr>
              <td><label for="opprettetdato">Opprettet</label></td>
              <td><g:datePicker precision="day" name="opprettetdato" value="${arkiv.opprettetdato}"/></td>
            </tr>
						<tr>
              <td><label for="opprettetav">Opprettet av</label></td>
              <td><g:textField id="opprettetav" name="opprettetav" value="${arkiv.opprettetav}"/></td>
            </tr>
						<tr>
							<td><label for="forelder">Forelder</label></td>
							<td><g:select name="forelder" value="${arkiv.forelder}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
						</tr>
						<tr>
							<td><label for="forelder">Status</label></td>
              <td><g:select name="arkivstatus" value="${arkiv.arkivstatus}" from='${["Opprettet", "Avsluttet"]}'></g:select></td>
						</tr>
						<tr>
              <td><label for="forelder">Avsluttet av</label></td>
              <td><g:textField id="avsluttetav" name="avsluttetav" value="${arkiv.avsluttetav}"/></td>
            </tr>
						<tr>
              <td><label for="forelder">Avsluttet dato</label></td>
              <td><fa:datePicker precision="day" default="none" name="avsluttetdato" noSelection="${['none':'Ikke valgt']}" value="${arkiv.avsluttetdato}"/></td>
            </tr>
						<tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="Lagre arkiv"/></td>
            </tr>

					</table>
				</g:form>
    </body>
</html>
