<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Kryssreferanse List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Kryssreferanse</g:link></span>
        </div>
        <div class="body">
            <h1>Kryssreferanse List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Til Klass</th>
                   	    
                   	        <th>Fra Klass</th>
                   	    
                   	        <th>Fra Mappe</th>
                   	    
                   	        <th>Til Mappe</th>
                   	    
                   	        <th>Fra Registrering</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${kryssreferanseInstanceList}" status="i" var="kryssreferanseInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${kryssreferanseInstance.id}">${fieldValue(bean:kryssreferanseInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:kryssreferanseInstance, field:'toClass')}</td>
                        
                            <td>${fieldValue(bean:kryssreferanseInstance, field:'fromClass')}</td>
                        
                            <td>${fieldValue(bean:kryssreferanseInstance, field:'fromFile')}</td>
                        
                            <td>${fieldValue(bean:kryssreferanseInstance, field:'toFile')}</td>
                        
                            <td>${fieldValue(bean:kryssreferanseInstance, field:'fromRecord')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${kryssreferanseInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
