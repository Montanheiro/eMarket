angular.module('spa')
	.controller('adminUsuariosCtrl', ['$scope', '$rootScope', '$mdToast', '$http', '$location',
	function($scope, $rootScope, $mdToast, $http, location){
		$scope.name = 'Usuários - Administração';

		$scope.consultarUsuarios = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({ 
                        url: $rootScope.api + '/usuarios/consultar', 
                        dataType: 'json', 
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'},
                    }).success(function (response) {
                        $scope.usuarios = response;
                        console.log(response);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }                       
                        $scope.usuarios();             
                    });
            }else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };
	      
      	$scope.getUsuariosPorId = function(id){
        	return _.find($scope.usuarios, function(item){
            	return item.id === id;
        	})
        };

	}]
);