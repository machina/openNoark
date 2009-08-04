

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Dokumentbeskrivelse</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Dokumentbeskrivelse List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Dokumentbeskrivelse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${dokumentbeskrivelseInstance}">
            <div class="errors">
                <g:renderErrors bean="${dokumentbeskrivelseInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="systemid">Systemid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'systemid','errors')}">
                                    <input type="text" id="systemid" name="systemid" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'systemid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumenttype">Dokumenttype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'dokumenttype','errors')}">
                                    <input type="text" id="dokumenttype" name="dokumenttype" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'dokumenttype')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentstatus">Dokumentstatus:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'dokumentstatus','errors')}">
                                    <input type="text" id="dokumentstatus" name="dokumentstatus" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'dokumentstatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tittel">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'tittel','errors')}">
                                    <input type="text" id="tittel" name="tittel" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'tittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beskrivelse">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'beskrivelse','errors')}">
                                    <input type="text" id="beskrivelse" name="beskrivelse" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'beskrivelse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="forfatter">Forfatter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'forfatter','errors')}">
                                    <input type="text" id="forfatter" name="forfatter" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'forfatter')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${dokumentbeskrivelseInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentmedium">Dokumentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'dokumentmedium','errors')}">
                                    <input type="text" id="dokumentmedium" name="dokumentmedium" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'dokumentmedium')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="oppbevaringssted">Oppbevaringssted:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:dokumentbeskrivelseInstance,field:'oppbevaringssted','errors')}">
                                    <input type="text" id="oppbevaringssted" name="oppbevaringssted" value="${fieldValue(bean:dokumentbeskrivelseInstance,field:'oppbevaringssted')}"/>
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
