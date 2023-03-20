// let myInfo = document.querySelector("#myInfo");
const infos = {
    myInfo : $("#myInfo"),
    myBoards : $("#myBoards"),
    myReply : $("#myReplies"),
    myPoint : $("#myPoints"),
    myCash : $("#myCash")
}
let urls = new Array(
    "../mypage/views/my_info.html",
    "../mypage/views/my_boards.html",
    "../mypage/views/my_reply.html",
    "../mypage/views/my_points.html",
    "../mypage/views/my_cash.html"
);


function chageURL(num){
    var url = urls[num];
    $('#stage').attr('src', url);
}

infos.myInfo.click(function(){
    chageURL(0);
});

infos.myBoards.click(function(){
    chageURL(1);
});

infos.myReply.click(function(){
    chageURL(2);
});

infos.myPoint.click(function(){
    chageURL(3);
});

infos.myCash.click(function(){
    chageURL(4);
});

window.onload = function(){
    $('.header').load('../header_footer/header.html');
    $('.footer').load('../header_footer/footer.html');
}

//마이페이지 정보 수정
$(document).ready(function(){
    $(".update-btn").click(function(){
        $("#update-form").attr("action", "/member/myinfo");
        $("#update-form").submit();
    });
});

//로그아웃
//$(document).ready(function(){
//     $(".logout-btn").click(function(){
//         $("#logout-form").attr("action", "/member/logout");
//         $("#logout-form").submit();
//     });
//});