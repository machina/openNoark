<%! import no.friark.ds.* %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Basismappe</title>
				<script src="http://code.jquery.com/jquery-latest.js"></script>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Mappeliste</g:link></span>
        </div>
        <div class="body">
            <h1>Ny mappe</h1>
            <g:if test="${flash.message}">
	            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${basismappeInstance}">
            <div class="errors">
                <g:renderErrors bean="${basismappeInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
			                    <g:render template="basisCreateFields" model="[basismappeInstance: basismappeInstance, typer: typer]" />
													<g:render template="sakCreateFields" model="[mappeInstance: basismappeInstance, typer: typer]" />
													<script>
														if($('#fileType').val() != 'Saksmappe'){
															$('.saksmappeParam').hide();
														}
														$('#fileType').change(function() {
															if($(this).val() === 'Saksmappe'){
																$('.saksmappeParam').show();
															} else {
																$('.saksmappeParam').hide();
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
