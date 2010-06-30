                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="serialNumber">Løpenummer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'serialNumber','errors')}">
                                    <input type="text" id="serialNumber" name="serialNumber" value="${fieldValue(bean:forenkletRegistreringInstance,field:'serialNumber')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="registryEntryType">Journalposttype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'registryEntryType','errors')}">
                                    <input type="text" id="registryEntryType" name="registryEntryType" value="${fieldValue(bean:forenkletRegistreringInstance,field:'registryEntryType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="recordStatus">Journalstatus:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'recordStatus','errors')}">
                                    <input type="text" id="recordStatus" name="recordStatus" value="${fieldValue(bean:forenkletRegistreringInstance,field:'recordStatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="registryDate">Journaldato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'registryDate','errors')}">
                                    <g:datePicker name="registryDate" value="${forenkletRegistreringInstance?.registryDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="documentDate">Dokumentetsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'documentDate','errors')}">
                                    <g:datePicker name="documentDate" value="${forenkletRegistreringInstance?.documentDate}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="recivedDate">Mottattdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'recivedDate','errors')}">
                                    <g:datePicker name="recivedDate" value="${forenkletRegistreringInstance?.recivedDate}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="sentDate">Sendtdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'sentDate','errors')}">
                                    <g:datePicker name="sentDate" value="${forenkletRegistreringInstance?.sentDate}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="dueDate">Forfallsdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'dueDate','errors')}">
                                    <g:datePicker name="dueDate" value="${forenkletRegistreringInstance?.dueDate}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="confidentialityAssessedDate">Offentlighetsvurdertdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'confidentialityAssessedDate','errors')}">
                                    <g:datePicker name="confidentialityAssessedDate" value="${forenkletRegistreringInstance?.confidentialityAssessedDate}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="numberOfAppendicies">Antallvedlegg:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'numberOfAppendicies','errors')}">
                                    <input type="text" id="numberOfAppendicies" name="numberOfAppendicies" value="${fieldValue(bean:forenkletRegistreringInstance,field:'numberOfAppendicies')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="loanedDate">Utlåntdato:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'loanedDate','errors')}">
                                    <g:datePicker name="loanedDate" value="${forenkletRegistreringInstance?.loanedDate}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop journalParam">
                                <td valign="top" class="name">
                                    <label for="loanedTo">Utlånttil:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:forenkletRegistreringInstance,field:'loanedTo','errors')}">
                                    <input type="text" id="loanedTo" name="loanedTo" value="${fieldValue(bean:forenkletRegistreringInstance,field:'loanedTo')}"/>
                                </td>
                            </tr> 
														<g:render template="/client/form"/>
														<g:render template="/saksansvar/create_form"/>
