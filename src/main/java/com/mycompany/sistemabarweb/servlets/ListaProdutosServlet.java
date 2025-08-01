package com.mycompany.sistemabarweb.servlets;

import com.mycompany.sistemabarweb.models.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaProdutosServlet", urlPatterns = {"/lista-produtos"})
public class ListaProdutosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaBarPU");
        EntityManager em = emf.createEntityManager();
        
        List<Produto> listaDeProdutos = null;
        
        try {
            // JPQL: Java Persistence Query Language para buscar todos os objetos Produto
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
            listaDeProdutos = query.getResultList();
        } finally {
            em.close();
            emf.close();
        }
        
        // Adiciona a lista de produtos como um atributo na requisição
        request.setAttribute("listaDeProdutos", listaDeProdutos);
        
        // Encaminha a requisição (com a lista) para o arquivo JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-produtos.jsp");
        dispatcher.forward(request, response);
    }
}