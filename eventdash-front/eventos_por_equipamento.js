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
    fetch("http://localhost:8080/eventosporperiodoresumoequipamento", cabecalho)
    .then(res => res.json())
    .then(lista => preencheRelatorio(lista))
}


function preencheRelatorio(lista){
    var body = ''
    $.each(lista, (index, alarme) => {
        body += `
        <tr>
            <td>${alarme.nomeEquipamento}</td>    
            <td>${alarme.qtdEventos}</td>
        </tr>
    `})
    var strTable = `<table class="table table-hover table-striped"
                        <thead>
                            <tr>
                                <th>Hostname do Equipamento</th>    
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