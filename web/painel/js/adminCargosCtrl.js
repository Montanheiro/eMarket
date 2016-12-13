angular.module('spa')
	.controller('adminCargosCtrl', ['$scope', '$rootScope', '$mdToast', '$http', '$location',
	function($scope, $rootScope, $mdToast, $http, location){
		$scope.name = 'Cargos - Administração';

		$scope.consultarCargos = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({ 
                        url: $rootScope.api + '/cargos/consultar', 
                        dataType: 'json', 
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'},
                    }).success(function (response) {
                        $scope.cargos = response;
                        console.log(response);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }                       
                        $scope.cargos();             
                    });
            }else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };
	      
      	$scope.getCargosPorId = function(id){
        	return _.find($scope.cargos, function(item){
            	return item.id === id;
        	})
        };

	}]
);