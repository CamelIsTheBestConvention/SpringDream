const categoryRadio = $('.category-radio');
const writeTitle = $('#write-title');
const writeContent = $('#write-content');

const alertMsg1 = $('#alertMsg1')
const alertMsg2 = $('#alertMsg2')
const alertMsg3 = $('#alertMsg3')

alertMsg1.hide();
alertMsg2.hide();
alertMsg3.hide();

// 카테고리 라디오
categoryRadio.focusin(function () {
    if(!categoryRadio.val()){
        alertMsg1.css('color', '#ff0000');
        alertMsg1.show();
    }
});

categoryRadio.focusout(function () {
    if(categoryRadio.val()){
        alertMsg1.css('color', '#008000');
    }

    else alertMsg1.css('color', '#ff0000');
})

// 신고 타입
writeTitle.focusin(function () {
    if(!writeTitle.val()){
        alertMsg2.css('color', '#ff0000');
        alertMsg2.show();
    }
});

writeTitle.focusout(function () {
    if(writeTitle.val()){
        alertMsg2.css('color', '#008000');
    }

    else alertMsg2.css('color', '#ff0000');
})

// 신고 내용
writeContent.focusin(function () {
    if(!writeContent.val()){
        alertMsg3.css('color', '#ff0000');
        alertMsg3.show();
    }
});

writeContent.focusout(function () {
    if(writeContent.val()){
        alertMsg3.css('color', '#008000');
    }

    else alertMsg3.css('color', '#ff0000');
})

function checkSubmit() {
    if(!categoryRadio.val() || !writeTitle.val() || !writeContent.val()){
        alert("입력이 안 된 사항이 있습니다.");
        return false;
    }

    else return true;
}