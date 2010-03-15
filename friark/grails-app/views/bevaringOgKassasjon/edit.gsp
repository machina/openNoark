<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit BevaringOgKassasjon</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">BevaringOgKassasjon List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New BevaringOgKassasjon</g:link></span>
        </div>
        <div class="body">
            <h1>Edit BevaringOgKassasjon</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${bevaringOgKassasjonInstance}">
            <div class="errors">
                <g:renderErrors bean="${bevaringOgKassasjonInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${bevaringOgKassasjonInstance?.id}" />
                <input type="hidden" name="version" value="${bevaringOgKassasjonInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="kassasjonsvedtak">Kassasjonsvedtak:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'kassasjonsvedtak','errors')}">
                                    <g:select id="kassasjonsvedtak" name="kassasjonsvedtak" from='${["Bevares", "Kasseres", "Vurderes senere"]}' value="${fieldValue(bean:bevaringOgKassasjonInstance,field:'kassasjonsvedtak')}" noSelection="${['null':'Velg']}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="kassasjonshjemmel">Kassasjonshjemmel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'kassasjonshjemmel','errors')}">
                                    <input type="text" id="kassasjonshjemmel" name="kassasjonshjemmel" value="${fieldValue(bean:bevaringOgKassasjonInstance,field:'kassasjonshjemmel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="bevaringstid">Bevaringstid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'bevaringstid','errors')}">
                                    <input type="text" id="bevaringstid" name="bevaringstid" value="${fieldValue(bean:bevaringOgKassasjonInstance,field:'bevaringstid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="kassasjonsdato">Kassasjonsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'kassasjonsdato','errors')}">
                                    <g:datePicker name="kassasjonsdato" value="${bevaringOgKassasjonInstance?.kassasjonsdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="registrering">Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'registrering','errors')}">
                                    
<ul>
<g:each var="r" in="${bevaringOgKassasjonInstance?.registrering?}">
    <li><g:link controller="forenkletRegistrering" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="forenkletRegistrering" params="['bevaringOgKassasjon.id':bevaringOgKassasjonInstance?.id]" action="create">Add ForenkletRegistrering</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivdel">Arkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'arkivdel','errors')}">
                                    
<ul>
<g:each var="a" in="${bevaringOgKassasjonInstance?.arkivdel?}">
    <li><g:link controller="arkivdel" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="arkivdel" params="['bevaringOgKassasjon.id':bevaringOgKassasjonInstance?.id]" action="create">Add Arkivdel</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappe">Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'mappe','errors')}">
                                    
<ul>
<g:each var="m" in="${bevaringOgKassasjonInstance?.mappe?}">
    <li><g:link controller="basismappe" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="basismappe" params="['bevaringOgKassasjon.id':bevaringOgKassasjonInstance?.id]" action="create">Add Basismappe</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klasse">Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'klasse','errors')}">
                                    
<ul>
<g:each var="k" in="${bevaringOgKassasjonInstance?.klasse?}">
    <li><g:link controller="klasse" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="klasse" params="['bevaringOgKassasjon.id':bevaringOgKassasjonInstance?.id]" action="create">Add Klasse</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentBeskrivelse">Dokument Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:bevaringOgKassasjonInstance,field:'dokumentBeskrivelse','errors')}">
                                    
<ul>
<g:each var="d" in="${bevaringOgKassasjonInstance?.dokumentBeskrivelse?}">
    <li><g:link controller="dokumentbeskrivelse" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="dokumentbeskrivelse" params="['bevaringOgKassasjon.id':bevaringOgKassasjonInstance?.id]" action="create">Add Dokumentbeskrivelse</g:link>

                                </td>
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
