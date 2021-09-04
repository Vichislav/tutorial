const tabsBtn = document.querySelectorAll(".tabs__nav-btn"); //выбрали все кнопки и завели их в константу tabsBtn
const tabsItems = document.querySelectorAll(".tabs__item"); //выбираем все айтемы(текста) и заводим их в константу tabsItems


tabsBtn.forEach(onTabClick);   //перебираем все кнопки и вешаем функцию выполняющую другую функцию -выполнения клика...
   
    function onTabClick(item){
        
        item.addEventListener("click", function(){
            let currentBtn = item; //помещаем кнопку в переменную текущая кнопка
            let tabId = currentBtn.getAttribute("data-tab"); //заводим в переменную значение data-tab текущей кнопки
            let currentTab = document.querySelector(tabId); //выбираем документ по id из tabId

            if ( ! currentBtn.classList.contains("active")){ // (! переворачивает действие условия) если у текущей кнопки нет класса актив то мы выполняем то что снизу понаписанно

                tabsBtn.forEach(function(item) {  //перебираем все кнопки и вешаем на них функцию
                    item.classList.remove("active"); // которя отбирает у Всех класс актив (убирает цвет)
                });
                tabsItems.forEach(function(item) {  //перебираем все айтемы (текста) и вешаем на них функцию
                    item.classList.remove("active"); // которя отбирает у Всех класс актив (убирает текст из окна)
                });
        
                currentBtn.classList.add("active"); //выдаем текущей кнопке (которую нажали, click) класс active (меняем ее цвет)
                currentTab.classList.add("active");  //выбранный по id документ делаем активным
            }
        });
   }
    
document.querySelector(".tabs__nav-btn").click(); //виртулаьный клик по первому табу. выбираем документ с таким классом (программа выбирет первый)
/*document.querySelector(".tabs__nav-btn:nth-child(2)").click(); так бы вырали 2 элемент и т.д.*/