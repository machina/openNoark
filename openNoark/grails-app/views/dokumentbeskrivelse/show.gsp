

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Dokumentbeskrivelse</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Dokumentbeskrivelse List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Dokumentbeskrivelse</g:link></span>
        </div>
        <div class="body">
            <h1>Show Dokumentbeskrivelse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Systemid:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'systemid')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokumenttype:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'dokumenttype')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokumentstatus:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'dokumentstatus')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tittel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'tittel')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'beskrivelse')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Forfatter:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'forfatter')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'opprettetdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'opprettetav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokumentmedium:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'dokumentmedium')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Oppbevaringssted:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:dokumentbeskrivelseInstance, field:'oppbevaringssted')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansedokument Objekt:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${dokumentbeskrivelseInstance.referansedokumentObjekt}">
                                    <li><g:link controller="dokumentobjekt" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${dokumentbeskrivelseInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
