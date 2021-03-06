<%! import org.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="series" default="Series"/></h1>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="series.new" default="New series"/></g:link></span>
    </div>
    <table>
      <g:sortableColumn property="systemID" title="${message(code:'system.id',default:'System ID')}" />
      <g:sortableColumn property="title" title="${message(code:'title', default:'Title')}" />
      <g:sortableColumn property="arkivdelstatus" title="${message(code:'status', default:'Status')}" />
      <g:sortableColumn property="parent" title="${message(code:'parent',default:'Parent')}" />
      <g:each in="${arkivdeler}" var="arkivdel">
        <tr>
          <td>${arkivdel.systemID}</td>
          <td><g:link action="show" id="${arkivdel.id}">${arkivdel.title}</g:link></td>
        <td>${arkivdel.recordSectionStatus}</td>
        <td>${arkivdel.parent.title}</td>
        </tr>
      </g:each>
    </table>
  </body>
</html>
