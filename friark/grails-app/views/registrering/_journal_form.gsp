                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="løpenummer">Løpenummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'løpenummer','errors')}">
                                    <input type="text" id="løpenummer" name="løpenummer" value="${fieldValue(bean:forenkletRegistreringInstance,field:'løpenummer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="journalposttype">Journalposttype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'journalposttype','errors')}">
                                    <input type="text" id="journalposttype" name="journalposttype" value="${fieldValue(bean:forenkletRegistreringInstance,field:'journalposttype')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="journalstatus">Journalstatus:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'journalstatus','errors')}">
                                    <input type="text" id="journalstatus" name="journalstatus" value="${fieldValue(bean:forenkletRegistreringInstance,field:'journalstatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="journaldato">Journaldato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'journaldato','errors')}">
                                    <g:datePicker name="journaldato" value="${forenkletRegistreringInstance?.journaldato}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="dokumentetsdato">Dokumentetsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'dokumentetsdato','errors')}">
                                    <g:datePicker name="dokumentetsdato" value="${forenkletRegistreringInstance?.dokumentetsdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="mottattdato">Mottattdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'mottattdato','errors')}">
                                    <g:datePicker name="mottattdato" value="${forenkletRegistreringInstance?.mottattdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="sendtdato">Sendtdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'sendtdato','errors')}">
                                    <g:datePicker name="sendtdato" value="${forenkletRegistreringInstance?.sendtdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="forfallsdato">Forfallsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'forfallsdato','errors')}">
                                    <g:datePicker name="forfallsdato" value="${forenkletRegistreringInstance?.forfallsdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="offentlighetsvurdertdato">Offentlighetsvurdertdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'offentlighetsvurdertdato','errors')}">
                                    <g:datePicker name="offentlighetsvurdertdato" value="${forenkletRegistreringInstance?.offentlighetsvurdertdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="antallvedlegg">Antallvedlegg:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'antallvedlegg','errors')}">
                                    <input type="text" id="antallvedlegg" name="antallvedlegg" value="${fieldValue(bean:forenkletRegistreringInstance,field:'antallvedlegg')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="utlåntdato">Utlåntdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'utlåntdato','errors')}">
                                    <g:datePicker name="utlåntdato" value="${forenkletRegistreringInstance?.utlåntdato}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="utlånttil">Utlånttil:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'utlånttil','errors')}">
                                    <input type="text" id="utlånttil" name="utlånttil" value="${fieldValue(bean:forenkletRegistreringInstance,field:'utlånttil')}"/>
                                </td>
                            </tr> 
														<g:render template="/korrespondansepart/form"/>
														<g:render template="/saksansvar/create_form"/>
