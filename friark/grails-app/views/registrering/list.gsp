<%@ page import="no.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Journalpost List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">Ny registrering</g:link></span>
        </div>
        <div class="body">
            <h1>Journalpost List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="systemID" title="System ID" />
                        
                   	        <th>Referansearkivdel</th>
                   	    
                   	        <th>Referanseparent Basismappe</th>
                   	    
                   	        <g:sortableColumn property="registreringstype" title="Registreringstype" />
                        
                   	        <g:sortableColumn property="createdDate" title="Opprettetdato" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${forenkletRegistreringInstanceList}" status="i" var="journalpostInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${journalpostInstance.id}">${fieldValue(bean:journalpostInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:journalpostInstance, field:'systemID')}</td>
                        
                            <td>${fieldValue(bean:journalpostInstance, field:'recordSection')}</td>
                        
                            <td>${fieldValue(bean:journalpostInstance, field:'parentFile')}</td>
                        
                            <td>${fieldValue(bean:journalpostInstance, field:'recordType')}</td>
                        
                            <td>${fieldValue(bean:journalpostInstance, field:'createdDate')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <%-- <g:paginate total="${journalpostInstanceTotal}" /> --%>
            </div>
        </div>
    </body>
</html>
