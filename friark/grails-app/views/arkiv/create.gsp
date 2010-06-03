<%! import no.friark.ds.* %> 
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="fonds.new" default="New fonds"/></h1>
  <g:if test="${errors}">
    <ul id="error_list">
      <g:each in="${errors}">
        <li>${it}</li>
      </g:each>
    </ul>
  </g:if>
  <g:form name='archive' action="save">
    <table>
      <tr>
        <td><label for="title"><g:message code="fonds.title" default="Title"/></label></td>
        <td><g:textField id="title" name="title" value="${title}"/></td>
      </tr>
      <tr>
        <td><label for="description"><g:message code="fonds.description" default="Description"/></label></td>
        <td><g:textField id="description"  name="description" value="${description}"/></td>
      </tr>
      <tr>
        <td><label for="documentMedium"><g:message code="fonds.document.medium" default="Document medium"/></label></td>
        <td><g:textField id="documentMedium" name="documentMedium" value="${documentMedium}"/></td>
      </tr>
      <tr>
        <td><label for="fondsCreator"><g:message code="fonds.creator" default="Fonds creator"/></label></td>
        <td><g:select name="fondsCreator" noSelection="${['':message(code:'fonds.select.creator')]}" from='${FondsCreator.list()}' optionKey="id" optionValue="fondsCreatornavn"></g:select>
      </tr>
      <tr>
        <td><label for="parent"><g:message code="parent" default="Parent"/></label></td>
        <td><g:select name="parent" noSelection="${[null:message(code:'select.parent')]}" from='${Fonds.list()}' optionKey="id" optionValue="title"></g:select>
      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code:'fonds.create')}"/></td>
      </tr>
    </table>
  </g:form>
</body>
</html>
