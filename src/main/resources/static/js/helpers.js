function parseObject(form){
    var object = {};
    $(form).each(function(){
        object[$(this)[0].name] = $(this)[0].value;
    });

    return object;
}

function sendRequest(url, data){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        'type': 'POST',
        'url': url,
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': function(response){
            signupUser(response);
        }
    })
}