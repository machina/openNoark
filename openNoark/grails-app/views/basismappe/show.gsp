<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Basismappe</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Basismappe List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Basismappe</g:link></span>
        </div>
        <div class="body">
            <h1>Show Basismappe</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name">SystemID:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'systemID')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mappeid:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'mappeid')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Mappetype:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'mappetype')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tittel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'tittel')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Offentligtittel:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'offentligtittel')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Beskrivelse:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'beskrivelse')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Nøkkelord:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'nøkkelord')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Dokumentmedium:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'dokumentmedium')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Oppbevaringssted:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'oppbevaringssted')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'opprettetdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Opprettetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'opprettetav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetdato:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'avsluttetdato')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Avsluttetav:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:basismappeInstance, field:'avsluttetav')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseforelder Klasse:</td>
                            
                            <td valign="top" class="value"><g:link controller="klasse" action="show" id="${basismappeInstance?.referanseforelderKlasse?.id}">${basismappeInstance?.referanseforelderKlasse?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referanseforelder Basismappe:</td>
                            
                            <td valign="top" class="value"><g:link controller="basismappe" action="show" id="${basismappeInstance?.referanseforelderBasismappe?.id}">${basismappeInstance?.referanseforelderBasismappe?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansebarn Basismappe:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${basismappeInstance.referansebarnBasismappe}">
                                    <li><g:link controller="basismappe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Referansearkivdel:</td>
                            
                            <td valign="top" class="value"><g:link controller="arkivdel" action="show" id="${basismappeInstance?.referansearkivdel?.id}">${basismappeInstance?.referansearkivdel?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                       <tr class="prop">
                            <td valign="top" class="name">Registeringer</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${basismappeInstance.referansebarnForenkletRegistrering}">
                                    <li><g:link controller="forenkletRegistrering" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
 
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${basismappeInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
								<g:form controller="forenkletRegistrering" action="create" method="get">
										<input type="hidden" name="mappe_id" value="${basismappeInstance?.id}" />
										<span class="button"><g:submitButton class="create" name="create" value="Legg til registrering" /></span>
								</g:form>
            </div>
        </div>
    </body>
</html>
