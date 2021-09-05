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

