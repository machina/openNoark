<%! import no.friark.ds.* %>
<html>
    <head>
        <title><g:layoutTitle default="friark" /></title>
				<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'friark.css')}" />
				<link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />				
    </head>
    <body>
			<div class="center">
				<div class="maincontain">
        <div class="top">
          <div class="topbar">
          </div><!--End topbar -->
          <div class="menubarcontain">
            <div class="navcontainer">
              <ul class="navlist">
                <li class="first">
                  <a href="/openNoark">&nbsp;</a>
                </li>
                <li class="menudivide"></li>
                <li class="menuitem">
                  <a href="#">&#160;</a>
                </li>
                <li class="menudivide"></li>
                <li class="menuitem">
                  <a href="#">&#160;</a>
                </li>
                <li class="menudivide"></li>
                <li class="menuitem">
                  <a href="#">&#160;</a>
                </li>
                <li class="menudivide"></li>
                <li class="menuitem">
                  <a href="#">&#160;</a>
                </li>
                <li class="menudivide"></li>
                <li class="last">
                  <a href="/openNoark/auth/signOut">Logg ut</a>
                </li>
              </ul>
            </div><!-- End navcontainer -->
          </div><!-- End menubarcontain -->
				</div><!--End top -->
				<div class="columncontainer">
          <div class="leftcol">
            <div class="leftmenucontainer">
							<shiro:isLoggedIn>
              <div class="leftmenuheader">Operasjoner</div>
              <div class="leftmenumid">
                <ul class="leftmenuUl">
                  <li class="leftmenuitem">
 										<a href="/openNoark/search">Søk i metadata</a>                 
									</li>
                  <li class="leftmenuitem">
                  	<a href="/openNoark/search/docSearch">Søk i dokumenter</a>
									</li>
  	              <li class="leftmenuitem">
            				<a href="/openNoark/arkiv/index">Arkiv</a>
									</li>
  	              <li class="leftmenuitem">
                  	<a href="/openNoark/arkivdel/index">Arkivdeler</a>
		 							</li>
									<li class="leftmenuitem">
            				<a href="/openNoark/arkivskaper">Arkivskaper</a>
									</li>
        	        <li class="leftmenuitem">
                  	<a href="/openNoark/klassifikasjonssystem/index">Klassifikasjonssystemer</a>
									</li>
              	  <li class="leftmenuitem">
                  	<a href="/openNoark/klasse/index">Klasser</a>
									</li>
    	            <li class="leftmenuitem">
                  	<a href="/openNoark/mappe/index">Mapper</a>
									</li>
        	        <li class="leftmenuitem">
                 		<a href="/openNoark/dokumentlink/index">Dokumentlinker</a>
									</li>
              	  <li class="leftmenuitem">
                  	<a href="/openNoark/dokumentobjekt/index">Dokumentobjekter</a>
									</li>
    	            <li class="leftmenuitem">
                  	<a href="/openNoark/dokumentbeskrivelse/index">Dokumentbeskrivelser</a>
									</li>
          	      <li class="leftmenuitem">
                  	<a href="/openNoark/user/index">Brukeradministrasjon</a>
									</li>
	                <li class="leftmenuitem">
                  	<a href="/openNoark/merknad/list">Merknad</a>
									</li>
      	          <li class="leftmenuitem">
                  	<a href="/openNoark/kryssreferanse/list">Kryssreferanser</a>
									</li>
	                <li class="leftmenuitem">
                  	<a href="/openNoark/bevaringOgKassasjon">Bevaring og kassasjon</a>
									</li>
      	          <li class="leftmenuitem">
                  	<a href="/openNoark/auditLogEvent/list">Log</a>
									</li>
                </ul>
							
              </div> <!-- End leftmenumid -->
              <div class="leftmenubtm"></div>
							</shiro:isLoggedIn>
							 
            </div> <!-- End leftmenucontainer --> 
          </div><!-- End leftcol --> 
					<div class="rightColWide">
            <div class="rightColWideContainer">
							<g:layoutBody />
						</div> <!-- End rightColWideContainer -->
					</div> <!-- End  rightColWide -->
					<div class="clear"></div>
					<div class="bottomline">© 2023 Machina ASA</div> 
				</div> <!-- End columncontainer -->
			</div><!--End maincontain -->
		</div><!--End center -->
  </body>	
</html>
