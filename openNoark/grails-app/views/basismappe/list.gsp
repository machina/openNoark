

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Basismappe List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Basismappe</g:link></span>
        </div>
        <div class="body">
            <h1>Basismappe List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="systemid" title="Systemid" />
                        
                   	        <g:sortableColumn property="mappeid" title="Mappeid" />
                        
                   	        <g:sortableColumn property="mappetype" title="Mappetype" />
                        
                   	        <g:sortableColumn property="tittel" title="Tittel" />
                        
                   	        <g:sortableColumn property="offentligtittel" title="Offentligtittel" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${basismappeInstanceList}" status="i" var="basismappeInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${basismappeInstance.id}">${fieldValue(bean:basismappeInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:basismappeInstance, field:'systemid')}</td>
                        
                            <td>${fieldValue(bean:basismappeInstance, field:'mappeid')}</td>
                        
                            <td>${fieldValue(bean:basismappeInstance, field:'mappetype')}</td>
                        
                            <td>${fieldValue(bean:basismappeInstance, field:'tittel')}</td>
                        
                            <td>${fieldValue(bean:basismappeInstance, field:'offentligtittel')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${basismappeInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
