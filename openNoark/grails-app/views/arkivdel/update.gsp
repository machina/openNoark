<%! import no.friark.ds.* %>
<html>
    <head>
    <meta name="layout" content="main" />
    </head>
    <body>
        <h1>Rediger arkivdel</h1>
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
              <td><label for="tittel">Tittel</label></td>
              <td><g:textField id="tittel" name="tittel" value="${arkivdel.tittel}"/></td>
            </tr>
            <tr>
              <td><label for="beskrivelse">Beskrivelse</label></td>
              <td><g:textField id="beskrivelse"  name="beskrivelse" value="${arkivdel.beskrivelse}"/></td>
            </tr>

            <tr>
              <td><label for="dokumentmedium">Dokument Medium</label></td>
              <td><g:textField id="dokumentmedium" name="dokumentmedium" value="${arkivdel.dokumentmedium}"/></td>
            </tr>
            <tr>
              <td><label for="opprettetdato">Opprettet</label></td>
              <td><g:datePicker name="opprettetdato" value="${arkivdel.opprettetdato}" noSelection="['':'-Velg-']"/></td>
            </tr>
           <tr>
              <td><label for="opprettetav">Opprettet av</label></td>
              <td><g:textField id="opprettetav" name="opprettetav" value="${arkivdel.opprettetav}"/></td>
            </tr>
						<tr>
              <td><label for="forelder">Forelder</label></td>
              <td><g:select name="forelder" value="${arkivdel.referanseforelder.id}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select></td>
            </tr>
						<tr>
              <td><label for="klasifikasjonystem">Klasifikasjonystem</label></td>
              <td><g:select name="klasifikasjonystem" value="${arkivdel.referanseklassifikasjonsSystem}" noSelection="${['null':'Velg Klasifikasjonsystem']}" from='${Klassifikasjonssystem.list()}' optionKey="id" optionValue="tittel"></g:select>
            </tr>
						<tr>
              <td><label for="arkivperiodestartdato">Periode start</label></td>
              <td><g:datePicker name="arkivperiodestartdato" value="${arkivdel.arkivperiodestartdato}" noSelection="['':'-Velg-']"/></td>
            </tr>
						<tr>
              <td><label for="arkivperiodesluttdato">Periode slutt</label></td>
              <td><g:datePicker name="arkivperiodesluttdato" value="${arkivdel.arkivperiodesluttdato}" noSelection="['':'-Velg-']"/></td>
            </tr>
						
						<tr>
              <td><label for="arkivdelstatus">Periodestatus</label></td>
              <td><g:select name="periodeStatus" value="${arkivdel.periodeStatus}" from='${["Aktiv periode", "Overlappingsperiode","Avsluttet periode"]}'></g:select></td>
            </tr>
						<tr>
              <td><label for="forelder">Forløper</label></td>
              <td><g:select name="forelder" value="${arkivdel.referanseforløper}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
            </tr>
						<tr>
              <td><label for="forelder">Arvtaker</label></td>
              <td><g:select name="forelder" value="${arkivdel.referansearvtaker}" noSelection="${['null':'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel"></g:select>
            </tr>
<%-- 						<tr>
							<td><label for="referanseforelder">Arkiv</label></td>
							<td><g:select name="referanseforelder" noSelection="${[null:'Velg forelder arkiv']}" from='${Arkiv.list()}' optionKey="id" optionValue="tittel" value="${arkivdel.referanseforelder}"></g:select>
						</tr> --%>
						<tr>
              <td><label for="avsluttetav">Avsluttet av</label></td>
              <td><g:textField id="avsluttetav" name="avsluttetav" value="${arkivdel.avsluttetav}"/></td>
            </tr>
            <tr>
              <td><label for="forelder">Avsluttet dato</label></td>
              <td><fa:datePicker precision="day" default="none" name="avsluttetdato" noSelection="${[':':'Ikke valgt']}" value="${arkivdel.avsluttetdato}"/></td>
            </tr>
						<tr>
              <td><label for="arkivdelstatus">Status</label></td>
							<td><g:select name="arkivdelstatus" value="${arkivdel.arkivdelstatus}" from='${["Opprettet", "Avsluttet"]}'></g:select></td>
            </tr>
<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="Oppbevaringsted">Oppbevaringsted:</label>
                                </td>
                                <td valign="top" class="value">
                                  <ul>
                                    <g:each in="${arkivdel.oppbevaringssted}" var="sted">
                                      <li>${sted}</li>
                                    </g:each>
                                    <li><g:link action="håndterOppbevaringsted" id="${arkivdel.id}">Håndter oppbevaringsted</g:link></li>
                                  </ul>
                                </td>
                            </tr>

						<tr class="prop">
            	<td valign="top" class="name">
              	<label for="referansebarnBasismappe">Mapper</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean:arkivdel,field:'referansemappe','errors')}">
								<ul>
									<g:each var="r" in="${arkivdel?.referansemappe?}">
								    <li><g:link controller="basismappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
									</g:each>
								</ul>
								<g:link controller="basismappe" params="['arkivdelid':arkivdel?.id]" action="create">Lag ny mappe</g:link>
              </td>
            </tr>
						<tr>
   						<td><label for="bevaringOgKassasjon">Kassasjonsvedtak</label></td>
							<td><g:select name="bevaringOgKassasjon.id" noSelection="${[null:'Velg']}" from='${BevaringOgKassasjon.list()}' optionKey="id" value="${arkivdel.bevaringOgKassasjon}"></g:select></td>
						</tr>


            <tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="Endre arkivdel"/></td>
            </tr>

          </table>
        </g:form>
    </body>
</html>
