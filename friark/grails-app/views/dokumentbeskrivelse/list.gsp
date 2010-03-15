<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Dokumentbeskrivelse List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Dokumentbeskrivelse</g:link></span>
        </div>
        <div class="body">
            <h1>Dokumentbeskrivelse List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="systemID" title="SystemID" />
                        
                   	        <g:sortableColumn property="dokumenttype" title="Dokumenttype" />
                        
                   	        <g:sortableColumn property="dokumentstatus" title="Dokumentstatus" />
                        
                   	        <g:sortableColumn property="tittel" title="Tittel" />
                        
                   	        <g:sortableColumn property="beskrivelse" title="Beskrivelse" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${dokumentbeskrivelseInstanceList}" status="i" var="dokumentbeskrivelseInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${dokumentbeskrivelseInstance.id}">${fieldValue(bean:dokumentbeskrivelseInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'systemID')}</td>
                        
                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'dokumenttype')}</td>
                        
                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'dokumentstatus')}</td>
                        
                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'tittel')}</td>
                        
                            <td>${fieldValue(bean:dokumentbeskrivelseInstance, field:'beskrivelse')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${dokumentbeskrivelseInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
