
<%@ page import="no.friark.ds.FondsCreator" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Show FondsCreator</title>
  </head>
  <body>

    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="home" default="Home"/></a></span>
      <span class="menuButton"><g:link class="list" action="list"><g:message code="list" default="List"/></g:link></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="action.create" default="Create"/></g:link></span>
    </div>

    <div class="body">
      <h1><g:message code="fondscreator.show" default="Show fonds creator"/></h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
     <div class="dialog">
        <table>
          <tbody>
            <tr class="prop">
              <td valign="top" class="name"><g:message code="id" default="ID"/>:</td>
              <td valign="top" class="value">${fieldValue(bean:fondsCreatorInstance, field:'id')}</td>
            </tr>

            <tr class="prop">
              <td valign="top" class="name"><g:message code="fondscreator.id" default="FondsCreatorID"/>:</td>
              <td valign="top" class="value">${fieldValue(bean:fondsCreatorInstance, field:'fondsCreatorID')}</td>

            </tr>

            <tr class="prop">
              <td valign="top" class="name"><g:message code="name" default="Name"/>:</td>
              <td valign="top" class="value">${fieldValue(bean:fondsCreatorInstance, field:'fondsCreatorName')}</td>

            </tr>

            <tr class="prop">
              <td valign="top" class="name"><g:message code="description" default="Description"/>:</td>

              <td valign="top" class="value">${fieldValue(bean:fondsCreatorInstance, field:'description')}</td>

            </tr>

            <tr class="prop">
              <td valign="top" class="name">Fonds:</td>

              <td  valign="top" style="text-align:left;" class="value">
                <ul>
                  <g:each var="a" in="${fondsCreatorInstance.fonds}">
                    <li><g:link controller="arkiv" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
                  </g:each>
                </ul>
              </td>

            </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <g:form>
          <input type="hidden" name="id" value="${fondsCreatorInstance?.id}" />
          <span class="button"><g:actionSubmit class="edit" value="${message(code:'action.edit')}" /></span>
          <span class="button"><g:actionSubmit class="delete" onclick="return confirm(message(code:'confirm.action'));" value="Delete" /></span>
        </g:form>
      </div>
    </div>
  </body>

</html>
