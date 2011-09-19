<%! import org.friark.ds.* %>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappetype">Mappetype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'mappetype','errors')}">
																				<g:select name="fileType" id="fileType" from="${typer}" value="${fieldValue(bean:basismappeInstance,field:'fileType')}"/>
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
                                    <label for="officialTitle">Offentligtitle:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'officialTitle','errors')}">
                                    <input type="text" id="officialTitle" name="officialTitle" value="${fieldValue(bean:basismappeInstance,field:'officialTitle')}"/>
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
                                    <label for="createdDate">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'createdDate','errors')}">
                                    <g:datePicker name="createdDate" value="${basismappeInstance?.createdDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:basismappeInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
 														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'keyword','errors')}">
                                    <input type="text" id="keyword" name="keyword"/>
                                </td>
                            </tr> 
                      
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentClass">Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'parentClass','errors')}">
                                    <g:select optionKey="id" noSelection="${[null:'Velg klasse']}" from="${Klass.list()}" name="parentClass.id" value="${basismappeInstance?.parentClass?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parentFile">Referanseparent Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'parentFile','errors')}">
                                    <g:select optionKey="id" noSelection="${[null:'Velg forelder mappe']}" from="${BasicFile.list()}" name="parentFile.id" value="${basismappeInstance?.parentFile?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="recordSection">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'recordSection','errors')}">
                                    <g:select optionKey="id" optionValue="title" noSelection="${[null:'Velg parent arkivdel']}" from="${Series.list()}" name="recordSection.id" value="${basismappeInstance?.recordSection?.id}"></g:select>                                </td>
                            </tr> 

