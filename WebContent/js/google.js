var map;
function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : 40.56,
			lng : 91.57
		},
		zoom : 8
	});
	// This runs when the user clicks on the map
	google.maps.event.addListener(map,'click',function(event) {
		// initialize geocoder
		var geocoder = new google.maps.Geocoder()

		// prepare latitude and longitude
		var latlng = new google.maps.LatLng(event.latLng.lat(),	event.latLng.lng());
		// get address info such as city and state from lat and long
		geocoder.geocode({'latLng' : latlng},function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				var arrAddress = results[0].address_components;
				// console.log(arrAddress[1].long_name);
				// iterate through
				// address_component array
				// find country name
				for (var i = 0; i < results[0].address_components.length; i++) {
					for (var j = 0; j < results[0].address_components[i].types.length; j++) {
						if (results[0].address_components[i].types[j] == "country") {
							country = results[0].address_components[i];
							console.log(country.long_name);
							console.log(country.short_name);
						}

					}
				}
			}
		});
	});
}
