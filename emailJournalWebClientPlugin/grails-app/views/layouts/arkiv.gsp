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
					<g:each in="${arkiv}">
						<li class="controller">${it.tittel}
							<ul>
								<g:each in="${it.referansebarnArkivdel}" var="del">
									<li><g:link id="${del.id}">${del.tittel}</g:link></li>
								</g:each>
							</ul>
						</li>
					</g:each>
        </ul>
        </div>
        <div class="content">
          <g:layoutBody />
        </div>
        </div>
    </body>
</html>
