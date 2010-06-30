<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create ClassificationSystem</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ClassificationSystem List</g:link></span>
        </div>
        <div class="body">
            <h1>Create ClassificationSystem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${klassifikasjonssystemInstance}">
            <div class="errors">
                <g:renderErrors bean="${klassifikasjonssystemInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="classificationType">Klassifikasjonstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'classificationType','errors')}">
                                    <input type="text" id="classificationType" name="classificationType" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'classificationType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klassifikasjonssystemInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:klassifikasjonssystemInstance,field:'description')}"/>
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
