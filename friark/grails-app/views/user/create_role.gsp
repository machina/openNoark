<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="roles"/></h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:if test="${role.hasErrors()}">
    <ul id="error_list">
      <g:each in="${role.errors}">
        <li>${it}</li>
      </g:each>
    </ul>
  </g:if>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home"/></a></span>
    <span class="menuButton"><g:link class="create" action="create_role"><g:message code="roles.new"/></g:link></span>
  </div>
  <g:form action="create_role">
    <table>
      <th><g:message code="role"/></th>
      <tr>
        <td><g:textField id="name" name="name" value="${role?.name}"/></td>
      </tr>
    </table>
    <g:submitButton name="create" class="create" value="${message( code: 'action.save')}"/>
  </g:form>
</body>
</html>
