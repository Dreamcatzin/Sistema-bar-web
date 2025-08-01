package com.mycompany.sistemabarweb.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        // Verificação de login (simples, com dados fixos)
        if ("admin".equals(usuario) && "1234".equals(senha)) {
            // Se o login estiver correto:
            // 1. Cria uma sessão para o usuário
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);
            
            // 2. Redireciona para a página de menu
            response.sendRedirect("menu.html");
        } else {
            // Se o login estiver incorreto:
            // 1. Redireciona de volta para a página de login com um parâmetro de erro
            response.sendRedirect("login.jsp?erro=1");
        }
    }
}