<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="series.new.part.created" default="New series created"/></h1>

    <table>
      <tr id="title_row">
        <td><label for="tittel"><g:message code="title" default="Title"/></label></td>
        <td>${arkivdel.tittel}</td>
      </tr>
      <tr>
        <td><label for="beskrivelse"><g:message code="description" default="Description"/></label></td>
        <td>${arkivdel.beskrivelse}</td>
      </tr>
      <tr>
        <td><label for="dokumentmedium"><g:message code="document.medium" default="Document medium"/></label></td>
        <td>${arkivdel.dokumentmedium}</td>
      </tr>
      <tr>
        <td><label for="opprettetdato"><g:message code="created.date" default="Created date"/></label></td>
        <td>${arkivdel.opprettetdato}</td>
      </tr>
      <tr>
        <td><label for="opprettetav"><g:message code="created.by" default="Created by"/></label></td>
        <td>${arkivdel.opprettetav}</td>
      </tr>
      <tr>
        <td><label for="opprettetav"><g:message code="status" default="Status"/></label></td>
        <td>${arkivdel.arkivdelstatus}</td>
      </tr>

    </table>
  </body>
</html>
