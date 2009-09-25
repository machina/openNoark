

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>ForenkletRegistrering List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New ForenkletRegistrering</g:link></span>
        </div>
        <div class="body">
            <h1>ForenkletRegistrering List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="systemID" title="SystemID" />
                        
                   	        <g:sortableColumn property="registreringstype" title="Registreringstype" />
                        
                   	        <g:sortableColumn property="opprettetdato" title="Opprettetdato" />
                        
                   	        <g:sortableColumn property="opprettetav" title="Opprettetav" />
                        
                   	        <g:sortableColumn property="arkivertdato" title="Arkivertdato" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${forenkletRegistreringInstanceList}" status="i" var="forenkletRegistreringInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${forenkletRegistreringInstance.id}">${fieldValue(bean:forenkletRegistreringInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:forenkletRegistreringInstance, field:'systemID')}</td>
                        
                            <td>${fieldValue(bean:forenkletRegistreringInstance, field:'registreringstype')}</td>
                        
                            <td>${fieldValue(bean:forenkletRegistreringInstance, field:'opprettetdato')}</td>
                        
                            <td>${fieldValue(bean:forenkletRegistreringInstance, field:'opprettetav')}</td>
                        
                            <td>${fieldValue(bean:forenkletRegistreringInstance, field:'arkivertdato')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${forenkletRegistreringInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
