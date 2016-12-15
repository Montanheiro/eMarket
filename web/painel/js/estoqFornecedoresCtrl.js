angular.module('spa')
	.controller('estoqFornecedoresCtrl', ['$scope', '$rootScope', '$mdToast', '$http', '$location',
	function($scope, $rootScope, $mdToast, $http, location){
		$scope.name = 'Fornecedores';

		$scope.consultarFornecedores = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({
                        url: $rootScope.api + '/fornecedores/consultar',
                        dataType: 'json',
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'},
                    }).success(function (response) {
                        $scope.fornecedores = response;
                        console.log(response);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }
                        $scope.fornecedores();
                    });
            }else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };

      	$scope.getFornecedoresPorId = function(id){
        	return _.find($scope.fornecedores, function(item){
            	return item.id === id;
        	})
        };

	}]
);
