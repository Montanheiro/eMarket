angular.module('spa')
	.controller('adminCargosInserirCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$location',
	function($scope, $rootScope,$routeParams, $http, $location){
    	$scope.name = 'Inserir novo cargo';

        $scope.cancelar = function(){
            $location.path('administracao/cadastros/cargos');
        };


    	$scope.inserirCargo = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(!token) {
                $http({ 
                        url: $rootScope.api + '/eMarket/webresources/cargos', 
                        dataType: 'json', 
                        method:'POST',
                        headers: {'x-access-token': token,'Content-Type': 'application/json'},
                        data: { 
                            'descricao': $scope.nome
                        }
                    }).success(function (response) {                        
                        console.log(response.msg);
                        $mdToast.show(
                            $mdToast.simple()
                                .content(response.msg)
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/cargos');

                    }).error(function (response) {
                        console.log(response.msg);
                        $mdToast.show(
                            $mdToast.simple()
                                .content(response.msg)
                                .hideDelay(3000)
                        );
                    });
            }else{
            	alert("sem token");
                window.location = "/#/login";
            }
        };
	}
]);