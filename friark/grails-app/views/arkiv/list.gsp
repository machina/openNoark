<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Arkiver</h1>
					<div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Hjem</a></span>
            <span class="menuButton"><g:link class="create" action="create">Nytt Fonds</g:link></span>
        </div>

					<table>
						<g:sortableColumn property="systemID" title="SystemId" />
						<g:sortableColumn property="title" title="Fonds title" />
						<g:sortableColumn property="fondsStatus" title="Fonds status" />
						<g:sortableColumn property="parentTittel" title="Forelder" />
						<g:each in="${arkiver}" var="arkiv">
							<tr>
								<td>${arkiv.systemID}</td>
								<td><g:link action="show" id="${arkiv.id}">${arkiv.title}</g:link></td>
      	        <td>${arkiv.fondsStatus}</td>
								<td>${arkiv.parent?.title}</td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
