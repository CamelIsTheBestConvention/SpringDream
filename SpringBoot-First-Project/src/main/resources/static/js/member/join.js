// input 클래스 가져온거 기능 만들기
// function alert() {
//   alert("값을 입력해주세요.");
// }

// let checkOK = true;


//이름
$("#name-check").on("blur",function(){inputName($(this).val());});
function inputName(memberName){
  if(!memberName){
    $("#name-alert").text("이름을 입력해주세요.");
    $("#name-alert").css("color", "red");
    return;
  }else {
    $("#name-alert").text("");
  }
}

//닉네임
$("#nick-check").on("blur",function(){
  let flagNick = true;
  inputNick($(this).val());
  if(flagNick){
    checkNick($(this).val());
  }
});
// 닉네임 입력 유무
function inputNick(memberNickname){
  if(!memberNickname){
    flagNick = false;
    $("#nick-alert").text("닉네임을 입력해주세요.");
    $("#nick-alert").css("color", "red");
    return;
  }else {
    $("#nick-alert").text("");
    flagNick = true;
  }
}
// 닉네임 중복 체크
function checkNick(memberNickname) {
  $.ajax({
    url: "/member/checkNick",
    type: "POST",
    data: JSON.stringify({ memberNickname: memberNickname }),
    contentType: "application/json; charset=utf-8",
    success: function(cnt) {
      if(cnt > 0) {
        $("#nick-alert").text("이미 사용중인 닉네임입니다.");
        $("#nick-alert").css("color", "red");
      } else {
        $("#nick-alert").text("사용 가능한 닉네임입니다.");
        $("#nick-alert").css("color", "green");
      }
    },
    error : function(){
      alert("서버요청실패");
    }
  })
}


//아이디
$("#id-check").on("blur", function(){checkId($(this).val());});

function checkId(memberId){
  if(!memberId){
    $("#id-alert").text("아이디를 입력해주세요.");
    $("#id-alert").css("color", "red");
    return;
  }
}

//비밀번호
$("#pw-check").on("blur",function(){inputPW1($(this).val());});
function inputPW1(memberPW){
  // check = false;
  if(!memberPW){
    $("#pw-alert").text("비밀번호를 입력해주세요.");
    $("#pw-alert").css("color", "red");
    return;
  }else {
    $("#pw-alert").text("");
  }
}

//비밀번호 확인
$("#pw2-check").on("blur",function(){inputPW2($(this).val());});
function inputPW2(memberPW){
  // check = false;
  if(!memberPW){
    $("#pw2-alert").text("비밀번호를 입력해주세요.");
    $("#pw2-alert").css("color", "red");
    return;
  }else {
    $("#pw2-alert").text("");
  }
}

//이메일
$("#mail-check").on("blur",function(){inputEmail($(this).val());});
function inputEmail(memberEmail){
  // check = false;
  if(!memberEmail){
    $("#mail-alert").text("이메일을 입력해주세요.");
    $("#mail-alert").css("color", "red");
    return;
  }else {
    $("#mail-alert").text("");
  }
}

//휴대폰 번호
$("#phone-check").on("blur",function(){inputMobile($(this).val());});
function inputMobile(memberMobile){
  // check = false;
  if(!memberMobile){
    $("#phone-alert").text("휴대폰번호를 입력해주세요.");
    $("#phone-alert").css("color", "red");
    return;
  }else {
    $("#phone-alert").text("");
  }
}

//로그인
// $(document).ready(function(){
//   $(".login-btn").click(function(){
//     $("#login-form").attr("action", "/member/login");
//     $("#login-form").submit();
//   });
// });


// 아이디 중복 체크
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
        $("#id-alert").html('이미 사용중인 아이디입니다.');
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

// 이메일 정규식
$('#mail-check').change(function() {
  let email = $(this).val();
  let pattern_email = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/;
  pattern_email = new RegExp(pattern_email);
  if (pattern_email.test(email) == false) {
    alert('정확한 이메일 주소를 입력하세요');
    $(this).focus();
  }
});

// 비밀번호 정규식
$("#pw-check").change(function(){
  let password = $(this).val();
  let pattern_password = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
  pattern_password = new RegExp(pattern_password);
  if (pattern_password.test(password) == false) {
    alert('최소 8자 영문 대 소문자, 숫자, 특수문자를 사용하세요.');
    $(this).focus();
  }
});

// 휴대폰 정규식
$("#phone-check").change(function(){
  let phoneNumber = $(this).val();
  let pattern_phoneNumber = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
  pattern_phoneNumber = new RegExp(pattern_phoneNumber);
  if (pattern_phoneNumber.test(phoneNumber) == false) {
    alert('정확한 전화번호를 입력해 주세요.');
    $(this).focus();
  }
});

// $("#join-form").submit(function () {
  // if(!checkOK) {
  //   $("#id-alert").html('사용할 수 없는 아이디입니다.');
  //   $("#id-alert").css('color', 'red');
  //   return checkOK;
  // }
  //
//   return checkOK;
// });