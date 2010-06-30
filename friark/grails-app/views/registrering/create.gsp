
<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Journalpost</title>         
				<script src="http://code.jquery.com/jquery-latest.js"></script>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Journalpost List</g:link></span>
        </div>
        <div class="body">
            <h1>Ny registrering</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${journalpostInstance}">
            <div class="errors">
                <g:renderErrors bean="${journalpostInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                        		
                        		
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="recordType">Registreringstype:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:journalpostInstance,field:'recordType','errors')}">
                                    <g:select id="recordType" name="recordType" from="${typer}" value="${fieldValue(bean:journalpostInstance,field:'recordType')}"/>
                                </td>
                            </tr> 
                        
                        		<g:render template="forenkletReg_form"/>
                      			<g:render template="basisReg_form" model="${[forenkletRegistreringInstance: new RegistryEntry()]}"/>
														<g:render template="journal_form" model="${[forenkletRegistreringInstance: new RegistryEntry()]}"/>
														<script>
	                            if($('#recordType').val() != 'Journalpost'){
  	                            $('.basisRegParam').hide();
																$('.journalParam').hide();
    	                        }
                            $('#recordType').change(function() {
                              if($(this).val() === 'Journalpost'){
                                $('.basisRegParam').show();
                                $('.journalParam').show();
                              } else {
                                $('.basisRegParam').hide();
                                $('.journalParam').hide();
                              }
                            });
                          </script>
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
