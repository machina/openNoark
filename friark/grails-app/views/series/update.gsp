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
						<g:render model="['arkivdel': arkivdel]" template="createFormValues"/>
						<tr>
              <td><label for="finalisedBy">Avsluttet av</label></td>
              <td><g:textField id="finalisedBy" name="finalisedBy" value="${arkivdel.finalisedBy}"/></td>
            </tr>
            <tr>
              <td><label for="parent">Avsluttet dato</label></td>
              <td><fa:datePicker precision="day" default="none" name="finalisedDate" noSelection="${[':':'Ikke valgt']}" value="${arkivdel.finalisedDate}"/></td>
            </tr> 
						<tr>
              <td><label for="arkivdelstatus">Status</label></td>
							<td><g:select name="recordSectionStatus" value="${arkivdel.recordSectionStatus}" from='${["Opprettet", "Avsluttet"]}'></g:select></td>
            </tr>
						<tr class="prop">
            	<td valign="top" class="name">
            		<label for="Oppbevaringsted">Oppbevaringsted:</label>
	             </td>
               <td valign="top" class="value">
  	             <ul>
    	             <g:each in="${arkivdel.storageLocation}" var="sted">
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
									<g:each var="r" in="${arkivdel?.file}">
								    <li><g:link controller="basismappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
									</g:each>
								</ul>
								<g:link controller="basismappe" params="['arkivdelid':arkivdel?.id]" action="create">Lag ny mappe</g:link>
              </td>
            </tr>
						<tr>
   						<td><label for="bevaringOgKassasjon">Kassasjonsvedtak</label></td>
							<td><g:select name="preservationAndDisposal.id" noSelection="${[null:'Velg']}" from='${PreservationAndDisposal.list()}' optionKey="id" value="${arkivdel.preservationAndDisposal}"></g:select></td>
						</tr>

            <tr>
              <td>&nbsp;</td>
              <td><g:submitButton name="save" value="Endre arkivdel"/></td>
            </tr>

          </table>
        </g:form>
    </body>
</html>
