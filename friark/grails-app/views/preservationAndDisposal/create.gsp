<%! import org.friark.ds.* %>


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
            <g:hasErrors bean="${preservationAndDisposalInstance}">
            <div class="errors">
                <g:renderErrors bean="${preservationAndDisposalInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
