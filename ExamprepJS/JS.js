"use strict"
let firstValue = document.getElementById("demo").textContent;
document.getElementById("demo").addEventListener("mousemove", displayDate);
document.getElementById("demo").addEventListener("mouseleave", hideDate);
document.getElementById("input").addEventListener("mouseleave", NoeNytt);

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
    let string = document.getElementById("input").value;
    let comment = "";
    if(string === "banan"){
        document.getElementById("output").style.color = "yellow";
        comment = "Good choice";
    }else if(string === "vannmelon"){
         document.getElementById("output").style.color = "green";
        comment = "Not bad";
    }else if(string ==="eple"){
         document.getElementById("output").style.color = "red";
        comment = "One aple a day keeps the doctor away";
    }else if(string ==="apelsin"){
         document.getElementById("output").style.color = "orange";
        comment = "Bad choice";
    }
     document.getElementById("output").innerHTML = comment;
}