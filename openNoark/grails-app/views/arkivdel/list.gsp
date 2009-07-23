<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Arkiver</h1>

					<table>
						<th>SystemId</th>
						<th>Arkivdel tittel</th>
						<th>Arkivdel status</th>
						<g:each in="${arkivdeler}" var="arkivdel">
							<tr>
								<td>${arkivdel.systemid}</td>
								<td>${arkivdel.tittel}</td>
      	        <td>${arkivdel.arkivdelstatus}</td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
