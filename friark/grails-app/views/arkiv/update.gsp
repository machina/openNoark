<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Rediger arkiv</h1>
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
							<td><label for="title">Tittel</label></td>
							<td><g:textField id="title" name="title" value="${arkiv.title}"/></td>
						</tr>
						<tr>
							<td><label for="description">Beskrivelse</label></td>
							<td><g:textField id="description"  name="description" value="${arkiv.description}"/></td>
						</tr>
						<tr>
              <td><label for="documentMedium">Dokument Medium</label></td>
              <td><g:textField id="documentMedium" name="documentMedium" value="${arkiv.documentMedium}"/></td>
            </tr>
            <%-- <tr>
              <td><label for="createdDate">Opprettet</label></td>
              <td><g:datePicker precision="day" name="createdDate" value="${arkiv.createdDate}"/></td>
            </tr> --%>
						<tr>
              <td><label for="fondsCreator">FondsCreator</label></td>
              <td><g:select name="fondsCreator" noSelection="${['':'Velg fondsCreator']}" from='${FondsCreator.list()}' optionKey="id" optionValue="fondsCreatornavn"></g:select>
            </tr>

						<%-- <tr>
              <td><label for="createdBy">Opprettet av</label></td>
              <td><g:textField id="createdBy" name="createdBy" value="${arkiv.createdBy}"/></td>
            </tr> --%>
						<tr>
							<td><label for="parent">Forelder</label></td>
							<td><g:select name="parent" value="${arkiv.parent}" noSelection="${['null':'Velg parent arkiv']}" from='${Fonds.list()}' optionKey="id" optionValue="title"></g:select>
						</tr>
						<tr>
							<td><label for="fondsStatus">Status</label></td>
              <td><g:select name="fondsStatus" value="${arkiv.fondsStatus}" from='${["Opprettet", "Avsluttet"]}'></g:select></td>
						</tr>
						<%-- <tr>
              <td><label for="finalisedBy">Avsluttet av</label></td>
              <td><g:textField id="finalisedBy" name="finalisedBy" value="${arkiv.finalisedBy}"/></td>
            </tr>
						<tr>
              <td><label for="finalisedDate">Avsluttet dato</label></td>
              <td><fa:datePicker precision="day" default="none" name="finalisedDate" noSelection="${['none':'Ikke valgt']}" value="${arkiv.finalisedDate}"/></td>
            </tr> --%>
						<tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="Lagre arkiv"/></td>
            </tr>

					</table>
				</g:form>
    </body>
</html>
