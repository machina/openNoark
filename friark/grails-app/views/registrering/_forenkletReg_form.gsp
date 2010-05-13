                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansearkivdel">Referansearkivdel:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referansearkivdel','errors')}">
                                    <g:select optionKey="id" from="${no.friark.ds.Arkivdel.list()}" name="referansearkivdel.id" value="${forenkletRegistreringInstance?.referansearkivdel?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderBasismappe">Referanseforelder Basismappe:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referanseforelderBasismappe','errors')}">
                                    <g:select optionKey="id" from="${no.friark.ds.Basismappe.list()}" name="referanseforelderBasismappe.id" value="${forenkletRegistreringInstance?.referanseforelderBasismappe?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetdato">Opprettetdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'opprettetdato','errors')}">
                                    <g:datePicker name="opprettetdato" value="${forenkletRegistreringInstance?.opprettetdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opprettetav">Opprettetav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'opprettetav','errors')}">
                                    <input type="text" id="opprettetav" name="opprettetav" value="${fieldValue(bean:forenkletRegistreringInstance,field:'opprettetav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivertdato">Arkivertdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'arkivertdato','errors')}">
                                    <g:datePicker name="arkivertdato" value="${forenkletRegistreringInstance?.arkivertdato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="arkivertav">Arkivertav:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'arkivertav','errors')}">
                                    <input type="text" id="arkivertav" name="arkivertav" value="${fieldValue(bean:forenkletRegistreringInstance,field:'arkivertav')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referanseforelderKlasse">Referanseforelder Klasse:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referanseforelderKlasse','errors')}">
                                    <g:select optionKey="id" from="${no.friark.ds.Klasse.list()}" name="referanseforelderKlasse.id" value="${forenkletRegistreringInstance?.referanseforelderKlasse?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dokumenter">Dokumenter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'dokumenter','errors')}">
                                    
<ul>
<g:each var="d" in="${forenkletRegistreringInstance?.dokumenter?}">
    <li><g:link controller="dokumentlink" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="dokumentlink" params="['journalpost.id':forenkletRegistreringInstance?.id]" action="create">Add Dokumentlink</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="referansedokumentObjekt">Referansedokument Objekt:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'referansedokumentObjekt','errors')}">
                                    
<ul>
<g:each var="r" in="${forenkletRegistreringInstance?.referansedokumentObjekt?}">
    <li><g:link controller="dokumentobjekt" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="dokumentobjekt" params="['journalpost.id':forenkletRegistreringInstance?.id]" action="create">Add Dokumentobjekt</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="bevaringOgKassasjon">Bevaring Og Kassasjon:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'bevaringOgKassasjon','errors')}">
                                    <g:select optionKey="id" from="${no.friark.ds.BevaringOgKassasjon.list()}" name="bevaringOgKassasjon.id" value="${forenkletRegistreringInstance?.bevaringOgKassasjon?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 

