<%! import no.friark.ds.* %>


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
                        
                   	        <g:sortableColumn property="kassasjonsvedtak" title="Kassasjonsvedtak" />
                        
                   	        <g:sortableColumn property="kassasjonshjemmel" title="Kassasjonshjemmel" />
                        
                   	        <g:sortableColumn property="bevaringstid" title="Bevaringstid" />
                        
                   	        <g:sortableColumn property="kassasjonsdato" title="Kassasjonsdato" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${bevaringOgKassasjonInstanceList}" status="i" var="bevaringOgKassasjonInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${bevaringOgKassasjonInstance.id}">${fieldValue(bean:bevaringOgKassasjonInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:bevaringOgKassasjonInstance, field:'kassasjonsvedtak')}</td>
                        
                            <td>${fieldValue(bean:bevaringOgKassasjonInstance, field:'kassasjonshjemmel')}</td>
                        
                            <td>${fieldValue(bean:bevaringOgKassasjonInstance, field:'bevaringstid')}</td>
                        
                            <td>${fieldValue(bean:bevaringOgKassasjonInstance, field:'kassasjonsdato')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${bevaringOgKassasjonInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
