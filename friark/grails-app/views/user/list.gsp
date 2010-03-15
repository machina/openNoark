<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Brukere</h1>
					<g:if test="${flash.message}">
	          <div class="message">${flash.message}</div>
          </g:if>
					<div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">Ny bruker</g:link></span>
						<span class="menuButton"><g:link class="roles" action="roles">Roller</g:link></span>
        	</div>
					<table>
						<th>Brukernavn</th>
						<g:each in="${users}" var="user">
							<tr>
								<td><g:link action="edit" id="${user.id}">${user.username}</g:link></td>
        	    </tr>
						</g:each>
					</table>
    </body>
</html>
