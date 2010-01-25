<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create BevaringOgKassasjon</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">BevaringOgKassasjon List</g:link></span>
        </div>
        <div class="body">
            <h1>Create BevaringOgKassasjon</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${bevaringOgKassasjonInstance}">
            <div class="errors">
                <g:renderErrors bean="${bevaringOgKassasjonInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
