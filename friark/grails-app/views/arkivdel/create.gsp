<%! import no.friark.ds.* %>
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
      <tr>
        <td><label for="tittel"><g:message code="title" default="Title"/></label></td>
        <td><g:textField id="tittel" name="tittel" value="${tittel}"/></td>
      </tr>
      <tr>
        <td><label for="beskrivelse"><g:message code="description" default="Description"/></label></td>
        <td><g:textField id="beskrivelse"  name="beskrivelse" value="${beskrivelse}"/></td>
      </tr>
      <tr>
        <td><label for="dokumentmedium"><g:message code="document.medium" default="Document medium"/></label></td>
        <td><g:textField id="dokumentmedium" name="dokumentmedium" value="${dokumentmedium}"/></td>
      </tr>
<%-- <tr>
<td><label for="opprettetdato"><g:message code="created.date" default="Created date"/></label></td>
<td><g:datePicker name="opprettetdato" value="${new Date()}" noSelection="['':'-Velg-']"/></td>
</tr>
<tr>
<td><label for="opprettetav"><g:message code="created.by" default="Created by"/></label></td>
<td><g:textField id="opprettetav" name="opprettetav" value="${opprettetav}"/></td>
</tr> --%>
      <tr>
        <td><label for="klasifikasjonystem"><g:message code="classification.system" default="Classification system"/></label></td>
        <td><g:select name="klasifikasjonystem" value="${arkivdel?.referanseklassifikasjonsSystem}" noSelection="${['null':'Velg Klasifikasjonsystem']}" from='${Klassifikasjonssystem.list()}' optionKey="id" optionValue="tittel"></g:select>
      </tr>
      <tr>
        <td><label for="arkivperiodestartdato"><g:message code="series.period.start.date" default="Period start date"/></label></td>
        <td><g:datePicker name="arkivperiodestartdato" value="none" noSelection="['':'-Velg-']" precision="day"/></td>
      </tr>
      <tr>
        <td><label for="arkivperiodesluttdato"><g:message code="series.period.end.date" default="Period end date"/></label></td>
        <td><g:datePicker name="arkivperiodesluttdato" value="none" noSelection="['':'-Velg-']" precision="day"/></td>
      </tr>
      <tr>
        <td><label for="forelder"><g:message code="precursor" default="Precursor"/></label></td>
        <td><g:select name="forelder" value="${arkivdel?.referanseforløper}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkivdel.list()}' optionKey="id" optionValue="tittel"></g:select>
      </tr>
      <tr>
        <td><label for="forelder"><g:message code="successor" default="Successor"/></label></td>
        <td><g:select name="forelder" value="${arkivdel?.referansearvtaker}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkivdel.list()}' optionKey="id" optionValue="tittel"></g:select>
      </tr>
      <tr>
        <td><label for="referanseforelder"><g:message code="fonds" default="Fonds"/></label></td>
        <td><g:select name="referanseforelder" noSelection="${[null:'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
      <tr>

      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code:'series.create'}"/></td>
      </tr>

    </table>
  </g:form>
</body>
</html>
