<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Arkiver</h1>

					<table>
						<th>Brukernavn</th>
						<g:each in="${users}" var="user">
							<tr>
								<td>${user.username}</td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
