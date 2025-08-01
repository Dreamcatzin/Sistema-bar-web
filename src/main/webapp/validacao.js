function validarCadastro() {
    let isValid = true;
    
    document.getElementById('nomeError').textContent = '';
    document.getElementById('precoError').textContent = '';
    document.getElementById('estoqueError').textContent = '';

    const nomeProduto = document.getElementById('nomeProduto').value;
    if (nomeProduto.trim() === '') {
        document.getElementById('nomeError').textContent = 'O nome do produto é obrigatório.';
        isValid = false;
    }

    const preco = document.getElementById('preco').value;
    if (preco.trim() === '' || isNaN(parseFloat(preco)) || parseFloat(preco) <= 0) {
        document.getElementById('precoError').textContent = 'Por favor, insira um preço válido.';
        isValid = false;
    }
    
    const estoque = document.getElementById('estoque').value;
    if (estoque.trim() === '' || isNaN(parseInt(estoque)) || parseInt(estoque) < 0) {
        document.getElementById('estoqueError').textContent = 'A quantidade em estoque deve ser um número válido.';
        isValid = false;
    }

    return isValid;
}