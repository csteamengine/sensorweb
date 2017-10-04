$('#login-form').submit(function(event){
    hideWarningDiv();
    event.preventDefault();
    var form = $('#login-form').serializeArray();
    var user = parseObject(form);
    postRequest('/users/login', user,  loginUser);
});

$('#signup-form').submit(function(event){
    hideWarningDiv();
    event.preventDefault();
    var form = $('#signup-form').serializeArray();
    var user = parseObject(form);

    if(user.password === user.verifyPassword){
        postRequest('/users', user, signupUser);
    }else{
        addWarningDiv("Passwords do not match!");
    }
});

function signupUser(response){
    if(response.error === "222"){
        //Username is taken
        addWarningDiv(response.input);
    }else{
        //Store user information in the cookies.
        Cookies.set('user', response);
        $(location).attr( 'href', '/');
    }
}

function loginUser(response){
    if(response.error === "222"){
        addWarningDiv(response.input);
    }else{
        //Store user information in the cookies.
        Cookies.set('user', response);
        $(location).attr( 'href', '/');
    }
}

function hideWarningDiv(){
    $('#message').remove();
}

function addWarningDiv(message){
    var alert = $('#form-fieldset');
    var warning =
        "<div id=\"message\" class=\"alert alert-danger alert-dismissable\">\n" +
        "     <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>\n" +
        "     <strong>Wait!</strong> " + message +
        "</div>";
    alert.prepend(warning);
    alert.show();
}