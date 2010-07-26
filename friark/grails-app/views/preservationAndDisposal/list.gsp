<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>BevaringOgKassasjon List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
						<span class="menuButton"><g:link class="list" action="oversikt">Oversikt</g:link></span>
						<span class="menuButton"><g:link class="list" action="kasser">Utfør kasseringer</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New BevaringOgKassasjon</g:link></span>
        </div>
        <div class="body">
            <h1>BevaringOgKassasjon List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="disposalDecision" title="Kassasjonsvedtak" />
                        
                   	        <g:sortableColumn property="disposalAuthority" title="Kassasjonshjemmel" />
                        
                   	        <g:sortableColumn property="preservationTime" title="Bevaringstid" />
                        
                   	        <g:sortableColumn property="disposalDate" title="Kassasjonsdato" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${preservationAndDisposalInstanceList}" status="i" var="preservationAndDisposalInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${preservationAndDisposalInstance.id}">${fieldValue(bean:preservationAndDisposalInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:preservationAndDisposalInstance, field:'disposalDecision')}</td>
                        
                            <td>${fieldValue(bean:preservationAndDisposalInstance, field:'disposalAuthority')}</td>
                        
                            <td>${fieldValue(bean:preservationAndDisposalInstance, field:'preservationTime')}</td>
                        
                            <td>${fieldValue(bean:preservationAndDisposalInstance, field:'disposalDate')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${preservationAndDisposalInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
