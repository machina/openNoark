<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Roles</h1>
					<g:if test="${flash.message}">
	          <div class="message">${flash.message}</div>
          </g:if>
					<div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create_role">Ny rolle</g:link></span>
        	</div>
					<table>
						<th>Rolle</th>
						<g:each in="${roles}" var="role">
							<tr>
								<td><g:link action="edit_role" id="${role.id}">${role.name}</g:link></td>

        	    </tr>
						</g:each>
					</table>
    </body>
</html>
