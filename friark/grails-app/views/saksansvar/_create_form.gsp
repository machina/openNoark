                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="administrativeUnit">Administrativenhet:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:saksansvarInstance,field:'administrativeUnit','errors')}">
                                    <input type="text" id="administrativeUnit" name="administrativeUnit" value="${fieldValue(bean:saksansvarInstance,field:'administrativeUnit')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="executiveOfficer">Saksbehandler:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:saksansvarInstance,field:'executiveOfficer','errors')}">
                                    <input type="text" id="executiveOfficer" name="executiveOfficer" value="${fieldValue(bean:saksansvarInstance,field:'executiveOfficer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="registryManagementUnit">Journalenhet:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:saksansvarInstance,field:'registryManagementUnit','errors')}">
                                    <input type="text" id="registryManagementUnit" name="registryManagementUnit" value="${fieldValue(bean:saksansvarInstance,field:'registryManagementUnit')}"/>
                                </td>
                            </tr> 

