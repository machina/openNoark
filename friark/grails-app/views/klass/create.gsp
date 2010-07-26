<%! import org.friark.ds.* %>


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
                                    <label for="classID">Klasseid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'classID','errors')}">
                                    <input type="text" id="classID" name="classID" value="${fieldValue(bean:klasseInstance,field:'classID')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:klasseInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:klasseInstance,field:'description')}"/>
                                </td>
                            </tr> 
 													  <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'keyword','errors')}">
                                    <input type="text" id="keyword" name="keyword"/>
                                </td>
                            </tr> 
                       
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentClassificationSystem">Referanseparent ClassificationSystem:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'parentClassificationSystem','errors')}">
                                    <g:select optionKey="id" noSelection="${['null':'Velg...']}" from="${ClassificationSystem.list()}" name="parentClassificationSystem.id" value="${klasseInstance?.parentClassificationSystem?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentClass">Referanseparent Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'parentClass','errors')}">
                                    <g:select optionKey="id" noSelection="${['null':'Velg...']}" from="${Klass.list()}" name="parentClass.id" value="${klasseInstance?.parentClass?.id}" ></g:select>
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
