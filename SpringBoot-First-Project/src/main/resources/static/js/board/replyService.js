let replyService = function () {
    function add(reply , callback , error){
        $.ajax({
            url : "/reply/new",
            type : "post",
            data : JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                callback(result);
            },
            error:function (a,b,c) {
                if(error){
                    error(a,b,c)
                }
            }
            });
    };
    function list(boardNumber , callback , error) {
        $.ajax({
            url : "/reply/" +boardNumber,
            success:function(replies){
                if(callback){
                    callback(replies);
                }
            }

        })
    };

    function remove() {};
    function modify() {};

    return {add : add , list : list , remove : remove , modify : modify};
}
