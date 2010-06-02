<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="roles" default="Roles"/></h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
    <span class="menuButton"><g:link class="create" action="create_role"><g:message code="role.new" default="New Role"/></g:link></span>
  </div>
  <table>
    <th><g:message code="role" default="Role"/></th>
    <g:each in="${roles}" var="role">
      <tr>
        <td><g:link action="edit_role" id="${role.id}">${role.name}</g:link></td>

      </tr>
    </g:each>
  </table>
</body>
</html>
