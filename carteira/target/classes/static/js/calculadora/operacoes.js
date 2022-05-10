function medio(){
    var preco_atual = parseFloat(document.getElementById("preco_atual").value);
    var quantidade_atual = parseFloat(document.getElementById("quantidade_atual").value);
    var preco_operacao = parseFloat(document.getElementById("preco_operacao").value);
    var quantidade_operacao = parseFloat(document.getElementById("quantidade_operacao").value);

    var resultado = ((preco_atual * quantidade_atual) + (preco_operacao * quantidade_operacao)) / (quantidade_atual + quantidade_operacao);
    document.getElementById("resultado_medio").innerHTML = "Resultado = R$ " + resultado.toFixed(2);
}

function limpar_medio(){
    document.getElementById("preco_atual").value = "";
    document.getElementById("quantidade_atual").value = "";
    document.getElementById("preco_operacao").value = "";
    document.getElementById("quantidade_operacao").value = "";
    document.getElementById("resultado_medio").innerHTML = "";
}

function variacao(){
    var preco_inicial = parseFloat(document.getElementById("preco_inicial").value);
    var preco_final = parseFloat(document.getElementById("preco_final").value);

    var variacao = (preco_final / preco_inicial - 1) * 100;

    document.getElementById("resultado_variacao").innerHTML = "Resultado: " + variacao.toFixed(2) + "%";
}

function limpar_variacao(){
     document.getElementById("preco_inicial").value = "";
     document.getElementById("preco_final").value = "";
     document.getElementById("resultado_variacao").innerHTML = "";
}

function preco_variacao(){
    var preco_ativo = parseFloat(document.getElementById("preco_ativo").value);
    var varicao = parseFloat(document.getElementById("variacao_ativo").value);

    var resultado = preco_ativo * (varicao / 100 + 1);

    document.getElementById("resultado_preco").innerHTML = "Resultado: R$ " + resultado.toFixed(2);
}

function limpar_preco(){
    document.getElementById("preco_ativo").value = "";
    document.getElementById("variacao_ativo").value = "";
    document.getElementById("resultado_preco").innerHTML = "";
}

function quantidade_lotes(){
    var capital = parseFloat(document.getElementById("capital").value);
    var preco = parseFloat(document.getElementById("preco").value);

    var quantidade = parseInt(capital / preco);

    document.getElementById("resultado_quantidade").innerHTML = "Quantidade: " + quantidade + " lotes";
}

function limpar_quantidade(){
    document.getElementById("capital").value = "";
    document.getElementById("preco").value = "";
    document.getElementById("resultado_quantidade").innerHTML = "";
}

function simular(){
    var preco_entrada = parseFloat(document.getElementById("preco_entrada").value);
    var capital = parseFloat(document.getElementById("capital_investido").value);
    var stop_loss = parseFloat(document.getElementById("stop_loss").value);
    var stop_gain = parseFloat(document.getElementById("stop_gain").value);

    var lotes = parseInt(capital / preco_entrada);
    var gain = (stop_gain - preco_entrada) * lotes;
    var loss = (stop_loss - preco_entrada) * lotes;

    document.getElementById("ganho").innerHTML = "Ganho: R$" + gain.toFixed(2) + " / " + ((stop_gain / preco_entrada - 1) * 100).toFixed(2) + "%";
    document.getElementById("perca").innerHTML = "Perca: R$" + loss.toFixed(2) +  " / " + ((stop_loss / preco_entrada - 1) * 100).toFixed(2) + "%";
}

function limpar_simular(){
    document.getElementById("preco_entrada").value = "";
    document.getElementById("capital_investido").value = "";
    document.getElementById("stop_loss").value = "";
    document.getElementById("stop_gain").value = "";

    document.getElementById("ganho").innerHTML = "";
    document.getElementById("perca").innerHTML = "";
}

function quantidade_medio(){
    var preco1 = parseFloat(document.getElementById("preco1").value);
    var quantidade1 = parseInt(document.getElementById("quantidade1").value);
    var preco2 = parseFloat(document.getElementById("preco2").value);
    var preco_medio = parseFloat(document.getElementById("preco_medio").value);

    var quantidade2 = 1 - (preco2 / preco_medio);
    var p2 = ((preco1*quantidade1)/preco_medio) - quantidade1;
    var quantidade2 = parseInt(p2/quantidade2);

    document.getElementById("quantidade_aporte").innerHTML = "Quantidade a comprar: " + quantidade2;
    document.getElementById("investimento").innerHTML = "Capital a investir: " + (quantidade2 * preco2).toFixed();
}

function limpar_quantidade_medio(){
    document.getElementById("preco1").value = "";
    document.getElementById("quantidade1").value = "";
    document.getElementById("preco2").value = "";
    document.getElementById("preco_medio").value = "";

    document.getElementById("quantidade_aporte").innerHTML = "";
    document.getElementById("investimento").innerHTML = "";
}
