<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="fondspart.handle.locations.for" default="Handle locations for"/> ${arkivdel.id}</h1>
  <g:if test="${errors}">
    <ul id="error_list">
      <g:each in="${errors}">
        <li>${it}</li>
      </g:each>
    </ul>
  </g:if>
  <table>
    <g:each in="${arkivdel.oppbevaringssted}" var="sted">
      <g:form action="fjernOppbevaringsted">
        <g:hiddenField name="arkivdelid" value="${arkivdel.id}" />
        <g:hiddenField name="sted" value="${sted}" />
        <tr>
          <td>${sted}</td>
          <td><g:submitButton name="del" value="fjern"/></td>
        </tr>
      </g:form>
    </g:each>
    <g:form name='add' id='add' action="leggTilOppbevaringsted">
      <g:hiddenField name="arkivdelid" value="${arkivdel.id}" />
      <tr class="prop">
        <td class="top"><g:textField name="sted" /></td>
      <td><span class="button"><g:submitButton name="save" value="${messages(code:'actions.save')}"/></span></td>
      </tr>

  </table>
</g:form>
</body>
</html>
