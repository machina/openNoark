<%! import no.friark.ds.* %>
														<tr class="saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="saksdato">Saksdato:</label>
                                </td>
																<td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'saksdato','errors')}">
																	<g:datePicker name="saksdato" value="${mappeInstance instanceof Saksmappe ? mappeInstance?.saksdato : new Date()}" precision="day" ></g:datePicker>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="administrativEnhet">Administrativ enhet:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'administrativenhet','errors')}">
                                    <input type="text" id="administrativenhet" name="administrativenhet" value="${mappeInstance instanceof Saksmappe ? mappeInstance.administrativenhet:''}"/>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="saksansvarlig">Saksansvarlig:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'saksansvarlig','errors')}">
                                    <input type="text" id="saksansvarlig" name="saksansvarlig" value="${mappeInstance instanceof Saksmappe ? mappeInstance.saksansvarlig:''}"/>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="journalenhet">Journalenhet:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'journalenhet','errors')}">
                                    <input type="text" id="journalenhet" name="journalenhet" value="${mappeInstance instanceof Saksmappe ? mappeInstance.journalenhet:''}"/>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="saksstatus">Saksstatus:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'saksstatus','errors')}">
                                    <input type="text" id="saksstatus" name="saksstatus" value="${mappeInstance instanceof Saksmappe ? mappeInstance.saksstatus:''}"/>
                                </td>
														</tr>
<%--												<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="utlåntdato">Utlånt:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'utlåntdato','errors')}">
																	<g:datePicker name="utlåntdato" value="${mappeInstance instanceof Saksmappe ? mappeInstance?.utlåntdato : new Date()}" precision="day" ></g:datePicker>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="utlånttil">Utånt tilSaksstatus:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'utlånttil','errors')}">
                                    <input type="text" id="utlånttil" name="utlånttil" value="${mappeInstance instanceof Saksmappe ? mappeInstance.utlånttil:''}"/>
                                </td> 
														</tr> --%>
