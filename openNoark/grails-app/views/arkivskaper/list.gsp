
<%@ page import="no.friark.ds.Arkivskaper" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Arkivskaper List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Arkivskaper</g:link></span>
        </div>
        <div class="body">
            <h1>Arkivskaper List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="arkivskaperid" title="Arkivskaperid" />
                        
                   	        <g:sortableColumn property="arkivskapernavn" title="Arkivskapernavn" />
                        
                   	        <g:sortableColumn property="beskrivelse" title="Beskrivelse" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${arkivskaperInstanceList}" status="i" var="arkivskaperInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${arkivskaperInstance.id}">${fieldValue(bean:arkivskaperInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:arkivskaperInstance, field:'arkivskaperid')}</td>
                        
                            <td>${fieldValue(bean:arkivskaperInstance, field:'arkivskapernavn')}</td>
                        
                            <td>${fieldValue(bean:arkivskaperInstance, field:'beskrivelse')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${arkivskaperInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
