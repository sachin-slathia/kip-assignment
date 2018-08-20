$("form").submit(function(){
    if($('#input-first-name').val().length === 0 ){
        $("#first-name").css("display","block");
        $("#input-first-name").focus();
        return false;
    }
    else {
        $("#first-name").css("display","hidden");
    }
    if($('#input-last-name').val().length === 0 ){
        $("#last-name").css("display","block");
        $("#input-last-name").focus();
        return false;
    }
    else {
        $("#last-name").css("display","hidden");
    }



    if($('#input-password').val().length === 0 ){
        $("#password").css("display","block");
        $("#input-password").focus();
        return false;
    }
    else {
        $("#password").css("display","hidden");
    }
    if($('#input-password').val() !== $('#input-confirm-password').val()){
        $("#match-password").css("display","block");
        $("#input-confirm-password").focus();
        return false;
    }
    else {
        $("#match-password").css("display","hidden");
    }
    if($('#input-mobile').val().length !== 10){
        $("#mobile").css("display","block");
        $("#input-mobile").focus();
        return false;
    }
    else {
        $("#mobile").css("display","hidden");
    }
    /*$.ajax({
        url: 'https://reqres.in/api/users/10',
        dataType: 'json',
        beforeSend: function(){
            $("#card").empty();
            $("#card").html("Loading...");
        },
        type: "GET",
        success: function(jsonData){
            console.log(jsonData);
            var card = '<div class="card" style="display: block;">'+
                            '<img src="'+ jsonData.data.avatar +'">'+
                            '<div class="card-body">'+
                                '<h4 class="card-title"><a>' + jsonData.data.first_name + ' ' + jsonData.data.last_name + '</a></h4>'+
                            '</div>'+
                        '</div>';
            $("#card").empty();
            $("#card").html(card);
        },
        error: function(error){
            $("#card").empty();
            $("#card").html(error);
        }

    });*/
});