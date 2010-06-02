<%! import no.friark.ds.* %> 
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
				<g:form name='archive' action="save">
					<table>
						<tr>
							<td><label for="title">Tittel</label></td>
							<td><g:textField id="title" name="title" value="${title}"/></td>
						</tr>
						<tr>
							<td><label for="description">Beskrivelse</label></td>
							<td><g:textField id="description"  name="description" value="${description}"/></td>
						</tr>
						<tr>
              <td><label for="documentMedium">Dokument Medium</label></td>
              <td><g:textField id="documentMedium" name="documentMedium" value="${documentMedium}"/></td>
            </tr>
           <%-- <tr>
              <td><label for="createdDate">Opprettet</label></td>
              <td><g:datePicker precision="day" name="createdDate" value="${new Date()}" noSelection="['':'-Velg-']"/></td>
            </tr>
						<tr>
              <td><label for="createdBy">Opprettet av</label></td>
              <td><g:textField id="createdBy" name="createdBy" value="${createdBy}"/></td>
            </tr> --%>
						<tr>
              <td><label for="fondsCreator">FondsCreator</label></td>
              <td><g:select name="fondsCreator" noSelection="${['':'Velg fondsCreator']}" from='${FondsCreator.list()}' optionKey="id" optionValue="fondsCreatornavn"></g:select>
            </tr>
						<tr>
							<td><label for="parent">Forelder</label></td>
							<td><g:select name="parent" noSelection="${[null:'Velg parent arkiv']}" from='${Fonds.list()}' optionKey="id" optionValue="title"></g:select>
						<tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="Opprett arkiv"/></td>
            </tr>

					</table>
				</g:form>
    </body>
</html>
