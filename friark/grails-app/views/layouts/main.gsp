<%! import org.friark.ds.* %>
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
                  <a href="/friark">&nbsp;</a>
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
                  <a href="/friark/auth/signOut">Logg ut</a>
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
 										<a href="/friark/search">Search metadata</a>                 
									</li>
                  <li class="leftmenuitem">
                  	<a href="/friark/search/docSearch">Search documents</a>
									</li>
  	              <li class="leftmenuitem">
            				<a href="/friark/arkiv/index">Fonds</a>
									</li>
  	              <li class="leftmenuitem">
                  	<a href="/friark/series/index">Series</a>
		 							</li>
									<li class="leftmenuitem">
            				<a href="/friark/arkivskaper">Fonds creators</a>
									</li>
        	        <li class="leftmenuitem">
                  	<a href="/friark/classificationSystem/index">Classification systems</a>
									</li>
              	  <li class="leftmenuitem">
                  	<a href="/friark/klass/index">Classes</a>
									</li>
    	            <li class="leftmenuitem">
                  	<a href="/friark/mappe/index">Files</a>
									</li>
									<li class="leftmenuitem">
                    <a href="/friark/client/index">Clients</a>
                  </li>
									<li class="leftmenuitem">
                    <a href="/friark/saksansvar/index">Case responsibilities</a>
                  </li>
    	            <li class="leftmenuitem">
                  	<a href="/friark/skjerming/index">Screenings</a>
									</li>
        	        <li class="leftmenuitem">
                 		<a href="/friark/documentLink/index">Document links</a>
									</li>
              	  <li class="leftmenuitem">
                  	<a href="/friark/documentObject/index">Document objects</a>
									</li>
    	            <li class="leftmenuitem">
                  	<a href="/friark/documentDescription/index">Document descriptions</a>
									</li>
          	      <li class="leftmenuitem">
                  	<a href="/friark/user/index">User administration</a>
									</li>
	                <li class="leftmenuitem">
                  	<a href="/friark/merknad/list">Remarks</a>
									</li>
	                <li class="leftmenuitem">
                  	<a href="/friark/merknadType/list">Remark types</a>
									</li>
      	          <li class="leftmenuitem">
                  	<a href="/friark/crossReference/list">Cross references</a>
									</li>
	                <li class="leftmenuitem">
                  	<a href="/friark/preservationAndDisposal">Preservations and disposals</a>
									</li>
      	          <li class="leftmenuitem">
                  	<a href="/friark/auditLogEvent/list">Log</a>
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
