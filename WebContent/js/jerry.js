// JavaScript Document
function chancingcontent(whattapage){
	var area = document.getElementById("changingarea");
	var areheader = document.getElementById("headerimg");
	areheader.style.display="none";
	/*area.style.display = "none";
	area.style.visibility="hidden";*/
	area.innerHTML="";
	area.innerHTML="<iframe name='context' id='context' src='" + whattapage + "' width='970px' height='374px' frameborder='0'> </iframe>";
}