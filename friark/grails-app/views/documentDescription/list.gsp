<%! import org.friark.ds.* %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Documentdescription List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Documentdescription</g:link></span>
        </div>
        <div class="body">
            <h1>Documentdescription List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="systemID" title="SystemID" />
                        
                   	        <g:sortableColumn property="documentType" title="Documenttype" />
                        
                   	        <g:sortableColumn property="documentStatus" title="Documentstatus" />
                        
                   	        <g:sortableColumn property="title" title="Tittel" />
                        
                   	        <g:sortableColumn property="description" title="Beskrivelse" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${documentDescriptionInstanceList}" status="i" var="documentDescriptionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${documentDescriptionInstance.id}">${fieldValue(bean:documentDescriptionInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:documentDescriptionInstance, field:'systemID')}</td>
                        
                            <td>${fieldValue(bean:documentDescriptionInstance, field:'documentType')}</td>
                        
                            <td>${fieldValue(bean:documentDescriptionInstance, field:'documentStatus')}</td>
                        
                            <td>${fieldValue(bean:documentDescriptionInstance, field:'title')}</td>
                        
                            <td>${fieldValue(bean:documentDescriptionInstance, field:'description')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${documentDescriptionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
