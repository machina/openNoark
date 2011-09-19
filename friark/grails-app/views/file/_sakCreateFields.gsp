<%! import org.friark.ds.* %>
														<tr class="saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="caseDate">Saksdato:</label>
                                </td>
																<td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'caseDate','errors')}">
																	<g:datePicker name="caseDate" value="${mappeInstance instanceof CaseFile ? mappeInstance?.caseDate : new Date()}" precision="day" ></g:datePicker>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="administrativEnhet">Administrativ enhet:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'administrativeUnit','errors')}">
                                    <input type="text" id="administrativeUnit" name="administrativeUnit" value="${mappeInstance instanceof CaseFile ? mappeInstance.administrativeUnit:''}"/>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="caseResponsible">Saksansvarlig:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'caseResponsible','errors')}">
                                    <input type="text" id="caseResponsible" name="caseResponsible" value="${mappeInstance instanceof CaseFile ? mappeInstance.caseResponsible:''}"/>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="registryManagementUnit">Journalenhet:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'registryManagementUnit','errors')}">
                                    <input type="text" id="registryManagementUnit" name="registryManagementUnit" value="${mappeInstance instanceof CaseFile ? mappeInstance.registryManagementUnit:''}"/>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="caseStatus">Saksstatus:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'caseStatus','errors')}">
                                    <input type="text" id="caseStatus" name="caseStatus" value="${mappeInstance instanceof CaseFile ? mappeInstance.caseStatus:''}"/>
                                </td>
														</tr>
<%--												<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="loanedDate">Utlånt:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'loanedDate','errors')}">
																	<g:datePicker name="loanedDate" value="${mappeInstance instanceof CaseFile ? mappeInstance?.loanedDate : new Date()}" precision="day" ></g:datePicker>
                                </td>
														</tr>
														<tr class="prop saksmappeParam">
                                <td valign="top" class="name">
                                    <label for="loanedTo">Utånt tilSaksstatus:</label>
                                </td>
												        <td valign="top" class="value ${hasErrors(bean:mappeInstance,field:'loanedTo','errors')}">
                                    <input type="text" id="loanedTo" name="loanedTo" value="${mappeInstance instanceof CaseFile ? mappeInstance.loanedTo:''}"/>
                                </td> 
														</tr> --%>
