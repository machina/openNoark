<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="fonds" default="Fonds"/></h1>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="fonds.new" default="New fonds"</g:link></span>
    </div>

    <table>
      <g:sortableColumn property="systemID" title="${message(code:'fonds.system.id')}"/>
      <g:sortableColumn property="title" title="${message(code:'fonds.title')}"/>
      <g:sortableColumn property="fondsStatus" title="${message(code:'fonds.status')}"/>
      <g:sortableColumn property="parentTittel" title="${message(code:'fonds.parent')}"/>
      <g:each in="${arkiver}" var="arkiv">
        <tr>
          <td>${arkiv.systemID}</td>
          <td><g:link action="show" id="${arkiv.id}">${arkiv.title}</g:link></td>
        <td>${arkiv.fondsStatus}</td>
        <td>${arkiv.parent?.title}</td>
        </tr>
      </g:each>
    </table>
  </body>
</html>
