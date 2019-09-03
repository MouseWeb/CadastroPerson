<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
    <h:head>
        <title>Login</title>
    </h:head>
    <h:body>
        <form action="LoginServlet" method="post">
		Login: <input type="text" id="login" name="login"> <br />
		Senhe: <input type="text" id="senha" name="senha"> <br /> <input
			type="submit" value="Logar">
	</form>
    </h:body>
</html>