<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="fonds.edit" default="Edit fonds"/></h1>
  <g:if test="${errors}">
    <ul id="error_list">
      <g:each in="${errors}">
        <li>${it}</li>
      </g:each>
    </ul>
  </g:if>
  <g:form name='archive' id='${arkiv.id}' action="update">
    <table>
      <tr>
        <td><label for="title"><g:messageTittel code="title" default="Title"/></label></td>
        <td><g:textField id="title" name="title" value="${arkiv.title}"/></td>
      </tr>
      <tr>
        <td><label for="description"><g:message code="description" default="Description"/></label></td>
        <td><g:textField id="description"  name="description" value="${arkiv.description}"/></td>
      </tr>
      <tr>
        <td><label for="documentMedium"><g:message code="fonds.document.medium" default="Document Medium"/></label></td>
        <td><g:textField id="documentMedium" name="documentMedium" value="${arkiv.documentMedium}"/></td>
      </tr>

      <tr>
        <td><label for="fondsCreator"><g:message code="fonds.creator" default="Fonds creator"/></label></td>
        <td><g:select name="fondsCreator" noSelection="${['':message(code:'select')]}" from='${FondsCreator.list()}' optionKey="id" optionValue="fondsCreatornavn"></g:select>
      </tr>

      <tr>
        <td><label for="parent"><g:message code="parent" default="Parent"/></label></td>
        <td><g:select name="parent" value="${arkiv.parent}" noSelection="${['null':message(code('select.parent'))]}" from='${Fonds.list()}' optionKey="id" optionValue="title"></g:select>
      </tr>
      <tr>
        <td><label for="fondsStatus"><g:message code="status" default="Status"/></label></td>
        <td><g:select name="fondsStatus" value="${arkiv.fondsStatus}" from='${[message(code:'fonds.status.created'), message(code:'fonds.status.closed')]}'></g:select></td>
      </tr>

      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code:'fonds.save')}"/></td>
      </tr>

    </table>
  </g:form>
</body>
</html>
