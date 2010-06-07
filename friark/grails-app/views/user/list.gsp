<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="users" default="Users"/></h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
    <span class="menuButton"><g:link class="create" action="create"><g:message code="user.new" default="New User"/></g:link></span>
    <span class="menuButton"><g:link class="roles" action="roles"><g:message code="roles" default="Roles"/></g:link></span>
  </div>
  <table>
    <th><g:message code="username" default="Username"/></th>
    <g:each in="${users}" var="user">
      <tr>
        <td><g:link action="edit" id="${user.id}">${username}</g:link></td>
      </tr>
    </g:each>
  </table>
</body>
</html>
