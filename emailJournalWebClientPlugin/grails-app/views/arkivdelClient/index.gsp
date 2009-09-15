<html>
    <head>
    <meta name="layout" content="arkiv" />
    </head>
    <body>
        <h1>Arkivdel: ${del?.tittel}</h1>
				<ul>
					<g:each in="${del?.registreringer}" var="reg">
						<li>${reg?.systemid} fil: <g:link action="dl" id="${Dokumentobjekt.findByReferanseregistrering(reg).systemid}">${Dokumentobjekt.findByReferanseregistrering(reg).systemid}</g:link></li>
					</g:each>
				</ul>
    </body>
</html>
