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
				<g:if test="${searchResult?.results}">
					<ul class="searchResults">
						<g:each var="result" in="${searchResult.results}" status="index">
							<li>
								<g:link action="show" id="${result.id}" controller="${friark.controllerFor(obj:result)}">${result}</g:link>
							</li>
						</g:each>
					</ul>			
				</g:if>
    </body>
</html>
