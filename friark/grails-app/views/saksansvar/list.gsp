<%@ page import="org.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Saksansvar List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Saksansvar</g:link></span>
        </div>
        <div class="body">
            <h1>Saksansvar List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="administrativenhet" title="Administrativenhet" />
                        
                   	        <g:sortableColumn property="saksbehandler" title="Saksbehandler" />
                        
                   	        <g:sortableColumn property="journalenhet" title="Journalenhet" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${saksansvarInstanceList}" status="i" var="saksansvarInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${saksansvarInstance.id}">${fieldValue(bean:saksansvarInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:saksansvarInstance, field:'administrativeUnit')}</td>
                        
                            <td>${fieldValue(bean:saksansvarInstance, field:'executiveOfficer')}</td>
                        
                            <td>${fieldValue(bean:saksansvarInstance, field:'registryManagementUnit')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${saksansvarInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
