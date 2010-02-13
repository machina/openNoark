<%! import no.friark.ds.* %>
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
						<g:sortableColumn property="systemID" title="SystemId" />
						<g:sortableColumn property="tittel" title="Arkiv tittel" />
						<g:sortableColumn property="arkivstatus" title="Arkiv status" />
						<g:sortableColumn property="forelderTittel" title="Forelder" />
						<g:each in="${arkiver}" var="arkiv">
							<tr>
								<td>${arkiv.systemID}</td>
								<td><g:link action="update" id="${arkiv.id}">${arkiv.tittel}</g:link></td>
      	        <td>${arkiv.arkivstatus}</td>
								<td>${arkiv.forelder?.tittel}</td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
