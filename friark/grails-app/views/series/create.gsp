<%! import org.friark.ds.* %>
<html>
    <head>
    <meta name="layout" content="main" />
    </head>
    <body>
        <h1><g:message code="series.create" default="Create series"/></h1>
        <g:if test="${errors}">
          <ul id="error_list">
            <g:each in="${errors}">
              <li>${it}</li>
            </g:each>
          </ul>
        </g:if>
        <g:form name='archive_part' id='archive_part' action="save">
          <table>
						<g:render template="createFormValues" />
            <tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="${message(code:'action.save',default:'Save')}"/></td>
            </tr>

          </table>
        </g:form>
    </body>
</html>

