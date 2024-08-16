//DESENVOLVIDA EM ANGULARJS
angular.module("buscar", []).controller('ControllerBuscas', ControllerBuscas)
	.constant('API', "http://localhost:8180/BuscaDeRota/API/");


function ControllerBuscas($http, $scope, API) {

	var waypts = [];

	//ANGULAR
	$scope.buscarRotas = function() {

		$http({
			url : API + "buscar/buscarRota",
			method : "GET"
		}).then(_returnSucess);

	}
	
	

	_returnSucess = function(data) {

		//FOR PARA ADICIONAR AS CIDADES DE FORMA CORRETA PARA JOGAR NA API
		angular.forEach(data.data, function(cidade, key) {
			waypts.push({
				location : cidade,
				stopover : true
			});
		})

		initMap();

	}
	
	//chamada do metodo para buscar a rota
	$scope.buscarRotas();

	//API GOOGLE MAPS EXEMPLE
	initMap = function() {
		var directionsService = new google.maps.DirectionsService;
		var directionsDisplay = new google.maps.DirectionsRenderer;
		
		
		/*PODE SER ALTERADO A LATITUDE PARA MOSTRAR A LOCALIZAÇÃO INICIAL*/
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 6,
			center : {
				lat : 41.85,
				lng : -87.65
			}
		});
		directionsDisplay.setMap(map);


		calculateAndDisplayRoute(directionsService, directionsDisplay);

	}

	//API GOOGLE MAPS EXEMPLE
	function calculateAndDisplayRoute(directionsService, directionsDisplay) {
		directionsService.route({
			origin : "Porto União",
			destination : "Curitiba",
			waypoints : waypts,
			optimizeWaypoints : true,
			travelMode : 'DRIVING'
		}, function(response, status) {
			if (status === 'OK') {
				directionsDisplay.setDirections(response);
				var route = response.routes[0];
				var summaryPanel = document.getElementById('directions-panel');
				summaryPanel.innerHTML = '';
				
				for (var i = 0; i < route.legs.length; i++) {
					var routeSegment = i + 1;
					summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
						'</b><br>';
					summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
					summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
					summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
				}
			} else {
				window.alert('Directions request failed due to ' + status);
			}
		});
	}



}