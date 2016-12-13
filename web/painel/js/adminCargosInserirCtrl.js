angular.module('spa')
	.controller('adminCargosInserirCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$location', '$mdToast',
	function($scope, $rootScope,$routeParams, $http, $location, $mdToast){
    	$scope.name = 'Inserir novo cargo';

        $scope.cancelar = function(){
            $location.path('administracao/cadastros/cargos').search({});
        };


    	$scope.inserirCargo = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(token) {
                $http({ 
                        url: $rootScope.api + '/cargos/inserir', 
                        dataType: 'json', 
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'nome': $scope.nome
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Inserido com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/cargos').search({});

                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                        window.location = "/#/login";
                    });
            }else{
            	alert("sem token");
                window.location = "/#/login";
            }
        };
	}
]);