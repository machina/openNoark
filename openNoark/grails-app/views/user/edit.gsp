<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Lag et ny bruker</h1>
					<g:if test="${flash.message}">
	          <div class="message">${flash.message}</div>
          </g:if>


				<g:if test="${user.hasErrors()}">
					<ul id="error_list">
						<g:each in="${user.errors}">
							<li>${it}</li>
						</g:each>
					</ul>
				</g:if>
				<g:form id='${user.id}' action="edit">
					<table>
						<tr>
							<td><label for="tittel">Brukernavn</label></td>
							<td>${user?.username}</td>
						</tr>
						<tr>
              <td><label for="tittel">Passord</label></td>
              <td><g:textField id="passwd" name="passwd" value=""/></td>
            </tr>
						<tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="lagre endringer"/></td>
            </tr>
					</table>
				</g:form>

				<h2>Roller</h2>
				<table>
					<g:each in="${user.roles}" var="role">
						<tr>
							<td>${role.name}</td>
							<g:form id='${user.id}' action="edit">
								<g:hiddenField value="${role.id}" name="roleId"/>
								<td><g:submitButton name="del_role" value="Fjern" /></td>
							</g:form>
						</tr>
					</g:each>
				</table>
				<g:form id='${user.id}' action="edit">
					<g:select name="roleId" noSelection="${['null':'Select One...']}" from="${ShiroRole.findAll()}" optionKey="id" optionValue="name"/>
					<g:submitButton name="add_role" value="Legg til" />
				</g:form>
    </body>
</html>