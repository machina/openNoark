<%@ page import="org.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Korrespondansepart List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Korrespondansepart</g:link></span>
        </div>
        <div class="body">
            <h1>Korrespondansepart List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="korrespondanseparttype" title="Korrespondanseparttype" />
                        
                   	        <g:sortableColumn property="korrespondansepartnavn" title="Korrespondansepartnavn" />
                        
                   	        <g:sortableColumn property="postadresse" title="Postadresse" />
                        
                   	        <g:sortableColumn property="postnummer" title="Postnummer" />
                        
                   	        <g:sortableColumn property="poststed" title="Poststed" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${korrespondansepartInstanceList}" status="i" var="korrespondansepartInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${korrespondansepartInstance.id}">${fieldValue(bean:korrespondansepartInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:korrespondansepartInstance, field:'clientType')}</td>
                        
                            <td>${fieldValue(bean:korrespondansepartInstance, field:'clientName')}</td>
                        
                            <td>${fieldValue(bean:korrespondansepartInstance, field:'postalAddress')}</td>
                        
                            <td>${fieldValue(bean:korrespondansepartInstance, field:'postCode')}</td>
                        
                            <td>${fieldValue(bean:korrespondansepartInstance, field:'postalTown')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <%--
            <div class="paginateButtons">
                <g:paginate total="${korrespondansepartInstanceTotal}" />
            </div>
            --%>
        </div>
    </body>
</html>
