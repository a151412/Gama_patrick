function carregaInfo(){
    validalogin();
    var strUsuario = localStorage.getItem("userDASH");

    // aqui começa o preenchimento das infos...
    // agora maninpulo o usuario como um objeto
    var usuario = JSON.parse(strUsuario);

    document.getElementById("fotoUser").innerHTML = `<img src="${usuario.linkFoto}" width="100%" class="rounded-pill">`;
    document.getElementById("bioUser").innerHTML  = `<h4>${usuario.nome}</h4>
                                                    <hr>
                                                    <table>
                                                    <body>
                                                    <tr><td><strong>Racf:</strong></td><td> ${usuario.racf}</td> </tr>
                                                    <tr><td><strong>Email:</strong></td><td> ${usuario.email}</td> </tr>
                                                    <tr><td><strong>Ramal:</strong></td><td> ${usuario.ramal}</td> </tr>
                                                    </body>
                                                    </table>
                                                    
                                                    `;

}