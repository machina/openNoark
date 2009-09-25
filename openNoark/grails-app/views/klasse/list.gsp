

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Klasse List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Klasse</g:link></span>
        </div>
        <div class="body">
            <h1>Klasse List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="systemID" title="SystemID" />
                        
                   	        <g:sortableColumn property="klasseid" title="Klasseid" />
                        
                   	        <g:sortableColumn property="tittel" title="Tittel" />
                        
                   	        <g:sortableColumn property="beskrivelse" title="Beskrivelse" />
                        
                   	        <g:sortableColumn property="opprettetdato" title="Opprettetdato" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${klasseInstanceList}" status="i" var="klasseInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${klasseInstance.id}">${fieldValue(bean:klasseInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:klasseInstance, field:'systemID')}</td>
                        
                            <td>${fieldValue(bean:klasseInstance, field:'klasseid')}</td>
                        
                            <td>${fieldValue(bean:klasseInstance, field:'tittel')}</td>
                        
                            <td>${fieldValue(bean:klasseInstance, field:'beskrivelse')}</td>
                        
                            <td>${fieldValue(bean:klasseInstance, field:'opprettetdato')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${klasseInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
