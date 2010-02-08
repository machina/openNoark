<%! import no.friark.ds.* %>
<html>
    <head>
        <title>Velkommen til friark</title>
		<meta name="layout" content="main" />
    </head>
    <body>
				<div class="rightColWideTop"><h1>Velkommen til friark</h1></div>
				<div class="rightColWideContent">
					<h3>Det frie noark alternativet</h3>
					<p>Nedenfor er en oversikt over alle funksjoner som p.t. tilbys av friark. Disse funksjonene skal også være tilgjengelige fra menyen på venstre side.</p>
          <ul>
          	<g:each var="c" in="${grailsApplication.controllerClasses}">
            	<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
            </g:each>
          </ul>
        </div><!-- End rightColWideContent -->
				<div class="rightColWideBtm"></div>
				<div class="rightColWideBtm"></div>
    </body>
</html>
