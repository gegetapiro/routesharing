function changepage(whattapage, whatbut) {
	var chediv = document.getElementById("apDiv12");

	document.getElementById("tab_1").style.display = "block";
	document.getElementById("tab_2").style.display = "block";
	document.getElementById("tab_3").style.display = "block";
	document.getElementById("tab_4").style.display = "block";
	document.getElementById("tab_5").style.display = "block";
	document.getElementById("tab_6").style.display = "block";

	document.getElementById("tab_1").style.color = "#333";
	document.getElementById("tab_2").style.color = "#333";
	document.getElementById("tab_3").style.color = "#333";
	document.getElementById("tab_4").style.color = "#333";
	document.getElementById("tab_5").style.color = "#333";
	document.getElementById("tab_6").style.color = "#333";

	document.getElementById(whatbut).style.color = "white";
	chediv.innerHTML = "";
	chediv.innerHTML = "<iframe name='context' id='context' src='" + whattapage + "' width='100%' height='374px'> </iframe>";

}

function filladdresses() {
	var content = document.getElementById("address").value;
	if (document.getElementById("theaddress").value == "") {
		document.getElementById("theaddress").value = content;
		document.getElementById("addresstarthidden").value = content;

	} else {
		document.getElementById("theaddress2").value = content;
		document.getElementById("addressarrivehidden").value = content;
	}

}

function changeagain() {
	document.getElementById("cordilatcasa").value = "";
	document.getElementById("cordilongcasa").value = "";
	document.getElementById("cordilatlavoro").value = "";
	document.getElementById("cordilonglavoro").value = "";
	document.getElementById("address").value = "";
	document.getElementById("startaddress").style.display = "block";
	document.getElementById("arriveaddress").style.display = "none";
}

function showmore() {
	document.getElementById("otherdata").style.display = "block";
	document.getElementById("prosegui").style.display = "none";
	document.getElementById("again").style.display = "none";

}

function showmore_2() {
	document.getElementById("otherdata_2").style.display = "block";
	document.getElementById("prosegui_2").style.display = "none";
	document.getElementById("again_2").style.display = "none";
}

/* #############nuova script v3 ###################### */
function simpleload() {
	alert("va");
	var indirizzo = "London";
	var oggettogeocode = new google.maps.Geocoder();
	oggettogeocode.geocode({
		address : indirizzo
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			var opzioni = {
				zoom : 14,
				center : results[0].geometry.location,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			var map = new google.maps.Map(document.getElementById("map_canvas"), opzioni);
			var segnaposto = new google.maps.Marker({
				position : results[0].geometry.location,
				map : map,
				title : indirizzo
			});

			var cordicordi = gApplication.getMap().getCenter();

		} else {
			alert("Non  possibile trovare l'indirizzo: " + status);
		}
	});
}

function initialize() {
	var indirizzo = document.getElementById("address").value;

	var oggettogeocode = new google.maps.Geocoder();
	oggettogeocode.geocode({
		address : indirizzo
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			var opzioni = {
				zoom : 14,
				center : results[0].geometry.location,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};
			var map = new google.maps.Map(document.getElementById("map_canvas"), opzioni);
			var segnaposto = new google.maps.Marker({
				position : results[0].geometry.location,
				map : map,
				title : indirizzo
			});
			filladdresses();
			var punto = segnaposto.position;
			memocordi(punto);
			alert("qui va");

			var cordicordi = gApplication.getMap().getCenter();

		} else {
			alert("Non � possibile trovare l'indirizzo: " + status);
		}
	});
}

/* ###################################################### */
//var point;
function hideShowstr(whatta, choice) {
	var choiceddiv = document.getElementById(whatta);
	choiceddiv.style.display = choice;
}

function firstok() {
	document.getElementById("startaddress").style.display = "none";
	document.getElementById("arriveaddress").style.display = "block";
	document.getElementById("address").value = "";
	/* document.getElementById("prosegui").style.display = "block"; */
}

function memocordi(stringacordi) {
	
	if (document.getElementById("cordilongcasa").value != "") {
		fettastr = stringacordi.toString();
		var punto = fettastr.indexOf(",")
		document.getElementById("cordilatlavoro").value = fettastr.substring(1, punto);
		var punto2 = fettastr.indexOf(")", punto);
		document.getElementById("cordilonglavoro").value = fettastr.substring(punto + 1, punto2);
		document.getElementById("prosegui").style.display = "block";
	} else {

		fettastr = stringacordi.toString();
		var punto = fettastr.indexOf(",")
		document.getElementById("cordilatcasa").value = fettastr.substring(1, punto);
		var punto2 = fettastr.indexOf(")", punto);
		document.getElementById("cordilongcasa").value = fettastr.substring(punto + 1, punto2);
		firstok();
	}

}

function caricali() {
	var firstfield = document.getElementById("cordilatcasa").value;
	var secondfield = document.getElementById("cordilongcasa").value;
	var thirdfield = document.getElementById("cordilatlavoro").value;
	var fourtfield = document.getElementById("cordilonglavoro").value;
	document.getElementById("cordistartlat").value = firstfield;
	document.getElementById("cordistartlong").value = secondfield;
	document.getElementById("cordiarrivelat").value = thirdfield;
	document.getElementById("cordiarrivelong").value = fourtfield;
}

function compari() {
	document.getElementById("comparsa").style.display = "block";
	document.getElementById("prosegui").style.display = "none";
}

function shophone(visibiliti) {
	document.getElementById("visphones").style.display = visibiliti;

}

/* ############# controllo immissione ################# */
function verifica() {
	var primapass = document.getElementById("pw").value;
	var secondpass = document.getElementById("confpass").value;
	if (primapass == secondpass) {
		var valmail = document.getElementById("lamail").value;
		if (valmail.search(/^\w+((-\w+)|(\.\w+))*\@\w+((\.|-)\w+)*\.\w+$/) != -1) {
			return true;
		} else {
			alert("inserire una mail valida");
			return false;

		}
	} else {
		alert("le password inserite sono diverse");
		return false;

	}
}

/* ########################################################## */
function apricampo(apriochiudi) {

	document.getElementById("manydays").style.display = apriochiudi;
}

function showexplain(whatta, choice) {
	document.getElementById(whatta).style.display = choice;
}

// ############ provvisoria ############################
function chiuidivprovvi() {
	document.getElementById("provvisoriodiv").style.display = "none";

}

// #######################################################
// ######################### provvisorio ######################
function provvichiudi() {
	document.getElementById("provvisoriodiv").style.display = "none";
}

// ##############################################################
// ################# controllo select spesa ##################
function selectcontrol() {
	if (document.getElementById("tipoaccordo").value == "cifraesatta") {
		document.getElementById("conticifra").style.display = "inline";
	} else {
		document.getElementById("conticifra").style.display = "none";
	}
}

// #####################################################
function apripagex() {
	window.open("ingrandito.html", "leggi", "width=480px, height=480px, toolbar=no, location=no, status=no, menubar=no, resizable=no");
}