                           <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="registreringsid">Registreringsid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'registreringsid','errors')}">
                                    <input type="text" id="registreringsid" name="registreringsid" value="${fieldValue(bean:forenkletRegistreringInstance,field:'registreringsid')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="tittel">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'tittel','errors')}">
                                    <input type="text" id="tittel" name="tittel" value="${fieldValue(bean:forenkletRegistreringInstance,field:'tittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="offentligtittel">Offentligtittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'offentligtittel','errors')}">
                                    <input type="text" id="offentligtittel" name="offentligtittel" value="${fieldValue(bean:forenkletRegistreringInstance,field:'offentligtittel')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="beskrivelse">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'beskrivelse','errors')}">
                                    <input type="text" id="beskrivelse" name="beskrivelse" value="${fieldValue(bean:forenkletRegistreringInstance,field:'beskrivelse')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="nøkkelord">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'nøkkelord','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="forfatter">Forfatter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'forfatter','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="dokumentmedium">Dokumentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'dokumentmedium','errors')}">
                                    <input type="text" id="dokumentmedium" name="dokumentmedium" value="${fieldValue(bean:forenkletRegistreringInstance,field:'dokumentmedium')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="oppbevaringssted">Oppbevaringssted:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'oppbevaringssted','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="merknad">Merknad:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'merknad','errors')}">
                                    
<ul>
<g:each var="m" in="${forenkletRegistreringInstance?.merknad?}">
    <li><g:link controller="merknad" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="merknad" params="['journalpost.id':forenkletRegistreringInstance?.id]" action="create">Add Merknad</g:link>

                                </td>
                            </tr>
