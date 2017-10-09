function parseObject(form){
    var object = {};
    $(form).each(function(){
        object[$(this)[0].name] = $(this)[0].value;
    });

    return object;
}

function postRequest(url, data, callback){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'POST',
        'url': url,
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': function(response){
            callback(response);
        }
    })
}

function getRequest(url, callback){
    $.ajax({
        'type': 'GET',
        'url': url,
        'dataType': 'json',
        'success': function(response){
            callback(response)
        }
    })
}

function deleteRequest(url, callback){
    $.ajax({
        'type': 'DELETE',
        'url': url,
        'dataType': 'json',
        'success': function(response){
            callback(response);
        }
    })
}