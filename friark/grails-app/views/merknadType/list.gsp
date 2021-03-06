<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>MerknadType List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New MerknadType</g:link></span>
        </div>
        <div class="body">
            <h1>MerknadType List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="name" title="Navn" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${merknadTypeInstanceList}" status="i" var="merknadTypeInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${merknadTypeInstance.id}">${fieldValue(bean:merknadTypeInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:merknadTypeInstance, field:'name')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${merknadTypeInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
