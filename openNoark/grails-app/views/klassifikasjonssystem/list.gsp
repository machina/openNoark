

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Klassifikasjonssystem List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Klassifikasjonssystem</g:link></span>
        </div>
        <div class="body">
            <h1>Klassifikasjonssystem List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="systemID" title="SystemID" />
                        
                   	        <g:sortableColumn property="klassifikasjonstype" title="Klassifikasjonstype" />
                        
                   	        <g:sortableColumn property="tittel" title="Tittel" />
                        
                   	        <g:sortableColumn property="opprettetdato" title="Opprettetdato" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${klassifikasjonssystemInstanceList}" status="i" var="klassifikasjonssystemInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                        
                            <td><g:link action="show" id="${klassifikasjonssystemInstance.id}">${fieldValue(bean:klassifikasjonssystemInstance, field:'systemID')}</g:link></td>
                        
                            <td>${fieldValue(bean:klassifikasjonssystemInstance, field:'klassifikasjonstype')}</td>
                        
                            <td><g:link action="show" id="${klassifikasjonssystemInstance.id}">${fieldValue(bean:klassifikasjonssystemInstance, field:'tittel')}</g:link></td>
                        
                            <td>${fieldValue(bean:klassifikasjonssystemInstance, field:'opprettetdato')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${klassifikasjonssystemInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
