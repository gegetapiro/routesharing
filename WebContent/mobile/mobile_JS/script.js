function closewin() {
	document.getElementById("alert").style.display = "none";
}

function timerclose() {
	setTimeout(closewin, 10000);

}

function hide(quale) {
	document.getElementById(quale).style.display = "none";
}

function hideShow(what) {
	document.getElementById("ascomparsa").style.display = "none";
	changecontent(what);
}

function changecontent(what) {
	area = document.getElementById("variablearea");
	area.innerHTML = "";
	// area.innerHTML="<iframe name='context' id='context' src='" + what + "' width='auto' height='auto' frameborder='0'> </iframe>";
	area.innerHTML = "<iframe name='context' id='context' src='" + what + "'frameborder='0' height='auto' scrolling='no'> </iframe>";
}
