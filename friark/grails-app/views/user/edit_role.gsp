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
  <div class="nav">
    <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
    <span class="menuButton"><g:link class="create" action="create_role"><g:message code="roles.new" default="New Role"/></g:link></span>
  </div>
  <table>
    <th>><g:message code="roles"/></th>
  <tr>
    <td>${role.name}</td>
  </tr>
</table>
<h2><g:message code="permissions" default="Permissions"/></h2>
<table>
  <g:each in="${role.permissions}" var="perm">
    <tr>
      <td>${perm}</td>
      <td>
    <g:form action="edit_role" id="${role.id}">
      <g:hiddenField name="perm" value="${perm}"/>
      <g:submitButton name="del_perm" value="${message(code:'action.delete')}" />
    </g:form>
    </td>
    </tr>
  </g:each>
</table>
<h3>><g:message code="permissions" default="New permission"/></h3>
<g:form action="edit_role" id="${role.id}">
  <g:textField name="perm" />
  <g:submitButton name="add_perm" value="${message(code:'permissions.add')}" default="Add permission" />
</g:form>
</body>
</html>
