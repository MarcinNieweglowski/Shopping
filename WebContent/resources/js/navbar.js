/**
 * 
 */
 
function activeNavBtn(elem) {
	var previous = document.querySelector(".clicked");
	previous.classList.remove("clicked");
	elem.target.classList.add("clicked");
}

function updateClock() {
	var el = document.querySelector("#theTime");
	var now = new Date();
	var mins;
	var seconds;
	if (now.getMinutes() < 10) {
		mins = "0" + now.getMinutes();
	} else
		mins = now.getMinutes();
	
	if (now.getSeconds() < 10) {
		seconds = "0" + now.getSeconds();
	} else
		seconds = now.getSeconds();
	
	var time = now.getHours() + ":" + mins + ":" + seconds; 
	el.innerHTML = time;
	setTimeout(updateClock, 500);
}
updateClock();

//function activeNavBtn(event) {
//	var previous = document.querySelector(".active");
////	var currentSite = window.location.pathname;
//	previous.classList.remove("active");
//	event.target.classList.add("active");
//}
