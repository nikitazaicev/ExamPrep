"use strict"
let firstValue = document.getElementById("demo").textContent;
document.getElementById("demo").addEventListener("mousemove", displayDate);
document.getElementById("demo").addEventListener("mouseleave", hideDate);
function displayDate(){
	let d = new Date();
	let output = document.getElementById("demo");
	output.innerHTML = d;
	output.style.color = "#00FF00";
	
}
function  hideDate(){
	let output = document.getElementById("demo").textContent;
	document.getElementById("demo").innerHTML = firstValue;
}
