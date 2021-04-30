function gerarRelatorio() {

    validalogin();
    fetch("http://localhost:8080/equipamentostodos")
    .then(res => res.json())
    .then(lista => preencheRelatorio(lista))
}


function preencheRelatorio(lista){
    var body = ''
    $.each(lista, (index, equipamento) => {
        body += `
        <tr>
            <td>${equipamento.id}</td>
            <td>${equipamento.hostname}</td>
            <td>${equipamento.ipaddr}</td>
        </tr>
    `})
    var strTable = `<div class="card">
                        <table class="table table-hover table-striped"
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Hostname</th>
                                    <th>End. IP</th>
                                </tr>
                            </thead>
                            <body>
                                ${body}
                            </body>
                        </table>
                    </div>
    `
    $("#relatorio").html(strTable)
}