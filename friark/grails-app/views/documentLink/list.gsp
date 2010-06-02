<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Dokumentlink List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Dokumentlink</g:link></span>
        </div>
        <div class="body">
            <h1>Dokumentlink List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Referanseregistrering</th>
                   	    
                   	        <g:sortableColumn property="linkedRecordAs" title="Tilknyttetregistrering Som" />
                        
                   	        <g:sortableColumn property="documentNumber" title="Dokumentnummer" />
                        
                   	        <g:sortableColumn property="linkedDate" title="Tilknyttetdato" />
                        
                   	        <g:sortableColumn property="linkedBy" title="Tilknyttetav" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${dokumentlinkInstanceList}" status="i" var="dokumentlinkInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${dokumentlinkInstance.id}">${fieldValue(bean:dokumentlinkInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:dokumentlinkInstance, field:'referenceRecord')}</td>
                        
                            <td>${fieldValue(bean:dokumentlinkInstance, field:'linkedRecordAs')}</td>
                        
                            <td>${fieldValue(bean:dokumentlinkInstance, field:'documentNumber')}</td>
                        
                            <td>${fieldValue(bean:dokumentlinkInstance, field:'linkedDate')}</td>
                        
                            <td>${fieldValue(bean:dokumentlinkInstance, field:'linkedBy')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${dokumentlinkInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
