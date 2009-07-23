<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Arkiv ${arkiv.id}  er oppdatert</h1>

					<table>
						<tr id="title_row">
							<td><label for="tittel">Tittel</label></td>
							<td>${arkiv.tittel}</td>
						</tr>
						<tr>
							<td><label for="beskrivelse">Beskrivelse</label></td>
							<td>${arkiv.beskrivelse}</td>
						</tr>
						<tr>
              <td><label for="dokumentmedium">Dokument Medium</label></td>
              <td>${arkiv.dokumentmedium}</td>
            </tr>
            <tr>
              <td><label for="opprettetdato">Opprettet</label></td>
              <td>${arkiv.opprettetdato}</td>
            </tr>
						<tr>
              <td><label for="opprettetav">Opprettet av</label></td>
              <td>${arkiv.opprettetav}</td>
            </tr>
						<tr>
              <td><label for="opprettetav">Status</label></td>
              <td>${arkiv.arkivstatus}</td>
            </tr>
						<tr>
              <td>Forelder</td>
              <td>${arkiv.forelder?.tittel}</td>
            </tr>
					</table>
    </body>
</html>
