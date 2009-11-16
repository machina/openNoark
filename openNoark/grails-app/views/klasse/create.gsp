

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Klasse</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Klasse List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Klasse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${klasseInstance}">
            <div class="errors">
                <g:renderErrors bean="${klasseInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
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
                                    <label for="opprettetav">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'nøkkelord','errors')}">
                                    <input type="text" id="nøkkelord" name="nøkkelord"/>
                                </td>
                            </tr> 
                       
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlassifikasjonssystem">Referanseforelder Klassifikasjonssystem:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'referanseforelderKlassifikasjonssystem','errors')}">
                                    <g:select optionKey="id" noSelection="${['null':'Velg...']}" from="${Klassifikasjonssystem.list()}" name="referanseforelderKlassifikasjonssystem.id" value="${klasseInstance?.referanseforelderKlassifikasjonssystem?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlasse">Referanseforelder Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'referanseforelderKlasse','errors')}">
                                    <g:select optionKey="id" noSelection="${['null':'Velg...']}" from="${Klasse.list()}" name="referanseforelderKlasse.id" value="${klasseInstance?.referanseforelderKlasse?.id}" ></g:select>
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
