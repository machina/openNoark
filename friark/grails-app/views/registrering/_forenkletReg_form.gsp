                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="recordSection">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'recordSection','errors')}">
                                    <g:select optionKey="id" optionValue="title" from="${org.friark.ds.Series.list()}" name="recordSection.id" value="${forenkletRegistreringInstance?.recordSection?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentFile">Referanseparent Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'parentFile','errors')}">
                                    <g:select optionKey="id" optionValue="title" from="${org.friark.ds.BasicFile.list()}" name="parentFile.id" value="${forenkletRegistreringInstance?.parentFile?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdDate">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'createdDate','errors')}">
                                    <g:datePicker name="createdDate" value="${forenkletRegistreringInstance?.createdDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:forenkletRegistreringInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="archivedDate">Fondsertdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'archivedDate','errors')}">
                                    <g:datePicker name="archivedDate" value="${forenkletRegistreringInstance?.archivedDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="archivedBy">Fondsertav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'archivedBy','errors')}">
                                    <input type="text" id="archivedBy" name="archivedBy" value="${fieldValue(bean:forenkletRegistreringInstance,field:'archivedBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentClass">Referanseparent Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'parentClass','errors')}">
                                    <g:select optionKey="id" from="${org.friark.ds.Klass.list()}" name="parentClass.id" value="${forenkletRegistreringInstance?.parentClass?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumenter">Dokumenter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'document','errors')}">
                                    
<ul>
<g:each var="d" in="${forenkletRegistreringInstance?.document?}">
    <li><g:link controller="documentLink" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="documentLink" params="['journalpost.id':forenkletRegistreringInstance?.id]" action="create">Add Dokumentlink</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="documentObject">Referansedokument Objekt:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'documentObject','errors')}">
                                    
<ul>
<g:each var="r" in="${forenkletRegistreringInstance?.documentObject?}">
    <li><g:link controller="documentObject" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="documentObject" params="['journalpost.id':forenkletRegistreringInstance?.id]" action="create">Add Dokumentobjekt</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="preservationAndDisposal">Bevaring Og Kassasjon:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'preservationAndDisposal','errors')}">
                                    <g:select optionKey="id" from="${org.friark.ds.PreservationAndDisposal.list()}" name="preservationAndDisposal.id" value="${forenkletRegistreringInstance?.preservationAndDisposal?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 

