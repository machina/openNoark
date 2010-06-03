<%! import no.friark.ds.* %>
<html>
    <head>
    <meta name="layout" content="main" />
    </head>
    <body>
        <h1>Lag ny arkivdel</h1>
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
              <td><g:submitButton name="save" value="Opprett arkivdel"/></td>
            </tr>

          </table>
        </g:form>
    </body>
</html>

