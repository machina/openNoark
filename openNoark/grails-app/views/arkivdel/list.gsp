<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Arkiver</h1>
					<div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Hjem</a></span>
            <span class="menuButton"><g:link class="create" action="create">Ny Arkivdel</g:link></span>
        </div>

					<table>
						<g:sortableColumn property="systemID" title="SystemId" />
						<g:sortableColumn property="tittel" title="Arkivdel tittel" />
						<g:sortableColumn property="arkivdelstatus" title="Arkivdel status" />
						<g:sortableColumn property="forelder" title="Arkivdel forelder" />
						<g:each in="${arkivdeler}" var="arkivdel">
							<tr>
								<td>${arkivdel.systemID}</td>
								<td><g:link action="show" id="${arkivdel.id}">${arkivdel.tittel}</g:link></td>
      	        <td>${arkivdel.arkivdelstatus}</td>
								<td>${arkivdel.referanseforelder.tittel}</td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
