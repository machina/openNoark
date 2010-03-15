<%! import no.friark.ds.* %>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mappetype">Mappetype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'mappetype','errors')}">
																				<g:select name="mappetype" id="mappetype" from="${typer}" value="${fieldValue(bean:basismappeInstance,field:'mappetype')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tittel">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'tittel','errors')}">
                                    <input type="text" id="tittel" name="tittel" value="${fieldValue(bean:basismappeInstance,field:'tittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="offentligtittel">Offentligtittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'offentligtittel','errors')}">
                                    <input type="text" id="offentligtittel" name="offentligtittel" value="${fieldValue(bean:basismappeInstance,field:'offentligtittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="beskrivelse">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'beskrivelse','errors')}">
                                    <input type="text" id="beskrivelse" name="beskrivelse" value="${fieldValue(bean:basismappeInstance,field:'beskrivelse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumentmedium">Dokumentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'dokumentmedium','errors')}">
                                    <input type="text" id="dokumentmedium" name="dokumentmedium" value="${fieldValue(bean:basismappeInstance,field:'dokumentmedium')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${basismappeInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:basismappeInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
 														<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:ibasismappeInstance,field:'nøkkelord','errors')}">
                                    <input type="text" id="nøkkelord" name="nøkkelord"/>
                                </td>
                            </tr> 
                      
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlasse">Referanseforelder Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseforelderKlasse','errors')}">
                                    <g:select optionKey="id" noSelection="${[null:'Velg klasse']}" from="${Klasse.list()}" name="referanseforelderKlasse.id" value="${basismappeInstance?.referanseforelderKlasse?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderBasismappe">Referanseforelder Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referanseforelderBasismappe','errors')}">
                                    <g:select optionKey="id" noSelection="${[null:'Velg foreldermappe']}" from="${Basismappe.list()}" name="referanseforelderBasismappe.id" value="${basismappeInstance?.referanseforelderBasismappe?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansearkivdel">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:basismappeInstance,field:'referansearkivdel','errors')}">
                                    <g:select optionKey="id" optionValue="tittel" noSelection="${[null:'Velg forelder arkivdel']}" from="${Arkivdel.list()}" name="referansearkivdel.id" value="${basismappeInstance?.referansearkivdel?.id}"></g:select>
                                </td>
                            </tr> 

