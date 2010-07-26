<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Klasse</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Klasse List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Klasse</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Klasse</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${klasseInstance}">
            <div class="errors">
                <g:renderErrors bean="${klasseInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${klasseInstance?.id}" />
                <input type="hidden" name="version" value="${klasseInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="systemID">SystemID:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'systemID','errors')}">
                                    <input type="text" id="systemID" name="systemID" value="${fieldValue(bean:klasseInstance,field:'systemID')}"/>
                                </td>
                            </tr> 
                        
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
                                    <label for="keyword">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'keyword','errors')}">
                                 	<ul>
																		<g:each in="${klasseInstance.keyword}" var="ord">
																			<li>${ord}</li>
																		</g:each>
																			<li><g:link controller="keyword" action="edit" id="${klasseInstance.systemID}">Rediger keyword</g:link>
																	</ul> 
                                </td>
                            </tr> 
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="finalisedDate">Avsluttetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'finalisedDate','errors')}">
                                    <fa:datePicker name="finalisedDate" value="${klasseInstance.finalisedDate}" precision="day" noSelection="['':'']"></fa:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentClassificationSystem">Referanseparent ClassificationSystem:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'parentClassificationSystem','errors')}">
                                    <g:select optionKey="id" from="${ClassificationSystem.list()}" name="parentClassificationSystem.id" value="${klasseInstance?.parentClassificationSystem?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentClass">Referanseparent Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'parentClass','errors')}">
                                    <g:select optionKey="id" from="${Klass.list()}" noSelection="${[null:'Velg']}" name="referanseparentKlass.id" value="${klasseInstance?.parentClass?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="childClass">Referansebarn Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:klasseInstance,field:'childClass','errors')}">
                                    
<ul>
<g:each var="r" in="${klasseInstance?.childClass?}">
    <li><g:link controller="klasse" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="klasse" params="['klasse.id':klasseInstance?.id]" action="create">Add Klasse</g:link>

                                </td>
                            </tr> 
               			       <tr>
								            <td><label for="preservationAndDisposal">Kassasjonsvedtak</label></td>
            							  <td><g:select name="preservationAndDisposal.id" noSelection="${[null:'Velg']}" from='${PreservationAndDisposal.list()}' optionKey="id" value="${klasseInstance.preservationAndDisposal?.id}"></g:select></td>
      							      </tr> 
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
