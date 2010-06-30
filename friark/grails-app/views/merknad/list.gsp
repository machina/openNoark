<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Merknad List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Merknad</g:link></span>
        </div>
        <div class="body">
            <h1>Merknad List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="remarkText" title="Merknadstekst" />
                        
                   	        <g:sortableColumn property="remarkDate" title="Merknadsdato" />
                        
                   	        <g:sortableColumn property="remarkRegisteredBy" title="Merknadregistrertav" />
                        
                   	        <th>Mappe</th>
                   	    
                   	        <th>Basis Registrering</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${merknadInstanceList}" status="i" var="merknadInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${merknadInstance.id}">${fieldValue(bean:merknadInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:merknadInstance, field:'remarkText')}</td>
                        
                            <td>${fieldValue(bean:merknadInstance, field:'remarkDate')}</td>
                        
                            <td>${fieldValue(bean:merknadInstance, field:'remarkRegisteredBy')}</td>
                        
                            <td>${fieldValue(bean:merknadInstance, field:'basicFile')}</td>
                        
                            <td>${fieldValue(bean:merknadInstance, field:'basicRecord')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${merknadInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
