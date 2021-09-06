console.log("Im working");

let currentSize;
var btn25 = document.getElementById("btn25");
var btn30 = document.getElementById("btn30");
var btn35 = document.getElementById("btn35");


function outputsize(currentSize) {
    document.getElementById('size').innerHTML = (currentSize +" см");
}

btn25.onclick = function () {
    currentSize = 25;
    console.log(currentSize + "см");
    outputsize(currentSize);
}
btn30.onclick = function () {
    currentSize = 30;
    console.log(currentSize + "см");
    outputsize(currentSize);
}
btn35.onclick = function () {
    currentSize = 35;
    console.log(currentSize + "см");
    outputsize(currentSize);
}

function cheeseSelection() {
    let chbox;
    chbox = document.getElementById('check1');
        if (chbox.checked) {
            console.log("сырный борт");
        }
        else {
            console.log('не выбран');
        }
}

function dablCheeseSelection() {
    let chbox;
    chbox = document.getElementById('check2');
        if (chbox.checked) {
            console.log("двойной сыр");
        }
        else {
            console.log('не выбран');
        }
}

function arugulaSelection() {
    let chbox;
    chbox = document.getElementById('check3');
            if (chbox.checked) {
                console.log("руккола");
            }
            else {
                console.log('не выбран');
            }
}