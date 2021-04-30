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
    fetch("http://localhost:8080/eventosporperiodo", cabecalho)
    .then(res => res.json())
    .then(lista => preencheRelatorio(lista))
}


function preencheRelatorio(lista){
    var body = ''
    $.each(lista, (index, evento) => {
        body += `
        <tr>
            <td>${evento.numSeq}</td>
            <td>${evento.data.split('-').reverse().join([separator='/'])}</td>
            <td>${evento.alarme.nome}</td>
            <td>${evento.equipamento.hostname}</td>
            <td>${evento.equipamento.ipaddr}</td>
        </tr>
    `})
    var strTable = `<table class="table table-hover table-striped"
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Data</th>
                                <th>Alarme</th>
                                <th>Equipamento</th>
                                <th>IP</th>
                            </tr>
                        </thead>
                        <body>
                            ${body}
                        </body>
                    </table>
    `
    $("#relatorio").html(strTable)
}