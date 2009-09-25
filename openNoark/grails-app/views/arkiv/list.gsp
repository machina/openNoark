<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Arkiver</h1>
					<div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Hjem</a></span>
            <span class="menuButton"><g:link class="create" action="create">Nytt Arkiv</g:link></span>
        </div>

					<table>
						<th>SystemId</th>
						<th>Arkiv tittel</th>
						<th>Arkiv status</th>
						<g:each in="${arkiver}" var="arkiv">
							<tr>
								<td>${arkiv.systemID}</td>
								<td><g:link action="update" id="${arkiv.id}">${arkiv.tittel}</g:link></td>
      	        <td>${arkiv.arkivstatus}</td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
