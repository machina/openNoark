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
            <g:hasErrors bean="${preservationAndDisposalInstance}">
            <div class="errors">
                <g:renderErrors bean="${preservationAndDisposalInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${preservationAndDisposalInstance?.id}" />
                <input type="hidden" name="version" value="${preservationAndDisposalInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="disposalDecision">Kassasjonsvedtak:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'disposalDecision','errors')}">
                                    <g:select id="disposalDecision" name="disposalDecision" from='${["Bevares", "Kasseres", "Vurderes senere"]}' value="${fieldValue(bean:preservationAndDisposalInstance,field:'disposalDecision')}" noSelection="${['null':'Velg']}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="disposalAuthority">Kassasjonshjemmel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'disposalAuthority','errors')}">
                                    <input type="text" id="disposalAuthority" name="disposalAuthority" value="${fieldValue(bean:preservationAndDisposalInstance,field:'disposalAuthority')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="preservationTime">Bevaringstid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'preservationTime','errors')}">
                                    <input type="text" id="preservationTime" name="preservationTime" value="${fieldValue(bean:preservationAndDisposalInstance,field:'preservationTime')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="disposalDate">Kassasjonsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'disposalDate','errors')}">
                                    <g:datePicker name="disposalDate" value="${preservationAndDisposalInstance?.disposalDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="record">Registrering:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'record','errors')}">
                                    
<ul>
<g:each var="r" in="${preservationAndDisposalInstance?.record?}">
    <li><g:link controller="forenkletRegistrering" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="forenkletRegistrering" params="['bevaringOgKassasjon.id':preservationAndDisposalInstance?.id]" action="create">Add SimplifiedRecord</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="series">Arkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'series','errors')}">
                                    
<ul>
<g:each var="a" in="${preservationAndDisposalInstance?.series?}">
    <li><g:link controller="series" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="series" params="['bevaringOgKassasjon.id':preservationAndDisposalInstance?.id]" action="create">Add Arkivdel</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="file">Mappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'file','errors')}">
                                    
<ul>
<g:each var="m" in="${preservationAndDisposalInstance?.file?}">
    <li><g:link controller="file" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="file" params="['bevaringOgKassasjon.id':preservationAndDisposalInstance?.id]" action="create">Add BasicFile</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klass">Klass:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'klass','errors')}">
                                    
<ul>
<g:each var="k" in="${preservationAndDisposalInstance?.klass?}">
    <li><g:link controller="klass" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="klass" params="['bevaringOgKassasjon.id':preservationAndDisposalInstance?.id]" action="create">Add Klass</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentDescription">Dokument Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:preservationAndDisposalInstance,field:'documentDescription','errors')}">
                                    
<ul>
<g:each var="d" in="${preservationAndDisposalInstance?.documentDescription?}">
    <li><g:link controller="dokumentdescription" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="dokumentdescription" params="['bevaringOgKassasjon.id':preservationAndDisposalInstance?.id]" action="create">Add DocumentDescription</g:link>

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
