                           <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="recordID">Registreringsid:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'recordID','errors')}">
                                    <input type="text" id="recordID" name="recordID" value="${fieldValue(bean:forenkletRegistreringInstance,field:'recordID')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="title">Tittel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:forenkletRegistreringInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="officialTitle">Offentligtitle:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'officialTitle','errors')}">
                                    <input type="text" id="officialTitle" name="officialTitle" value="${fieldValue(bean:forenkletRegistreringInstance,field:'officialTitle')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="description">Beskrivelse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:forenkletRegistreringInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="keyword">Nøkkelord:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'keyword','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="author">Forfatter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'author','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="documentMedium">Dokumentmedium:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'documentMedium','errors')}">
                                    <input type="text" id="documentMedium" name="documentMedium" value="${fieldValue(bean:forenkletRegistreringInstance,field:'documentMedium')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop basisRegParam">
                                <td valign="top" class="name">
                                    <label for="storageLocation">Oppbevaringssted:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'storageLocation','errors')}">
                                    
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
