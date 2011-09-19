
<%@ page import="org.friark.ds.Parameter" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Parameter List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Parameter</g:link></span>
        </div>
        <div class="body">
            <h1>Parameter List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="key" title="Key" />
                        
                   	        <g:sortableColumn property="value" title="Value" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${parameterInstanceList}" status="i" var="parameterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${parameterInstance.id}">${fieldValue(bean:parameterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:parameterInstance, field:'key')}</td>
                        
                            <td>${fieldValue(bean:parameterInstance, field:'value')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <%--
            <div class="paginateButtons">
                <g:paginate total="${parameterInstanceTotal}" />
            </div>
            --%>
        </div>
    </body>
</html>
