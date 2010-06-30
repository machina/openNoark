<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Merknad</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Merknad List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Merknad</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${merknadInstance}">
            <div class="errors">
                <g:renderErrors bean="${merknadInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkText">Merknadstekst:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkText','errors')}">
                                    <input type="text" id="remarkText" name="remarkText" value="${fieldValue(bean:merknadInstance,field:'remarkText')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkDate">Merknadsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkDate','errors')}">
                                    <g:datePicker name="remarkDate" value="${merknadInstance?.remarkDate}" precision="day" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkRegisteredBy">Merknadregistrertav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkRegisteredBy','errors')}">
                                    <input type="text" id="remarkRegisteredBy" name="remarkRegisteredBy" value="${fieldValue(bean:merknadInstance,field:'remarkRegisteredBy')}"/>
                                </td>
                            </tr> 
                        
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkType">Merknadstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'remarkType','errors')}">
                                    <g:select optionKey="id" optionValue="name" from="${RemarkType.list()}" name="remarkType.id" noSelection="${[null:'Velg type']}" value="${merknadInstance?.remarkType?.id}" ></g:select>
                                </td>
                            </tr> 
														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkType">BaisbasicFile:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'basicFile','errors')}">
                                    <g:select optionKey="id" optionValue="title" from="${BasicFile.list()}" name="basicFile.id" noSelection="${[null:'Velg type']}" value="${merknadInstance?.basicFile?.id}" ></g:select>
                                </td>
                            </tr> 
														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarkType">Dokumentdescription:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:merknadInstance,field:'documentDescription','errors')}">
                                    <g:select optionKey="id" optionValue="systemID" from="${DocumentDescription.list()}" name="documentDescription.id" noSelection="${[null:'Velg type']}" value="${merknadInstance?.documentDescription?.id}" ></g:select>
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
