<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="user.update"/></h1>
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
        <td><label for="title"><g:message code="user.username"/></label></td>
        <td>${user?.username}</td>
      </tr>
      <tr>
        <td><label for="title"><g:message code="user.password"/></label></td>
        <td><g:textField id="passwd" name="passwd" value=""/></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code: 'user.update')}"/></td>
      </tr>
    </table>
  </g:form>

  <h2><g:message code="roles"/></h2>
  <table>
    <g:each in="${user.roles}" var="role">
      <tr>
        <td>${role.name}</td>
      <g:form id='${user.id}' action="edit">
        <g:hiddenField value="${role.id}" name="roleId"/>        
        <td><g:submitButton name="del_role" value="${message(code: 'action.delete')}" default="Delete"/></td>
      </g:form>
      </tr>
    </g:each>
  </table>
  <g:form id='${user.id}' action="edit">
    <g:select name="roleId" noSelection="${['null':message(code: 'select')]}" from="${ShiroRole.findAll()}" optionKey="id" optionValue="name"/>
    <g:submitButton name="add_role" value="${message(code: 'action.add')}" default="Add role" />
  </g:form>
</body>
</html>
