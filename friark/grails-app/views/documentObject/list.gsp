<%! import no.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Dokumentobjekt List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Dokumentobjekt</g:link></span>
        </div>
        <div class="body">
            <h1>Dokumentobjekt List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="systemID" title="SystemID" />
                        
                   	        <g:sortableColumn property="versionNumber" title="Versjonsnummer" />
                        
                   	        <g:sortableColumn property="variantFormat" title="Variantformat" />
                        
                   	        <g:sortableColumn property="format" title="Format" />
                        
                   	        <g:sortableColumn property="formatDetails" title="Formatdetaljer" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${dokumentobjektInstanceList}" status="i" var="dokumentobjektInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${dokumentobjektInstance.id}">${fieldValue(bean:dokumentobjektInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:dokumentobjektInstance, field:'systemID')}</td>
                        
                            <td>${fieldValue(bean:dokumentobjektInstance, field:'versionNumber')}</td>
                        
                            <td>${fieldValue(bean:dokumentobjektInstance, field:'variantFormat')}</td>
                        
                            <td>${fieldValue(bean:dokumentobjektInstance, field:'format')}</td>
                        
                            <td>${fieldValue(bean:dokumentobjektInstance, field:'formatDetails')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${dokumentobjektInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
