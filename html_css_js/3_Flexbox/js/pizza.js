console.log("Im working");

let currentSize;
var btn25 = document.getElementById("btn25");
var btn30 = document.getElementById("btn30");
var btn35 = document.getElementById("btn35");
document.getElementById('size').innerHTML = (0 +" см");

btn25.onclick = function () {
    currentSize = 25;
    console.log(currentSize + "см");
    document.getElementById('size').innerHTML = (currentSize+ " см");
}
btn30.onclick = function () {
    currentSize = 30;
    console.log(currentSize + "см");
    document.getElementById('size').innerHTML = (currentSize+ " см");
}
btn35.onclick = function () {
    currentSize = 35;
    console.log(currentSize + "см");
    document.getElementById('size').innerHTML = (currentSize+ " см");
}

