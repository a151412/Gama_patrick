function login() {
    console.log('Entrou...');
    usr = $('#txtLogin').val();
    psswd = $('#txtSenha').val();
    
    var msgBody = {
        email: usr,
        racf: usr,
        senha: psswd
    }

    var cabecalho = {
        method : "POST",
        body   : JSON.stringify(msgBody),
        headers : {
            "content-type" : "application/json"
        }
    }

        fetch("http://localhost:8080/login", cabecalho)
            .then(res => trataResultado(res));
}

function trataResultado(res){
    if (res.status == 200){
        res.json().then(usuario => {
            localStorage.setItem("userDASH", JSON.stringify(usuario));
            window.location = "relatorio.html";
        });
    }
    else if (res.status == 403){
        document.getElementById("msgErro").innerHTML = "Senha Invalida";
    }
    else if (res.status == 404){
        document.getElementById("msgErro").innerHTML = "Usuario nao encontrado";
    }
    else {
        document.getElementById("msgErro").innerHTML = "Erro desconhecido";
    }
}
