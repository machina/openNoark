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
							<tr>
								<td>${role.name}</td>
        	    </tr>
					</table>
					<h2>Tilganger</h2>
						<table>
							<g:each in="${role.permissions}" var="perm">
								<tr>
									<td>${perm}</td>
									<td>
										<g:form action="edit_role" id="${role.id}">
											<g:hiddenField name="perm" value="${perm}"/>
											<g:submitButton name="del_perm" value="Fjern" />
										</g:form>
									</td>
								</tr>
							</g:each>
						<table>
						<h3>Ny tilgang</h3>
						<g:form action="edit_role" id="${role.id}">
							<g:textField name="perm" />
							<g:submitButton name="add_perm" value="Legg til tilgang" />
						</g:form>
    </body>
</html>
