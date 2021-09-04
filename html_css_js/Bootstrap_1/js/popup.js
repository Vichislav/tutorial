const popupLinks = document.querySelectorAll(".popup-Link"); /*завожу в эту переменную все объекты с классом popup-Link так
что кнопкам для попап нужно добавить этот класс*/
const body = document.querySelector("body") /* заводим сюда сам класс боди что бы  ... блокировать скрол...не понял нихрена */
const lockPadding = document.querySelectorAll(".lock-padding") 

let unlock = true; /*что бы не было двойных нажатий */

const timeout = 800; /* 800 мс это значение из css transition: 0.8s транзишн эт все опять таки для бокировки скрола */

if (popupLinks.length > 0) { /* проверка есть ли ссылки на странице и если есть то выполняем тело цикла*/
    for (let index =0; index < popupLinks.length; index++) {
        const popupLink = popupLinks[index]; //пробегаемся по всем объектам popupLink и на каждое вешаем событие (строка ниже)
        popupLink.addEventListener("click", function (e) { 
            const popupName = popupLink.getAttribute("href").replace("#", ""); // убираем из href значок # что бы получить чистое имя, чтобы присвоить его в popupName
            const curentPopup = document.getElementById(popupName);  // зарежаем тот элемент в константу, id которого равен popupName
            popupOpen(curentPopup); //отправляем этот элемент как аргумент в функцию, которая будет заниматься открытием popup
            e.preventDefault(); //запрет ссылке (строка выше это ссылка на функцию) перезагружать страницу
       });
    }
}
const popupCloseIcon = document.querySelectorAll(".close-popup"); //помещаю в константу обьекты с классом .close-popup (у кнопки закрытия должен быть этот класс)
if (popupCloseIcon.length > 0) { // проверяем наличие таких объектов 
    for (let index = 0; index < popupCloseIcon.length; index++) {
        const el = popupCloseIcon[index]; //пробегаемся по всем объектам popupLink и на каждое вешаем событие (строка ниже)
        el.addEventListener("click", function (e) {
            popupClose(el.closest(".popup")); // закрывает ближаейшего родителя с классом popup
            e.preventDefault(); //запрет ссылке (строка выше это ссылка на функцию) перезагружать страницу
        });
    }
}

function popupOpen(curentPopup) {
    if (curentPopup && unlock) { // есть ли переменная curentPopup и перменная unlock true?
        const popupActive = document.querySelector(".popup.open"); //если есть объект с классом .popup и классом .open (т.е. открытый попап)
        if (popupActive) { // если существует popupActive
            popupClose(popupActive, false); // вызывавем функцию закрытия  
        } 
        else {
            bodyLock(); // если нет то блочим скрол ... не понял
        }
        curentPopup.classList.add("open"); // к нашему curentPopup добавляем класс open и он соответсвенно открывается
        curentPopup.addEventListener("click", function (e) { // тут же curentPopup вешаем событие при клике
            if (!e.target.closest(".popup__content")) { // (! это не) если нету в родителях .popup__content (имеется ввиду область вокруг попапа, щелкнули туда окно закрылось)
                popupClose(e.target.closest(".popup")); // тогда вызываем функцию закрытия 
            }
        });
    }
}

function popupClose(popupActive, doUnlock = true) { //для того что бы можно было открывать попап из попапа и при этом не открывался скрол...
    if (unlock) {
        popupActive.classList.remove("open");
        if (doUnlock) {
            bodyUnLock();
        }
    }
}

function bodyLock() {
    const lockPaddingValue = window.innerWidth - document.querySelector(".wrapper").offsetWidth + "px"; //вычисляем значение смещения окна в момент котрытия поапа

    for (let index = 0; index < lockPadding.length; index++) { // перебираем все обекты с классом lockPadding 
        const el = lockPadding[index];
        el.style.paddingRight = lockPaddingValue; // и всем в стиль добавлем высчитанное значение отступа  lockPaddingValue
     } // все для того что бы при открытии поапа контент за ним не дергался (не смещался)
     body.style.paddingRight = lockPaddingValue; // присваиваем расчитанное значение как отступ, чтобы нивилировать смещение
     body.classList.add("lock");

     unlock = false;
     setTimeout(function () { //закрываем на время открытия/закрытия окна возможность нажатия на него снова ...
         unlock = true;
         }, timeout);
}

function bodyUnLock() {
    setTimeout(function () {
        for (let index = 0; index < lockPadding.length; index++) {
            const el = lockPadding[index];
            el.style.paddingRight = "0px"; 
    }
    body.style.paddingRight = "0px";
    body.classList.remove("lock");
    }, timeout); // для того что бы скрол появлялся с задержкой, иначе он в момент появления на момент сместит окно

    unlock = false;
        setTimeout(function () { //закрываем на время открытия/закрытия окна возможность нажатия на него снова ...
            unlock = true;
            }, timeout);

}