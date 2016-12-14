angular.module('spa')
	.controller('adminFuncionariosCtrl', ['$scope', '$rootScope', '$mdToast', '$http', '$location',
	function($scope, $rootScope, $mdToast, $http, location){
		$scope.name = 'Funcionários - Administração';

		$scope.consultarFuncionarios = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({ 
                        url: $rootScope.api + '/funcionarios/consultar', 
                        dataType: 'json', 
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'},
                    }).success(function (response) {
                        $scope.funcionarios = response;
                        console.log(response);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }                       
                        $scope.funcionarios();             
                    });
            }else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };
	      
      	$scope.getFuncionariosPorId = function(id){
        	return _.find($scope.funcionarios, function(item){
            	return item.id === id;
        	})
        };

	}]
);