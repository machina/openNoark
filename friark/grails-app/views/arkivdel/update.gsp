<%! import no.friark.ds.* %>
<html>
  <head>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1>><g:message code="series.edit" default="Edit series"/></h1>
  <g:if test="${errors}">
    <ul id="error_list">
      <g:each in="${errors}">
        <li>${it}</li>
      </g:each>
    </ul>
  </g:if>
  <g:form name='archive_part' id='${arkivdel?.id}' action="update">
    <table>
      <tr>
        <td><label for="tittel"><g:message code="title" default="Title"/></label></td>
        <td><g:textField id="tittel" name="tittel" value="${arkivdel.tittel}"/></td>
      </tr>
      <tr>
        <td><label for="beskrivelse"><g:message code="description" default="Description"/></label></td>
        <td><g:textField id="beskrivelse"  name="beskrivelse" value="${arkivdel.beskrivelse}"/></td>
      </tr>
      <tr>
        <td><label for="dokumentmedium"><g:message code="document.medium" default="Document medium"/></label></td>
        <td><g:textField id="dokumentmedium" name="dokumentmedium" value="${arkivdel.dokumentmedium}"/></td>
      </tr>
      <tr>
        <td><label for="forelder"><g:message code="parent" default="Parent"/></label></td>
        <td><g:select name="forelder" value="${arkivdel.referanseforelder.id}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select></td>
      </tr>
      <tr>
        <td><label for="klasifikasjonystem"><g:message code="classification.system" default="Classification system"/></label></td>
        <td><g:select name="klasifikasjonystem" value="${arkivdel.referanseklassifikasjonsSystem}" noSelection="${['null':'Velg Klasifikasjonsystem']}" from='${Klassifikasjonssystem.list()}' optionKey="id" optionValue="tittel"></g:select>
      </tr>
      <tr>
        <td><label for="arkivperiodestartdato"><g:message code="series.period.start.date" default="Period start date"/></label></td>
        <td><g:datePicker name="arkivperiodestartdato" value="${arkivdel.arkivperiodestartdato == null? 'none' : arkivdel.arkivperiodestartdato}" noSelection="['':'-Velg-']"/></td>
      </tr>
      <tr>
        <td><label for="arkivperiodesluttdato"><g:message code="series.period.end.date" default="Period end date"/></label></td>
        <td><g:datePicker name="arkivperiodesluttdato" value="${arkivdel.arkivperiodesluttdato == null? 'none' : arkivdel.arkivperiodesluttdato}" noSelection="['':'-Velg-']"/></td>
      </tr>

      <tr>
        <td><label for="arkivdelstatus"><g:message code="status" default="Status"/></label></td>
        <td><g:select name="periodeStatus" value="${arkivdel.periodeStatus}" from='${["Aktiv periode", "Overlappingsperiode","Avsluttet periode"]}'></g:select></td>
      </tr>
      <tr>
        <td><label for="forelder"><g:message code="precursor" default="Precursor"/></label></td>
        <td><g:select name="forelder" value="${arkivdel.referanseforløper}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
      </tr>
      <tr>
        <td><label for="forelder"><g:message code="successor" default="Successor"/></label></td>
        <td><g:select name="forelder" value="${arkivdel.referansearvtaker}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
      </tr>
<%-- 						<tr>
<td><label for="referanseforelder"><g:message code="fonds" default="Fonds"/></label></td>
<td><g:select name="referanseforelder" noSelection="${[null:'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel" value="${arkivdel.referanseforelder}"></g:select>
</tr>
<tr>
<td><label for="avsluttetav"><g:message code="finalised.by" default="Finalised by"/></label></td>
<td><g:textField id="avsluttetav" name="avsluttetav" value="${arkivdel.avsluttetav}"/></td>
</tr>
<tr>
<td><label for="forelder"><g:message code="finalised.date" default="Finalised date"/></label></td>
<td><fa:datePicker precision="day" default="none" name="avsluttetdato" noSelection="${[':':'Ikke valgt']}" value="${arkivdel.avsluttetdato}"/></td>
</tr> --%>
      <tr>
        <td><label for="arkivdelstatus"><g:message code="status" default="Status"/></label></td>
        <td><g:select name="arkivdelstatus" value="${arkivdel.arkivdelstatus}" from='${["Opprettet", "Avsluttet"]}'></g:select></td>
      </tr>
      <tr class="prop">
        <td valign="top" class="name">
          <label for="Oppbevaringsted"><g:message code="storage.location" default="Storage location"/>:</label>
        </td>
        <td valign="top" class="value">
          <ul>
            <g:each in="${arkivdel.oppbevaringssted}" var="sted">
              <li>${sted}</li>
            </g:each>
            <li><g:link action="håndterOppbevaringsted" id="${arkivdel.id}"><g:message code="series.handle.storage.locations" default="Handle storage locations"/></g:link></li>
          </ul>
        </td>
      </tr>

      <tr class="prop">
        <td valign="top" class="name">
          <label for="referansebarnBasismappe"><g:message code="series.basic.file" default="Basic file"/></label>
        </td>
        <td valign="top" class="value ${hasErrors(bean:arkivdel,field:'referansemappe','errors')}">
          <ul>
            <g:each var="r" in="${arkivdel?.referansemappe?}">
              <li><g:link controller="basismappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
            </g:each>
          </ul>
      <g:link controller="basismappe" params="['arkivdelid':arkivdel?.id]" action="create"><g:message code="files.create" default="Create file"/></g:link>
      </td>
      </tr>
      <tr>
        <td><label for="bevaringOgKassasjon"><g:message code="disposal.decision" default="Disposal decision"/></label></td>
        <td><g:select name="bevaringOgKassasjon.id" noSelection="${[null:'Velg']}" from='${BevaringOgKassasjon.list()}' optionKey="id" value="${arkivdel.bevaringOgKassasjon}"></g:select></td>
      </tr>


      <tr>
        <td>&nbsp;</td>
        <td><g:submitButton name="save" value="${message(code:'edit')}"/></td>
      </tr>

    </table>
  </g:form>
</body>
</html>
