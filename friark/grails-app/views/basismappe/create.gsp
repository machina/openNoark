<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Basismappe</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Basismappe List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Basismappe</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${basismappeInstance}">
            <div class="errors">
                <g:renderErrors bean="${basismappeInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappeid">Mappeid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'mappeid','errors')}">
                                    <input type="text" id="mappeid" name="mappeid" value="${fieldValue(bean:basismappeInstance,field:'mappeid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappetype">Mappetype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'mappetype','errors')}">
                                    <input type="text" id="mappetype" name="mappetype" value="${fieldValue(bean:basismappeInstance,field:'mappetype')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:basismappeInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="offentligtitle">Offentligtitle:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'offentligtitle','errors')}">
                                    <input type="text" id="offentligtitle" name="offentligtitle" value="${fieldValue(bean:basismappeInstance,field:'offentligtitle')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:basismappeInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentMedium">Dokumentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'documentMedium','errors')}">
                                    <input type="text" id="documentMedium" name="documentMedium" value="${fieldValue(bean:basismappeInstance,field:'documentMedium')}"/>
                                </td>
                            </tr> 
 														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ibasismappeInstance,field:'nøkkelord','errors')}">
                                    <input type="text" id="nøkkelord" name="nøkkelord"/>
                                </td>
                            </tr> 
                      
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseparentKlasse">Referanseparent Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseparentKlasse','errors')}">
                                    <g:select optionKey="id" optionValue="title" noSelection="${[null:'Velg klasse']}" from="${Klasse.list()}" name="referanseparentKlasse.id" value="${basismappeInstance?.referanseparentKlasse?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseparentBasismappe">Referanseparent Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseparentBasismappe','errors')}">
                                    <g:select optionKey="id" optionValue="title" noSelection="${[null:'Velg parentmappe']}" from="${Basismappe.list()}" name="referanseparentBasismappe.id" value="${basismappeInstance?.referanseparentBasismappe?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansearkivdel">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referansearkivdel','errors')}">
                                    <g:select optionKey="id" optionValue="title" noSelection="${[null:'Velg parent arkivdel']}" from="${Series.list()}" name="referansearkivdel.id" value="${basismappeInstance?.referansearkivdel?.id}"></g:select>
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
