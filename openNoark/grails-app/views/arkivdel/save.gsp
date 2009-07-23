<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Ny arkivdel er opprettet</h1>

					<table>
						<tr id="title_row">
							<td><label for="tittel">Tittel</label></td>
							<td>${arkivdel.tittel}</td>
						</tr>
						<tr>
							<td><label for="beskrivelse">Beskrivelse</label></td>
							<td>${arkivdel.beskrivelse}</td>
						</tr>
						<tr>
              <td><label for="dokumentmedium">Dokument Medium</label></td>
              <td>${arkivdel.dokumentmedium}</td>
            </tr>
            <tr>
              <td><label for="opprettetdato">Opprettet</label></td>
              <td>${arkivdel.opprettetdato}</td>
            </tr>
						<tr>
              <td><label for="opprettetav">Opprettet av</label></td>
              <td>${arkivdel.opprettetav}</td>
            </tr>
						<tr>
              <td><label for="opprettetav">Arkivdel Status</label></td>
              <td>${arkivdel.arkivdelstatus}</td>
            </tr>

					</table>
    </body>
</html>
