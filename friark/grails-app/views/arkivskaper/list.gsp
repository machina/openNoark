
<%@ page import="no.friark.ds.FondsCreator" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>FondsCreator List</title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="action.new" default="New"/></g:link></span>
    </div>
    <div class="body">
      <h1><g:message code="fondscreator.list" default="Fonds creator list"/></h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
            <tr>
          <g:sortableColumn property="id" title="${message(code:'id')}" />
          <g:sortableColumn property="fondsCreatorID" title="${message(code:'id')}" />
          <g:sortableColumn property="fondsCreatorName" title="${message(code:'name')}" />
          <g:sortableColumn property="description" title="${message(code:'description')}" />

          </tr>
          </thead>
          <tbody>
          <g:each in="${fondsCreatorInstanceList}" status="i" var="fondsCreatorInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${fondsCreatorInstance.id}">${fieldValue(bean:fondsCreatorInstance, field:'id')}</g:link></td>
              <td>${fieldValue(bean:fondsCreatorInstance, field:'fondsCreatorID')}</td>
              <td>${fieldValue(bean:fondsCreatorInstance, field:'fondsCreatorName')}</td>
              <td>${fieldValue(bean:fondsCreatorInstance, field:'description')}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${fondsCreatorInstanceTotal}" />
      </div>
    </div>
  </body>
</html>
