<html>
    <head>
    <meta name="layout" content="main" />
    </head>
    <body>
        <h1>Lag ny arkivdel</h1>
        <g:if test="${errors}">
          <ul id="error_list">
            <g:each in="${errors}">
              <li>${it}</li>
            </g:each>
          </ul>
        </g:if>
        <g:form name='archive_part' id='archive_part' action="save">
          <table>
            <tr>
              <td><label for="tittel">Tittel</label></td>
              <td><g:textField id="tittel" name="tittel" value="${tittel}"/></td>
            </tr>
            <tr>
              <td><label for="beskrivelse">Beskrivelse</label></td>
              <td><g:textField id="beskrivelse"  name="beskrivelse" value="${beskrivelse}"/></td>
            </tr>
            <tr>
              <td><label for="dokumentmedium">Dokument Medium</label></td>
              <td><g:textField id="dokumentmedium" name="dokumentmedium" value="${dokumentmedium}"/></td>
            </tr>
            <tr>
              <td><label for="opprettetdato">Opprettet</label></td>
              <td><g:datePicker name="opprettetdato" value="${new Date()}" noSelection="['':'-Velg-']"/></td>
            </tr>
						<tr>
              <td><label for="arkivperiodestartdato">Periode start</label></td>
              <td><g:datePicker name="arkivperiodestartdato" value="${new Date()}" noSelection="['':'-Velg-']"/></td>
            </tr>

            <tr>
              <td><label for="opprettetav">Opprettet av</label></td>
              <td><g:textField id="opprettetav" name="opprettetav" value="${opprettetav}"/></td>
            </tr>
						<tr>
							<td><label for="referanseforelder">Arkiv</label></td>
							<td><g:select name="referanseforelder" noSelection="${[null:'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
						<tr>

            <tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="Opprett arkivdel"/></td>
            </tr>

          </table>
        </g:form>
    </body>
</html>

