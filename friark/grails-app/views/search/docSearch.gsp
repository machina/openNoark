<%! import no.friark.ds.* %>
<html>
    <head>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1>Igjenfinning</h1>
				<div  class="searchBox">
					<form>
						<g:textArea name="q" rows="5" cols="40"/><input type="submit" value="finn"/>
					</form>
				</div>
				<g:if test="${searchResult}">
					<ul class="searchResults">
						<g:each var="result" in="${searchResult.iterator()}" status="index">
							<li>
								<g:set var="doc" value="${Dokumentobjekt.findBySystemID(result.get('DOC-OBJ'))}"/>
								<g:link controller="documentObject" action="show" id="${doc.id}">${doc}</g:link>
							</li>
						</g:each>
					</ul>			
				</g:if>
    </body>
</html>
