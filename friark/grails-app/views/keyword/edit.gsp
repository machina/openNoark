<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Basismappe</title>
    </head>
    <body>
        <div class="nav">
        </div>
        <div class="body">
            <h1>Edit Keywords</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${base}">
            <div class="errors">
                <g:renderErrors bean="${base}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <div class="dialog">
								<ul>
								<g:each in="${base.keyword}">
									<li>${it} <g:link action="delete" params="[systemID: base.systemID, ord: it]">Delete</g:link></li>
								</g:each>
								</ul>
								<label for="new">Nytt nøkkelord</label><input type="text" id="new" name="new"/>
                </div>
                <div class="buttons">
										<input type="hidden" name="systemID" value="${base.systemID}"/>
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
