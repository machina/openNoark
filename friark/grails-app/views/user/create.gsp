<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="user.create"/></h1>
  <g:if test="${user.hasErrors()}">
    <ul id="error_list">
      <g:each in="${user.errors}">
        <li>${it}</li>
      </g:each>
    </ul>
  </g:if>
  <g:form name='archive' id='archive' action="save">
    <table>
      <tr>
        <td><label for="title"><g:message code="user.username"/></label></td>

        <td><g:textField id="username" name="username" value="${user?.username}"/></td>
      </tr>
      <tr>
        <td><label for="title"><g:message code="user.password"/></label></td>
        <td><g:textField id="passwd" name="passwd" value=""/></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code: 'user.register')}"/></td>
      </tr>

    </table>
  </g:form>
</body>
</html>
