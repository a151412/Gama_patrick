function gerarRelatorio() {

    validalogin();
    fetch("http://localhost:8080/alarmestodos")
    .then(res => res.json())
    .then(lista => preencheRelatorio(lista))
}


function preencheRelatorio(lista){
    var body = ''
    $.each(lista, (index, alarme) => {
        body += `
        <tr>
            <td>${alarme.id}</td>
            <td>${alarme.nome}</td>
            <td>${alarme.descricao}</td>
        </tr>
    `})
    var strTable = `<div class="card">
                        <table class="table table-hover table-striped"
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nome</th>
                                    <th>Descricao</th>
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