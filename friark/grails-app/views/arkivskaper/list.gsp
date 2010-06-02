
<%@ page import="no.friark.ds.FondsCreator" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>FondsCreator List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New FondsCreator</g:link></span>
        </div>
        <div class="body">
            <h1>FondsCreator List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="fondsCreatorid" title="FondsCreatorid" />
                        
                   	        <g:sortableColumn property="fondsCreatornavn" title="FondsCreatornavn" />
                        
                   	        <g:sortableColumn property="description" title="Beskrivelse" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fondsCreatorInstanceList}" status="i" var="fondsCreatorInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${fondsCreatorInstance.id}">${fieldValue(bean:fondsCreatorInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:fondsCreatorInstance, field:'fondsCreatorid')}</td>
                        
                            <td>${fieldValue(bean:fondsCreatorInstance, field:'fondsCreatornavn')}</td>
                        
                            <td>${fieldValue(bean:fondsCreatorInstance, field:'description')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${fondsCreatorInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
