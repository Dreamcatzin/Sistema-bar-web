function validarCadastro() {
    let isValid = true;
    
    // Limpar mensagens de erro anteriores
    document.getElementById('nomeError').textContent = '';
    document.getElementById('precoError').textContent = '';
    document.getElementById('estoqueError').textContent = '';

    // Validação do Nome do Produto
    const nomeProduto = document.getElementById('nomeProduto').value;
    if (nomeProduto.trim() === '') {
        document.getElementById('nomeError').textContent = 'O nome do produto é obrigatório.';
        isValid = false;
    }

    // Validação do Preço
    const preco = document.getElementById('preco').value;
    if (preco.trim() === '' || isNaN(parseFloat(preco)) || parseFloat(preco) <= 0) {
        document.getElementById('precoError').textContent = 'Por favor, insira um preço válido.';
        isValid = false;
    }
    
    // Validação do Estoque
    const estoque = document.getElementById('estoque').value;
    if (estoque.trim() === '' || isNaN(parseInt(estoque)) || parseInt(estoque) < 0) {
        document.getElementById('estoqueError').textContent = 'A quantidade em estoque deve ser um número válido.';
        isValid = false;
    }

    if (!isValid) {
        // Impede o envio do formulário
        return false; 
    }

    // Se tudo estiver válido, exibe um alerta de sucesso e permite o envio (ou pode-se adicionar outra lógica)
    alert('Produto cadastrado com sucesso!');
    return true; 
}