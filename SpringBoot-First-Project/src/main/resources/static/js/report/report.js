const title = $('#reportTitle');
const content = $('#reportContent');
const type = $('.reportType');

const alertMsg1 = $('#alertMsg1')
const alertMsg2 = $('#alertMsg2')
const alertMsg3 = $('#alertMsg3')

alertMsg1.hide();
alertMsg2.hide();
alertMsg3.hide();

// 신고제목
title.focusin(function () {
    if(!title.val()){
        alertMsg1.css('color', '#ff0000');
        alertMsg1.show();
    }
});

title.focusout(function () {
    if(title.val()){
        alertMsg1.css('color', '#008000');
    }

    else alertMsg1.css('color', '#ff0000');
})

// 신고 타입
type.focusin(function () {
    if(!type.val()){
        alertMsg2.css('color', '#ff0000');
        alertMsg2.show();
    }
});

type.focusout(function () {
    if(type.val()){
        alertMsg2.css('color', '#008000');
    }

    else alertMsg2.css('color', '#ff0000');
})

// 신고 내용
content.focusin(function () {
    if(!content.val()){
        alertMsg3.css('color', '#ff0000');
        alertMsg3.show();
    }
});

content.focusout(function () {
    if(content.val()){
        alertMsg3.css('color', '#008000');
    }

    else alertMsg3.css('color', '#ff0000');
})

function checkSubmit() {
    if(!title.val() || !type.val() || !content.val()){
        alert("입력이 안 된 사항이 있습니다.");
        return false;
    }

    else return true;
}