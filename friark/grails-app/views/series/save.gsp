<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Ny arkivdel er opprettet</h1>

					<table>
						<tr id="title_row">
							<td><label for="title">Tittel</label></td>
							<td>${arkivdel.title}</td>
						</tr>
						<tr>
							<td><label for="description">Beskrivelse</label></td>
							<td>${arkivdel.description}</td>
						</tr>
						<tr>
              <td><label for="documentMedium">Dokument Medium</label></td>
              <td>${arkivdel.documentMedium}</td>
            </tr>
            <tr>
              <td><label for="createdDate">Opprettet</label></td>
              <td>${arkivdel.createdDate}</td>
            </tr>
						<tr>
              <td><label for="createdBy">Opprettet av</label></td>
              <td>${arkivdel.createdBy}</td>
            </tr>
						<tr>
              <td><label for="createdBy">Arkivdel Status</label></td>
              <td>${arkivdel.arkivdelstatus}</td>
            </tr>

					</table>
    </body>
</html>
