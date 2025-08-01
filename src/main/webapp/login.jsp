<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login - Sistema de Gestão de Bar</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="form-container">
        <form id="loginForm" action="login" method="post">
            <h1>Acessar o Sistema</h1>
            
            <%
                if (request.getParameter("erro") != null && request.getParameter("erro").equals("1")) {
                    out.println("<p style='color:red;'>Usuário ou senha inválidos!</p>");
                }
            %>
            
            <div class="input-group">
                <label for="usuario">Usuário</label>
                <input type="text" id="usuario" name="usuario" required>
            </div>
            <div class="input-group">
                <label for="senha">Senha</label>
                <input type="password" id="senha" name="senha" required>
            </div>
            <button type="submit">Entrar</button>
        </form>
    </div>
</body>
</html>