const container = document.querySelector(".inner-list");
const arrows = document.querySelectorAll(".arrow");
const firstDiv = document.createElement("div");
firstDiv.classList.add('inner');
firstDiv.id = "img4";
const lastDiv = document.createElement("div");
lastDiv.classList.add('inner');
lastDiv.id = "img1";

const bannerBackground = document.querySelector(".css-section1");
// let bgColors = new Array('#303441', '#FF8364', '#FFB677', '#5F6CAF', '#303441', '#FF8364');
let bgColors = new Array('#6A76FE', '#040F3D', '#2E0549', '#2EAE00', '#6A76FE', '#040F3D');


var count = 0;

firstDiv.innerHTML = `<img src="/img/main/slide4.jpg">`;
container.insertBefore(firstDiv, document.querySelector(".inner-list div"));

lastDiv.innerHTML = `<img src="/img/main/slide1.jpg">`;
container.appendChild(lastDiv);

container.style.transform = "translate(-90vw)";


let inter = setInterval(autoSlide, 3000);

// function autoSlide(){
//     count++;
//     if(count == 4){
//         count = 0;
//     }
//     container.style.transform = "translate(-" + 90*count + "vw)";
//     container.style.transition = "transform 0.5s";
// }

function autoSlide(){
    count++;
    bannerBackground.style.backgroundColor = bgColors[count];
    if(count == 4){
        container.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
        count = 0;
        setTimeout(function(){
            container.style.transition = "transform 0s";
            container.style.transform = "translate(-90vw)";
        }, 500);
        bannerBackground.style.backgroundColor = bgColors[count];
    }else{
        container.style.transition = "transform 0.5s";
        container.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
        bannerBackground.style.backgroundColor = bgColors[count];
    }
}


//이전 다음버튼
// arrows.forEach(arrow => {
//     arrow.addEventListener("click", function (){
//         let arrowType = arrow.classList[1];
//         if (arrowType == "prev"){
//             count--;
//             if(count == -1){
//                 count = 3;
//             }
//         }else{
//             count++;
//             if(count == 4){
//                 count = 0;
//             }
//         }
//
//         container.style.transform = "translate(-" + 90*count + "vw)";
//     })
// })

arrows.forEach(arrow => {
    arrow.addEventListener("click", function (){
        let arrowType = arrow.classList[1];
        clearInterval(inter);
        container.style.transition = "transform 0.5s";
        if (arrowType == "prev"){
            count--;
            bannerBackground.style.backgroundColor = bgColors[count];
            if(count == -1){
                container.style.transform = "translate(0vw)";
                setTimeout(function () {
                    container.style.transition = "transform 0s";
                    container.style.transform = "translate(-360vw)";
                }, 500);
                count = 3;
                bannerBackground.style.backgroundColor = bgColors[count];
            }else{
                container.style.transform = "translate(-"+ 90 * (count + 1) + "vw)";
                bannerBackground.style.backgroundColor = bgColors[count];
            }
        }else{
            count++;
            bannerBackground.style.backgroundColor = bgColors[count];
            if(count == 4){
                container.style.transform = "translate(-"+ 90 * (count + 1) + "vw)";
                setTimeout(function () {
                    container.style.transition = "transform 0s";
                    container.style.transform = "translate(-90vw)";
                }, 500);
                count = 0;
                bannerBackground.style.backgroundColor = bgColors[count];
            }
            else{
                container.style.transform = "translate(-"+ 90 * (count + 1) + "vw)";
                bannerBackground.style.backgroundColor = bgColors[count];
            }
        }
        inter = setInterval(autoSlide,2500);
    })
})