<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" href="style.css">
    <style>
        /* Estilos adicionais para a tabela */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Produtos Cadastrados</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Preço (R$)</th>
                    <th>Estoque</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${listaDeProdutos}">
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.preco}</td>
                        <td>${produto.quantidade_estoque}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="cadastro_produto.html">Cadastrar Novo Produto</a>
    </div>
</body>
</html>