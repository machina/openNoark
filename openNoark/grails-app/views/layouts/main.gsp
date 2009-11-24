<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />				
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
        </div>	
        <div class="logo"><img src="${resource(dir:'images',file:'logo.png')}" alt="Grails" /></div>
				<div class="all">
				<div class="menu">
				<ul>
          <li class="controller"><a href="/openNoark/arkiv/index">Arkiv</a></li>
					<li class="controller"><a href="/openNoark/arkivdel/index">Arkivdeler</a></li>
          <li class="controller"><a href="/openNoark/klassifikasjonssystem/index">Klassifikasjonssystemer</a></li>
 					<li class="controller"><a href="/openNoark/klasse/index">Klasser</a></li>
          <li class="controller"><a href="/openNoark/basismappe/index">Basismapper</a></li>
          <li class="controller"><a href="/openNoark/dokumentobjekt/index">Dokumentobjekter</a></li>
					<li class="controller"><a href="/openNoark/dokumentbeskrivelse/index">Dokumentbeskrivelser</a></li>
          <li class="controller"><a href="/openNoark/user/index">Brukeradministrasjon</a></li>
          <li class="controller"><a href="/openNoark/auditLogEvent/list">Log</a></li>
					<li class="controller"><a href="/openNoark/merknad/list">Merknad</a></li>
					<li class="controller"><a href="/openNoark/merknadType/list">Merknadstyper</a></li>
					<li class="controller"><a href="/openNoark/kryssreferanse/list">Kryssreferanser</a></li>

				</ul>
				</div>
				<div class="content">
	        <g:layoutBody />		
				</div>
				</div>
    </body>	
</html>
