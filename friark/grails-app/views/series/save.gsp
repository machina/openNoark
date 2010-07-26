<%! import org.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="series.new.part.created" default="New series created"/></h1>

    <table>
      <tr id="title_row">
        <td><label for="title"><g:message code="title" default="Title"/></label></td>
        <td>${arkivdel.title}</td>
      </tr>
      <tr>
        <td><label for="description"><g:message code="description" default="Description"/></label></td>
        <td>${arkivdel.description}</td>
      </tr>
      <tr>
        <td><label for="documentMedium"><g:message code="document.medium" default="Document medium"/></label></td>
        <td>${arkivdel.documentMedium}</td>
      </tr>
      <tr>
        <td><label for="createdDate"><g:message code="created.date" default="Created date"/></label></td>
        <td>${arkivdel.createdDate}</td>
      </tr>
      <tr>
        <td><label for="createdBy"><g:message code="created.by" default="Created by"/></label></td>
        <td>${arkivdel.createdBy}</td>
      </tr>
      <tr>
        <%-- TODO label for="createdBy" is wrong, what is the correct parameter here? 'Status' something? --%>
        <td><label for="createdBy"><g:message code="status" default="Status"/></label></td>
        <td>${arkivdel.arkivdelstatus}</td>
      </tr>

    </table>
  </body>
</html>
