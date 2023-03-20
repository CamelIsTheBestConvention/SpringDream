let checkOK = false;
$('#id-check').blur(function(){
    let memberId = $('#id-check').val(); // input_id에 입력되는 값
    checkOK = false;

    $.ajax({
        url : "/member/checkId",
        type : "POST",
        data : {memberId: memberId},
        dataType : 'json',
        success : function(data){

            if(data.count == -1){
                return;
            }

            if(data.count > 0){
                $("#id-alert").html('사용할 수 없는 아이디입니다.');
                $("#id-alert").css('color','red');
            } else {
                $("#id-alert").html('사용할 수 있는 아이디입니다.');
                $("#id-alert").css('color','green');
                checkOK = true;
            }
        },
        error : function(){
            alert("서버요청실패");
        }
    })
})

$("#join-form").submit(function () {
    if(!checkOK) {
        $("#id-alert").html('사용할 수 없는 아이디입니다.');
        $("#id-alert").css('color', 'red');
        return checkOK;
    }

    return checkOK;
});