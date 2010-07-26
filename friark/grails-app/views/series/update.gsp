<%! import org.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1><g:message code="series.edit" default="Edit series"/></h1>
  <g:if test="${errors}">
    <ul id="error_list">
      <g:each in="${errors}">
        <li>${it}</li>
      </g:each>
    </ul>
  </g:if>
  <g:form name='archive_part' id='${arkivdel?.id}' action="update">
    <table>
      <g:render model="['arkivdel': arkivdel]" template="createFormValues"/>
      <tr>
        <td><label for="finalisedBy"><g:message code="finalised.by" default="Finalised by"/></label></td>
        <td><g:textField id="finalisedBy" name="finalisedBy" value="${arkivdel.finalisedBy}"/></td>
      </tr>
      <tr>
        <td><label for="parent"><g:message code="finalised.date" default="Finalised date"/></label></td>
        <td><fa:datePicker precision="day" default="none" name="finalisedDate" noSelection="${[':':message(code:'not.selected',default:'Not selected')]}" value="${arkivdel.finalisedDate}"/></td>
      </tr>

       <tr>
        <td><label for="recordSectionStatus"><g:message code="status" default="Status"/></label></td>
        <td><g:select optionKey="val" optionValue="msg" name="recordSectionStatus" value="${arkivdel.recordSectionStatus}" from="${[[val: 'Opprettet', msg: message(code:'created')],[val: 'Avsluttet', msg: message(code:'closed')]]}"></g:select></td>
      </tr>
      
      <tr class="prop">
        <td valign="top" class="name">
          <label for="Oppbevaringsted"><g:message code="storage.location" default="Storage location"/>:</label>
        </td>
        <td valign="top" class="value">
          <ul>
            <g:each in="${arkivdel.storageLocation}" var="sted">
              <li>${sted}</li>
            </g:each>
            <li><g:link action="handleStorageLocation" id="${arkivdel.id}"><g:message code="series.handle.storage.lcations" default="Handle storage locations"/></g:link></li>
          </ul>
        </td>
      </tr>
      <tr class="prop">
        <td valign="top" class="name">
          <label for="referansebarnBasismappe"><g:message code="Files" default="Files"/></label>
        </td>
        <td valign="top" class="value ${hasErrors(bean:arkivdel,field:'referansemappe','errors')}">
          <ul>
            <g:each var="r" in="${arkivdel?.file}">
              <li><g:link controller="mappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
            </g:each>
          </ul>
      <g:link controller="mappe" params="['arkivdelid':arkivdel?.id]" action="create"><g:message code="action.create" default="Create"/></g:link>
      </td>
      </tr>
      <tr>
        <td><label for="bevaringOgKassasjon"><g:message code="preservation.and.disposal" default="Presaervation and disposal"/></label></td>
        <td><g:select name="preservationAndDisposal.id" noSelection="${[null:message(code:'select',default:'Select ...')]}" from='${PreservationAndDisposal.list()}' optionKey="id" value="${arkivdel.preservationAndDisposal}"></g:select></td>
      </tr>

      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code:'save',default:'Save')}"/></td>
      </tr>

    </table>
  </g:form>
</body>
</html>
