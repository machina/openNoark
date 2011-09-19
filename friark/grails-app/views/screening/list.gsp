<%@ page import="org.friark.ds.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Skjerming List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Skjerming</g:link></span>
        </div>
        <div class="body">
            <h1>Skjerming List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="tilgangsrestriksjon" title="Tilgangsrestriksjon" />
                        
                   	        <g:sortableColumn property="skjermingshjemmel" title="Skjermingshjemmel" />
                        
                   	        <g:sortableColumn property="skjermingdokument" title="Skjermingdokument" />
                        
                   	        <g:sortableColumn property="skjermingsvarighet" title="Skjermingsvarighet" />
                        
                   	        <g:sortableColumn property="skjermingopphørerdato" title="Skjermingopphørerdato" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${skjermingInstanceList}" status="i" var="skjermingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${skjermingInstance.id}">${fieldValue(bean:skjermingInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:skjermingInstance, field:'accessRestriction')}</td>
                        
                            <td>${fieldValue(bean:skjermingInstance, field:'screeningAuthority')}</td>
                        
                            <td>${fieldValue(bean:skjermingInstance, field:'screeningDocument')}</td>
                        
                            <td>${fieldValue(bean:skjermingInstance, field:'screeningDuration')}</td>
                        
                            <td>${fieldValue(bean:skjermingInstance, field:'screeningCeasesDate')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <%--
            <div class="paginateButtons">
                <g:paginate total="${skjermingInstanceTotal}" />
            </div>
            --%>
        </div>
    </body>
</html>
