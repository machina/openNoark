
<%@ page import="no.friark.ds.FondsCreator" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title><g:message code="fondscreator.edit" default="Edit fonds creator"/></title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
      <span class="menuButton"><g:link class="list" action="list"><g:message code="fondscreator.list" default="Fonds creator list"/></g:link></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="action.new" default="New"/></g:link></span>
    </div>
    <div class="body">
      <h1><g:message code="action.edit" default="Edit"/></h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${fondsCreatorInstance}">
        <div class="errors">
          <g:renderErrors bean="${fondsCreatorInstance}" as="list" />
        </div>
      </g:hasErrors>
      <g:form method="post" >
        <input type="hidden" name="id" value="${fondsCreatorInstance?.id}" />
        <input type="hidden" name="version" value="${fondsCreatorInstance?.version}" />
        <div class="dialog">
          <table>
            <tbody>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="fondsCreatorID"><g:message code="id" default="ID"/>:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'fondsCreatorID','errors')}">
                  <input type="text" id="fondsCreatorID" name="fondsCreatorID" value="${fieldValue(bean:fondsCreatorInstance,field:'fondsCreatorID')}"/>
                </td>
              </tr>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="fondsCreatorName"><g:message code="name" default="Name"/>:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'fondsCreatorName','errors')}">
                  <input type="text" id="fondsCreatorName" name="fondsCreatorName" value="${fieldValue(bean:fondsCreatorInstance,field:'fondsCreatorName')}"/>
                </td>
              </tr>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="description"><g:message code="description" default="Description"/>:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'description','errors')}">
                  <input type="text" id="description" name="description" value="${fieldValue(bean:fondsCreatorInstance,field:'description')}"/>
                </td>
              </tr>

              <tr class="prop">
                <td valign="top" class="name">
                  <label for="arkiv"><g:message code="fonds" default="Fonds"/>:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:fondsCreatorInstance,field:'fonds','errors')}">
            <g:select name="fonds"
                      from="${no.friark.ds.Fonds.list()}"
                      size="5" multiple="yes" optionKey="id"
                      value="${fondsCreatorInstance?.fonds}" />

            </td>
            </tr>

            </tbody>
          </table>
        </div>
        <div class="buttons">
          <span class="button"><g:actionSubmit class="save" action="update" value="${message(code:'action.update')}" /></span>
          <span class="button"><g:actionSubmit class="delete" onclick="return confirm(message(code:'confirm.action'));" value="${message(code:'action.delete')}" /></span>
        </div>
      </g:form>
    </div>
  </body>
</html>
