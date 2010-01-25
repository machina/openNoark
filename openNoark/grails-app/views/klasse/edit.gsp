<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Klasse</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Klasse List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Klasse</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Klasse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${klasseInstance}">
            <div class="errors">
                <g:renderErrors bean="${klasseInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${klasseInstance?.id}" />
                <input type="hidden" name="version" value="${klasseInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="systemID">SystemID:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'systemID','errors')}">
                                    <input type="text" id="systemID" name="systemID" value="${fieldValue(bean:klasseInstance,field:'systemID')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klasseid">Klasseid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'klasseid','errors')}">
                                    <input type="text" id="klasseid" name="klasseid" value="${fieldValue(bean:klasseInstance,field:'klasseid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tittel">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'tittel','errors')}">
                                    <input type="text" id="tittel" name="tittel" value="${fieldValue(bean:klasseInstance,field:'tittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beskrivelse">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'beskrivelse','errors')}">
                                    <input type="text" id="beskrivelse" name="beskrivelse" value="${fieldValue(bean:klasseInstance,field:'beskrivelse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nøkkelord">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'nøkkelord','errors')}">
                                 	<ul>
																		<g:each in="${klasseInstance.nøkkelord}" var="ord">
																			<li>${ord}</li>
																		</g:each>
																			<li><g:link controller="keyword" action="edit" id="${klasseInstance.systemID}">Rediger nøkkelord</g:link>
																	</ul> 
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${klasseInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:klasseInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="avsluttetdato">Avsluttetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'avsluttetdato','errors')}">
                                    <g:datePicker name="avsluttetdato" value="${klasseInstance?.avsluttetdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="avsluttetav">Avsluttetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'avsluttetav','errors')}">
                                    <input type="text" id="avsluttetav" name="avsluttetav" value="${fieldValue(bean:klasseInstance,field:'avsluttetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlassifikasjonssystem">Referanseforelder Klassifikasjonssystem:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'referanseforelderKlassifikasjonssystem','errors')}">
                                    <g:select optionKey="id" from="${Klassifikasjonssystem.list()}" name="referanseforelderKlassifikasjonssystem.id" value="${klasseInstance?.referanseforelderKlassifikasjonssystem?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlasse">Referanseforelder Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'referanseforelderKlasse','errors')}">
                                    <g:select optionKey="id" from="${Klasse.list()}" noSelection="${[null:'Velg']}" name="referanseforelderKlasse.id" value="${klasseInstance?.referanseforelderKlasse?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansebarnKlasse">Referansebarn Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'referansebarnKlasse','errors')}">
                                    
<ul>
<g:each var="r" in="${klasseInstance?.referansebarnKlasse?}">
    <li><g:link controller="klasse" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="klasse" params="['klasse.id':klasseInstance?.id]" action="create">Add Klasse</g:link>

                                </td>
                            </tr> 
               			       <tr>
								            <td><label for="bevaringOgKassasjon">Kassasjonsvedtak</label></td>
            							  <td><g:select name="bevaringOgKassasjon.id" noSelection="${[null:'Velg']}" from='${BevaringOgKassasjon.list()}' optionKey="id" value="${klasseInstance.bevaringOgKassasjon.id}"></g:select></td>
      							      </tr> 
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
