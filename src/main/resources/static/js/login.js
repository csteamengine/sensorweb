$('#signup-form').submit(function(event){
    event.preventDefault();
    var form = $('#signup-form').serializeArray();
    var user = parseObject(form);

    if(user.password === user.verifyPassword){
       sendRequest('/users', user, signupUser);
    }
});

function signupUser(response){
    if(response.error == 222){
        //Username is taken
        console.log('username is already taken');
    }else{
        //Store user information in the cookies.
        $.cookie('user', response);
        $(window).location('/');
    }
}