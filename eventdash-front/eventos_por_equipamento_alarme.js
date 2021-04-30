function gerarRelatorio() {
    validalogin();
    var txtInicio = $("#txtDataInicio").val();
    var txtFim = $("#txtDataFim").val();

    var msgBody = {
        inicio: txtInicio,
        fim: txtFim
    }

    cabecalho = {
        method: "POST",
        body: JSON.stringify(msgBody),
        headers: {
            "content-type": "application/json"
        }
    }
    fetch("http://localhost:8080/eventosporperiodoresumoequipamentoalarme", cabecalho)
    .then(res => res.json())
    .then(lista => preencheRelatorio(lista))
}


function preencheRelatorio(lista){
    var body = ''
    $.each(lista, (index, eventos) => {
        body += `
        <tr>
            <td>${eventos.nomeEquipamento}</td>    
            <td>${eventos.nomeAlarme}</td>    
            <td>${eventos.qtdEventos}</td>
        </tr>
    `})
    var strTable = `<table class="table table-hover table-striped"
                        <thead>
                            <tr>
                                <th>Hostname do Equipamento</th>   
                                <th>Nome do Alarme</th>   
                                <th>Quantidade de Eventos</th>
                            </tr>
                        </thead>
                        <body>
                            ${body}
                        </body>
                    </table>
    `
    $("#relatorio").html(strTable)
}