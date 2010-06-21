<%! import no.friark.ds.* %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title><g:message code="series" default="Series"/></title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
      <span class="menuButton"><g:link class="list" action="list"><g:message code="list" default="List"/></g:link></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="new" default="New"/></g:link></span>
    </div>
    <div class="body">
      <h1><g:message code="series" default="Series"/></h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

            <tr class="prop">
              <td valign="top" class="name"><g:message code="system.id" default="SystemID"/>:</td>
          <td valign="top" class="value">${arkivdel.systemID}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="title" default="Title"/>:</td>
          <td valign="top" class="value">${arkivdel.title}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="description" default="Description"/>:</td>
          <td valign="top" class="value">${arkivdel.description}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="status" default="Status"/>:</td>
          <td valign="top" class="value">${arkivdel.recordSectionStatus}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="document.medium" default="Document medium"/>:</td>
          <td valign="top" class="value">${arkivdel.documentMedium}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="created.date" default="Create date"/>:</td>
          <td valign="top" class="value">${arkivdel.createdDate}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="created.by" default="Created by"/>:</td>
          <td valign="top" class="value">${arkivdel.createdBy}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="finalised.date" default="Finalised date"/>::</td>
          <td valign="top" class="value">${arkivdel.finalisedDate}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="finalised.by" default="Finalised by"/>:</td>
          <td valign="top" class="value">${arkivdel.finalisedBy}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="series.period.start.date" default="Period start date"/>:</td>
          <td valign="top" class="value">${arkivdel.recordsPeriodStartDate}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="series.period.end.date" default="Period end date"/>:</td>
          <td valign="top" class="value">${arkivdel.recordsPeriodEndDate}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="parent" default="Parent"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.parent}"><g:link action="show" controller="arkiv" id="${arkivdel.parent.id}">${arkivdel.parent.title}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="precursor" default="Precursor"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.precursor}"><g:link action="show" id="${arkivdel.precursor.id}">${arkivdel.precursor}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="successor" default="Successor"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.successor}"><g:link action="show" id="${arkivdel.successor.id}">${arkivdel.successor}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="classification.system" default="Classification system"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.classificationSystem}"><g:link action="show" controller="klassifikasjonsSystem" id="${arkivdel.classificationSystem.id}">${arkivdel.classificationSystem}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="preservation.and.disposal" default="Preservation and disposal"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.preservationAndDisposal}"><g:link action="show" controller="bevaringOgKassasjon" id="${arkivdel.preservationAndDisposal.id}">${arkivdel.preservationAndDisposal}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storage.location" default="Storage location"/>:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkivdel.storageLocation}" var="sted">
                <li>${sted}</li>
              </g:each></ul>
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="files" default="Files"/>:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkivdel.file}" var="mappe">
                <li><g:link controller="basismappe" action="show" id="${mappe.id}">${mappe.title}</g:link></li>
              </g:each></ul>
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="registrations" default="Registrations"/>:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkivdel.record}" var="reg">
                <li><g:link action="show" controller="registrering" id="${reg.id}">${reg}</g:link></li>
              </g:each></ul>
          </td>
          </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <g:form>
          <input type="hidden" name="id" value="${arkivdel.id}" />
          <span class="button"><g:actionSubmit id="_action_Edit" class="edit" action="edit" value="${message(code:'action.edit',default:'Edit')}" /> </span>
          <span class="button"><g:actionSubmit class="delete" onclick="return confirm(message(code:'confirm',default:'Are you sure?'));" value="${message(code:'action.delete',default:'Delete')}" /></span>
        </g:form>
      </div>
    </div>
  </body>
</html>
