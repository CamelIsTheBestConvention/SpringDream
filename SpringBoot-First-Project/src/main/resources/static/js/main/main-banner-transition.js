// function Slider(target, type) {
//     // 상태
//     let index = 1;
//     let isMoved = true;
//     const speed = 1000; // ms
    
//     let colorArr = new Array( '#303441', '#0ac3dd', '#37116c', '#37b86b', '#303441', '#0ac3dd');

//     // 방향
//     const transform = "transform " + speed / 1000 + "s";
//     let translate = (i) => "translateX(-" + 100 * i + "%)";
//     if (type === "V") {
//       translate = (i) => "translateY(-" + 100 * i + "%)";
//     }
  
//     // 슬라이더
//     const slider = document.querySelector(target);
//     const sliderRects = slider.getClientRects()[0];
//     slider.style["overflow"] = "hidden";
  
//     // 슬라이더 화면 컨테이너
//     const container = document.createElement("div");
//     container.style["display"] = "flex";
//     container.style["flex-direction"] = type === "V" ? "column" : "row";
//     container.style["width"] = 540 + "px";
//     container.style["height"] = 380 + "px";
//     container.style["transform"] = translate(index);
  
//     // 슬라이더 화면 목록
//     let boxes = [].slice.call(slider.children);
//     boxes = [].concat(boxes[boxes.length - 1], boxes, boxes[0]);
  
//     // 슬라이더 화면 스타일
//     const size = boxes.length;
//     for (let i = 0; i < size; i++) {
//       const box = boxes[i];
//       box.style["flex"] = "none";
//       box.style["flex-wrap"] = "wrap";
//       box.style["height"] = "100%";
//       box.style["width"] = "100%";
//       container.appendChild(box.cloneNode(true));
//     }
  
//     // 처음/마지막 화면 눈속임 이벤트
//     container.addEventListener("transitionstart", function () {
//       isMoved = false;
//       setTimeout(() => {
//         isMoved = true;
//       }, speed);
//     });
//     container.addEventListener("transitionend", function () {
//       // 처음으로 순간이동
//       if (index === size - 1) {
//         index = 1;
//         container.style["transition"] = "none";
//         container.style["transform"] = translate(index);
//       }
//       // 끝으로 순간이동
//       if (index === 0) {
//         index = size - 2;
//         container.style["transition"] = "none";
//         container.style["transform"] = translate(index);
//       }
//     });
  
//     // 슬라이더 붙이기
//     slider.innerHTML = "";
//     slider.appendChild(container);
  
//     return {
//       move: function (i) {
//         if (isMoved === true) {
//           index = i;
//           container.style["transition"] = transform;
//           container.style["transform"] = translate(index);
//         }
//       },
//       next: function () {
//         if (isMoved === true) {
//           index = (index + 1) % size;
//           let bg = $('.css-section1').css("background-color", colorArr[index]);
//           container.style["transition"] = transform;
//           container.style["transform"] = translate(index);
//         }
//       },
//       prev: function () {
//         if (isMoved === true) {
//           index = index === 0 ? index + size : index;
//           index = (index - 1) % size;
//           container.style["transition"] = transform;
//           container.style["transform"] = translate(index);
//         }
//       }
//     };
//   }
  
//   const s1 = new Slider(".slider", "H");
  
//   setInterval(() => {
//     s1.next();
//   }, 1000)

/*
  div사이즈 동적으로 구하기
*/
// const outer = document.querySelector('.outer');
// const innerList = document.querySelector('.inner-list');
// const inners = document.querySelectorAll('.inner');
// let currentIndex = 0; // 현재 슬라이드 화면 인덱스
//
// let bgColors = new Array('#FF8364', '#FFB677', '#5F6CAF', '#303441');
// let bannerBackground = document.querySelector(".css-section1");
//
// inners.forEach((inner) => {
//   inner.style.width = `${outer.clientWidth}px`; // inner의 width를 모두 outer의 width로 만들기
// })
//
// innerList.style.width = `${outer.clientWidth * inners.length}px`; // innerList의 width를 inner의 width * inner의 개수로 만들기

/*
  버튼에 이벤트 등록하기
*/
const buttonLeft = document.querySelector('.button-left');
const buttonRight = document.querySelector('.button-right');

buttonLeft.addEventListener('click', () => {
  currentIndex--;
  currentIndex = currentIndex < 0 ? 0 : currentIndex; // index값이 0보다 작아질 경우 0으로 변경
  innerList.style.marginLeft = `-${outer.clientWidth * currentIndex}px`; // index만큼 margin을 주어 옆으로 밀기
  clearInterval(interval); // 기존 동작되던 interval 제거
  bannerBackground.style.backgroundColor = bgColors[currentIndex];
  interval = getInterval(); // 새로운 interval 등록
});

buttonRight.addEventListener('click', () => {
  currentIndex++;
  currentIndex = currentIndex >= inners.length ? inners.length - 1 : currentIndex; // index값이 inner의 총 개수보다 많아질 경우 마지막 인덱스값으로 변경
  innerList.style.marginLeft = `-${outer.clientWidth * currentIndex}px`; // index만큼 margin을 주어 옆으로 밀기
  clearInterval(interval); // 기존 동작되던 interval 제거
  bannerBackground.style.backgroundColor = bgColors[currentIndex];
  interval = getInterval(); // 새로운 interval 등록
});

/*
  주기적으로 화면 넘기기
*/

// 여기 수정해야함

const getInterval = () => {
    return setInterval(() => {
        currentIndex++;
        currentIndex = currentIndex >= inners.length ? 0 : currentIndex;
        bannerBackground.style.backgroundColor = bgColors[currentIndex];
        innerList.style.marginLeft = `-${outer.clientWidth * currentIndex}px`;
    }, 2000);
}

let interval = getInterval(); // interval 등록