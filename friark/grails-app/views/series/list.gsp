<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Arkivdeler</h1>
					<div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Hjem</a></span>
            <span class="menuButton"><g:link class="create" action="create">Ny Arkivdel</g:link></span>
        </div>

					<table>
						<g:sortableColumn property="systemID" title="SystemId" />
						<g:sortableColumn property="title" title="Arkivdel title" />
						<g:sortableColumn property="arkivdelstatus" title="Arkivdel status" />
						<g:sortableColumn property="parent" title="Arkivdel parent" />
						<g:each in="${arkivdeler}" var="arkivdel">
							<tr>
								<td>${arkivdel.systemID}</td>
								<td><g:link action="show" id="${arkivdel.id}">${arkivdel.title}</g:link></td>
      	        <td>${arkivdel.recordSectionStatus}</td>
								<td>${arkivdel.parent.title}</td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
