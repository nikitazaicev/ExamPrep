"use strict"
let firstValue = document.getElementById("demo").textContent;
document.getElementById("demo").addEventListener("mousemove", displayDate);
document.getElementById("demo").addEventListener("mouseleave", hideDate);
document.getElementById("demo").addEventListener("click", NoeNytt);
function displayDate(){
	let d = new Date();
	let output = document.getElementById("demo");
	output.innerHTML = d;
	output.style.color = "#00FF00";
	
}
function  hideDate(){
    let myEl = document.getElementById("demo").textContent;
   
    document.getElementById("demo").innerHTML = firstValue;
    document.getElementById("demo").style.color = "red";
   
}
function NoeNytt(){
     document.getElementById("demo").innerHTML = "eple";
}