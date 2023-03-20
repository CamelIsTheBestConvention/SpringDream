let headerInput = document.querySelector(".css-input");
let inputWrapper = document.querySelector("#inputWrapper");

// const buttonPayment = document.querySelector(".button-payment");
// const buttonMypage = document.querySelector(".button-mypage");
// const buttonLogout = document.querySelector(".button-logout");
// const buttonLogin= document.querySelector(".button-login");
// const buttonJoin = document.querySelector(".button-join");
// const buttonWrite = document.querySelector("#button-write");

headerInput.addEventListener('focus', function(){
    inputWrapper.style.width = '90%';
    inputWrapper.style.borderColor = '#2e2e2e';
});

headerInput.addEventListener('focusout', function(){
    inputWrapper.style.width = '65%';
    inputWrapper.style.borderColor = 'transparent';
});

// const checkL = (e) =>{  //checkL 이름 바꾸기
//     //로그인 되었을때 payment, mypage, logout, write 보이기 login, join 숨기기
//     //로그인 안되었을때 payment, mypage, logout, write 숨기기 login, join 보이기
//     if(sessionStorage = !null){
//         buttonPayment.style.display = 'block';
//         buttonMypage.style.display = 'block';
//         buttonLogout.style.display = 'block';
//         buttonWrite.style.display = 'block';
//         buttonLogin.style.display = 'none';
//         buttonJoin.style.display = 'none';
//     } else{
//         buttonPayment.style.display = 'none';
//         buttonMypage.style.display = 'none';
//         buttonLogout.style.display = 'none';
//         buttonWrite.style.display = 'none';
//         buttonLogin.style.display = 'block';
//         buttonJoin.style.display = 'block';
//     }
// }