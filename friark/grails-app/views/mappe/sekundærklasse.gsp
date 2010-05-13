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
            <g:hasErrors bean="${mappe}">
            <div class="errors">
                <g:renderErrors bean="${mappe}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <div class="dialog">
                <ul>
                <g:each in="${mappe.sekundærklasseringer}">
                  <li>${it.tittel} <g:link action="delete" params="[id mappe.id, klasse: it, action:delete]">Delete</g:link></li>
                </g:each>
                </ul>
                <label for="new">Ny sekundærklasse</label><input type="text" id="new" name="new"/>
                </div>
                <div class="buttons">
                    <input type="hidden" name="id" value="${mappe.id}"/>
										<input type="hidden" name="id" value="${mappe.id}"/>
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>

