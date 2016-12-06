angular.module('spa')
	.controller('adminCargosInserirCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$location',
	function($scope, $rootScope,$routeParams, $http, $location){
    	$scope.name = 'Inserir novo cargo';


    	$scope.inserirCargo = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(!token) {
                $http({ 
                        url: $rootScope.api + '/administracao/cargos/inserir', 
                        dataType: 'json', 
                        method:'POST',
                        headers: {'x-access-token': token,'Content-Type': 'application/json'},
                        data: { 
                                'descricao': $scope.nome
                            }
                    }).success(function (response) {                        
                        console.log(response.msg);
                        $location.path('/administracao/cadastros/cargos');

                    }).error(function (response) {
                        console.log(response.msg);
                    });
            }else{
            	alert("sem token");
                window.location = "/#/login";
            }
        };
	}
]);