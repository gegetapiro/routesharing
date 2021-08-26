function simpleload() {
	var indirizzo = "Milano";
	var oggettogeocode = new google.maps.Geocoder();
	oggettogeocode.geocode({
		address : indirizzo
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			var opzioni = {
				zoom : 14,
				center : results[0].geometry.location,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
				draggable : false
			};
			var map = new google.maps.Map(
					document.getElementById("map-canvas"), opzioni);
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

/*
 * #################### funzione here
 * ##############################################
 */

function initMap(position) {
	var latitude = position.coords.latitude;
	var longitude = position.coords.longitude;
	document.getElementById("latlng").value = latitude + ", " + longitude;

	var map = new google.maps.Map(document.getElementById('map-canvas'), {
		zoom : 18,
		center : {
			lat : latitude,
			lng : longitude
		}
	});
	var geocoder = new google.maps.Geocoder;
	var infowindow = new google.maps.InfoWindow;

	geocodeLatLng(geocoder, map, infowindow);

}

function geocodeLatLng(geocoder, map, infowindow) {
	var input = document.getElementById('latlng').value;
	var latlngStr = input.split(',', 2);
	var latlng = {
		lat : parseFloat(latlngStr[0]),
		lng : parseFloat(latlngStr[1])

	};
	geocoder
			.geocode(
					{
						'location' : latlng
					},
					function(results, status) {
						if (status === google.maps.GeocoderStatus.OK) {
							if (results[0]) {
								map.setZoom(14);
								var marker = new google.maps.Marker({
									enableHighAccuracy : true,
									position : latlng,
									map : map
								});
								infowindow
										.setContent(results[0].formatted_address);
								document.getElementById("address").value = results[0].formatted_address;
								infowindow.open(map, marker);
							} else {
								window.alert('No results found');
							}
						} else {
							window.alert('Geocoder failed due to: ' + status);
						}
					});
	document.getElementById("infoherebut").style.display = "block";
}

/* ##################################################################################### */
function inizio() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(initMap);
	} else {
		simpleload();
	}
	document.getElementById("cercahs").value = "Conferma";
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
				mapTypeId : google.maps.MapTypeId.ROADMAP,
				draggable : false
			};
			var map = new google.maps.Map(
					document.getElementById("map-canvas"), opzioni);
			var segnaposto = new google.maps.Marker({
				position : results[0].geometry.location,
				map : map,
				title : indirizzo
			});
			filladdresses();

			var punto = segnaposto.position;
			memocordi(punto);

			var cordicordi = gApplication.getMap().getCenter();

		} else {
			alert("Non è possibile trovare l'indirizzo: " + status);
		}
	});
	document.getElementById("cercahs").value = "Cerca";
}

function memocordi(stringacordi) {
	document.getElementById("campicordi").style.display = "block";
	if (document.getElementById("cordilongcasa").value != "") {
		fettastr = stringacordi.toString();
		var punto = fettastr.indexOf(",");
		document.getElementById("cordilatlavoro").value = fettastr.substring(1,
				punto);
		var punto2 = fettastr.indexOf(")", punto);
		document.getElementById("cordilonglavoro").value = fettastr.substring(
				punto + 1, punto2);
		document.getElementById("prosegui").style.display = "block";
	} else {

		fettastr = stringacordi.toString();
		var punto = fettastr.indexOf(",");
		document.getElementById("cordilatcasa").value = fettastr.substring(1,
				punto);
		var punto2 = fettastr.indexOf(")", punto);
		document.getElementById("cordilongcasa").value = fettastr.substring(
				punto + 1, punto2);
		firstok();
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
	document.getElementById("prosegui").style.display = "none";
}

function showmore() {
	document.getElementById("otherdata").style.display = "block";
	document.getElementById("prosegui").style.display = "none";
	document.getElementById("again").style.display = "none";
	document.getElementById("map-canvas").style.display = "none";
	document.getElementById("addrtessfield").style.display = "none";
	document.getElementById("arriveaddress").style.display = "none";
	document.getElementById("cercahs").style.display = "none";

}

function compari() {
	if (document.getElementById("comparsa").style.display == "block") {
		document.getElementById("comparsa").style.display = "none";
	} else {
		document.getElementById("comparsa").style.display = "block";
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

function firstok() {
	document.getElementById("startaddress").style.display = "none";
	document.getElementById("arriveaddress").style.display = "block";
	document.getElementById("address").value = "";
}

function shophone() {
	if (document.getElementById("thephones").style.display == "none") {
		document.getElementById("thephones").style.display = "block";

	} else {
		document.getElementById("thephones").style.display = "none";
	}
}

function scrollUp() {
	window.scrollTo(0, 400);
}

function apricampo(apriochiudi) {
	document.getElementById("manydays").style.display = apriochiudi;
}

function selectcontrol() {
	if (document.getElementById("tipoaccordo").value == "cifraesatta") {
		document.getElementById("conticifra").style.display = "inline";
	} else {
		document.getElementById("conticifra").style.display = "none";
	}
}

function hideinfomore() {
	document.getElementById("altreinformazioni").style.display = "none";

}

function showmoreinfo() {
	if (document.getElementById("altreinformazioni").style.display == "none") {
		document.getElementById("altreinformazioni").style.display = "block";
		document.getElementById("showpiu").style.display = "none";
		document.getElementById("showmeno").style.display = "block";
	} else {
		document.getElementById("altreinformazioni").style.display = "none";
		document.getElementById("showpiu").style.display = "block";
		document.getElementById("showmeno").style.display = "none";
	}

}
