<%! import no.friark.ds.* %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title><g:message code="fonds" default="Fonds"/></title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
      <span class="menuButton"><g:link class="list" action="list"><g:message code="list" default="List"/></g:link></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="new" default="New"/></g:link></span>
    </div>
    <div class="body">
      <h1><g:message code="fonds" default="Fonds"/></h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

            <tr class="prop">
              <td valign="top" class="name"><g:message code="system.id" default="System ID"/>:</td>
          <td valign="top" class="value">${arkiv.systemID}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="title" default="Title"/>:</td>
          <td valign="top" class="value">${arkiv.title}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="description" default="Description"/>:</td>
          <td valign="top" class="value">${arkiv.description}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="status" default="Status"/>:</td>
          <td valign="top" class="value">${arkiv.fondsStatus}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="document.medium" default="Document medium"/>:</td>
          <td valign="top" class="value">${arkiv.documentMedium}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="created.date" default="Created date"/>:</td>
          <td valign="top" class="value">${arkiv.createdDate}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="created.by" default="Created by"/>:</td>
          <td valign="top" class="value">${arkiv.createdBy}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="finalised.date" default="Finalised date"/>:</td>
          <td valign="top" class="value">${arkiv.finalisedDate}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="finalised.by" default="Finalised by"/>:</td>
          <td valign="top" class="value">${arkiv.finalisedBy}</td>
          </tr>
          <tr class="prop">
            <td valign="top" class="name"><g:message code="parent" default="Parent"/>:</td>
          <td valign="top" class="value"><g:if test="${arkiv.parent}"><g:link action="show" id="${arkiv.parent.id}">${arkiv.parent.title}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="fonds.creator" default="Fonds creator"/>:</td>
          <td valign="top" class="value"><g:if test="${arkiv.fondsCreator}">
            <ul>
              <g:each in="${arkiv.fondsCreator}" var="fondsCreator">
                <li><g:link action="show" controller="fondsCreator" id="${fondsCreator.id}">${fondsCreator.fondsCreatorName}</g:link></li>
              </g:each>
            </ul>
          </g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storage.location" default="Stroage location"/>:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkiv.storageLocation}" var="sted">
                <li>${sted}</li>
              </g:each></ul>
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="fonds.parts" default="Fonds parts"/>:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkiv.referenceChildSeries}" var="arkivdel">
                <li><g:link controller="arkivdel" action="show" id="${arkivdel.id}">${arkivdel.title}</g:link></li>
              </g:each></ul>
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="fonds.subfonds" default="Subfonds"/>:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkiv.subFonds}" var="sub">
                <li><g:link action="show" id="${arkiv.sub.id}">${sub}</g:link></li>
              </g:each></ul>
          </td>
          </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <g:form controller="arkiv">
          <input type="hidden" name="id" value="${arkiv?.id}" />
          <span class="button"><g:actionSubmit action="Edit" class="edit" value="${message(code:'action.edit',default:'Edit')}" /></span>
          <span class="button"><g:actionSubmit class="delete" onclick="return confirm(message(code:'confirm.action',default:'Are you sure?'));" value="Delete" /></span>
        </g:form>

      </div>
    </div>
  </body>
</html>