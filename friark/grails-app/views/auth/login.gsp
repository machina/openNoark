<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <title>Login</title>
  </head>
  <body>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>

  <div class="rightColWideTop"><h1></h1></div>
  <div class="rightColWideContent">

    <g:form action="signIn">
      <input type="hidden" name="targetUri" value="${targetUri}" />
      <table class="login">
        <tbody>
          <tr>
            <td><g:message code="username" default="Username"/>:</td>
            <td><input type="text" name="username" value="${username}" /></td>
          </tr>
          <tr>
            <td><g:message code="password" default="Password"/>:</td>
            <td><input type="password" name="password" value="" /></td>
          </tr>
          <tr>
            <td><g:message code="remember.me" default="Remember me"/>?:</td>
            <td><g:checkBox name="rememberMe" value="${rememberMe}" /></td>
        </tr>
        <tr>
          <td />
          <td><input type="submit" value="${message(code:'sign.in')}" /></td>
        </tr>
        </tbody>
      </table>
    </g:form>
  </div>
  <div class="rightColWideBtm"></div>
</body>
</html>
