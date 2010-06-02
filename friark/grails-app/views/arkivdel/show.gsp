<%! import no.friark.ds.* %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title><g:message code="series" default="Series" /></title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${resource(dir:'')}"><g:message code="title" default="Title"/>Home</a></span>
      <span class="menuButton"><g:link class="list" action="list"><g:message code="title" default="Title"/>Arkivdel Liste</g:link></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="title" default="Title"/>Ny Arkivdel</g:link></span>
    </div>
    <div class="body">
      <h1>Arkivdel</h1>
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
          <td valign="top" class="value">${arkivdel.tittel}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="description" default="Description"/>:</td>
          <td valign="top" class="value">${arkivdel.beskrivelse}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="status" default="Status"/>:</td>
          <td valign="top" class="value">${arkivdel.arkivdelstatus}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="document.medium" default="Document medium"/>:</td>
          <td valign="top" class="value">${arkivdel.dokumentmedium}</td>
          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="created.date" default="Create date"/>:</td>
          <td valign="top" class="value">${arkivdel.opprettetdato}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="created.by" default="Created by"/>:</td>
          <td valign="top" class="value">${arkivdel.opprettetav}</td>
          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="finalised.date" default="Finalised date"/>:</td>
          <td valign="top" class="value">${arkivdel.avsluttetdato}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="finalised.by" default="Finalised by"/>:</td>
          <td valign="top" class="value">${arkivdel.avsluttetav}</td>
          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="series.period.start.date" default="Period start date"/>:</td>
          <td valign="top" class="value">${arkivdel.arkivperiodestartdato}</td>
          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="series.period.end.date" default="Period end date"/>:</td>
          <td valign="top" class="value">${arkivdel.arkivperiodesluttdato}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="fonds.parent" default="Fonds parent"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.referanseforelder}"><g:link action="show" controller="arkiv" id="${arkivdel.referanseforelder.id}">${arkivdel.referanseforelder.tittel}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="precursor" default="Precursor"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.referanseforløper}"><g:link action="show" id="${arkivdel.referanseforløper.id}">${arkivdel.referanseforløper}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="successor" default="Successor"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.referansearvtaker}"><g:link action="show" id="${arkivdel.referansearvtaker.id}">${arkivdel.referansearvtaker}</g:link></g:if></td>
          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="classification.system" default="Classification system"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.referanseklassifikasjonsSystem}"><g:link action="show" controller="klassifikasjonsSystem" id="${arkivdel.referanseklassifikasjonsSystem.id}">${arkivdel.referanseklassifikasjonsSystem}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="preservation.and.disposal" default="Preservation and disposal"/>:</td>
          <td valign="top" class="value"><g:if test="${arkivdel.bevaringOgKassasjon}"><g:link action="show" controller="bevaringOgKassasjon" id="${arkivdel.bevaringOgKassasjon.id}">${arkivdel.bevaringOgKassasjon}</g:link></g:if></td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storage.location" default="Storage location"/>:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkivdel.oppbevaringssted}" var="sted">
                <li>${sted}</li>
              </g:each></ul>
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="title" default="Title"/>Mapper:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkivdel.referansemappe}" var="mappe">
                <li><g:link controller="basismappe" action="show" id="${mappe.id}">${mappe.tittel}</g:link></li>
              </g:each></ul>
          </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="title" default="Title"/>Registreringer:</td>
          <td valign="top" class="value"><ul>
              <g:each in="${arkivdel.referanseregistrering}" var="reg">
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
          <span class="button"><g:actionSubmit id="${arkivdel.id}" class="edit" value="Edit" /></span>
          <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
        </g:form>
	<%--								
	<g:form controller="merknad" action="create" method="get">
		<input type="hidden" name="systemID" value="${arkiv?.systemID}" />
		<span class="button"><g:submitButton class="create" name="create_merknad" value="Legg til merknad" /></span>
	</g:form> 
	--%>
      </div>
    </div>
  </body>
</html>
