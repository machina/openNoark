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
        <td><g:textField id="title" name="title" value="${tittel}"/></td>
      </tr>
      <tr>
        <td><label for="description"><g:message code="fonds.description" default="Description"/></label></td>
        <td><g:textField id="description"  name="description" value="${beskrivelse}"/></td>
      </tr>
      <tr>
        <td><label for="documentmedium"><g:message code="fonds.document.medium" default="Document medium"/></label></td>
        <td><g:textField id="documentmedium" name="documentmedium" value="${dokumentmedium}"/></td>
      </tr>
<%-- 
<tr>
<td><label for="opprettetdato"><g:message code="fonds.created.date" default="Created date"/></label></td>
<td><g:datePicker precision="day" name="opprettetdato" value="${new Date()}" noSelection="['':'-Velg-']"/></td>
</tr>
<tr>
<td><label for="opprettetav"><g:message code="fonds.created.by" default="Created by"/></label></td>
<td><g:textField id="opprettetav" name="opprettetav" value="${opprettetav}"/></td>
</tr> 
--%>
      <tr>
        <td><label for="arkivskaper"><g:message code="fonds.creator" default="Fonds creator"/></label></td>
        <td><g:select name="arkivskaper" noSelection="${['':'Velg arkivskaper']}" from='${Arkivskaper.list()}' optionKey="id" optionValue="arkivskapernavn"></g:select>
      </tr>
      <tr>
        <td><label for="forelder"><g:message code="parent" default="Parent"/></label></td>
        <td><g:select name="forelder" noSelection="${[null:'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="title"></g:select>
      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code:'fonds.create')}"/></td>
      </tr>

    </table>
  </g:form>
</body>
</html>
