/**
 * 
 */
var desc = document.querySelector(".desc");
var buttonAl = document.querySelector("#buttonAl");


desc.addEventListener("mouseover", function() {
	this.classList.add("differentColor");
})


desc.addEventListener("mouseout", function() {
	this.classList.remove("differentColor");
})


buttonAl.addEventListener("click", function() {
	alert("CLICKED THE BUTTON!!");
})

