console.log("Im working");

let currentSize;
let cheeseBoard = "сырный борт";
let doubleCheese = "двойной сыр";
let arugula  = "руккола"; 
var btn25 = document.getElementById("btn25");
var btn30 = document.getElementById("btn30");
var btn35 = document.getElementById("btn35");
let chbox1 = document.getElementById('check1');
let chbox2 = document.getElementById('check2');
let chbox3 = document.getElementById('check3');
var toBasket = document.getElementById("toBasket");
let type1 = "Маргарита";
//let numberPizza = document.querySelector("input-pizza__miniRow").ariaValueMax;

//let textarea = document.getElementsByName("one");

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
    if (chbox1.checked) {
        console.log(cheeseBoard);
    }
    else {
        console.log('не выбран');
    }
}

function dablCheeseSelection() {
    if (chbox2.checked) {
        console.log(doubleCheese);
    }
    else {
        console.log('не выбран');
    }
}

function arugulaSelection() {
    if (chbox3.checked) {
        console.log(arugula);
    }
    else {
        console.log('не выбран');
    }
}

function outputBasket(currentSize, cheeseBoard, doubleCheese, arugula) {
    console.log(currentSize +" см" + cheeseBoard + doubleCheese + arugula)
    document.getElementById('input__basket').textContent = (type1 +", " + currentSize + " см," + " " + cheeseBoard + ", " + doubleCheese + ", " + arugula);
}

toBasket.onclick = function () {
    
    outputBasket(currentSize, cheeseBoard, doubleCheese, arugula);
}