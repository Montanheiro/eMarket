angular.module('spa')
	.controller('adminCargosEditarCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$location', '$mdToast',
	function($scope, $rootScope,$routeParams, $http, $location, $mdToast){
    	$scope.name = 'Editar cargo';

        $scope.cargo = $location.search();

        console.log($scope.cargo);

        $scope.cancelar = function(){
            $location.path('administracao/cadastros/cargos').search({});
        };

    	$scope.editar = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(token) {
                $http({ 
                        url: $rootScope.api + '/cargos/atualizar', 
                        dataType: 'json', 
                        method:'PUT',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'id': $scope.cargo.id,
                            'nome': $scope.cargo.nome
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Editado com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/cargos').search({});
                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao editar ou no token");
                        window.location = "/#/login";
                    });
            }else{
            	alert("sem token");
                window.location = "/#/login";
            }
        };

        $scope.excluir = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(token) {
                $http({ 
                        url: $rootScope.api + '/cargos/deletar', 
                        dataType: 'json', 
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'id': $scope.cargo.id
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Excluído com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/cargos').search({});
                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao excluir ou no token");
                        window.location = "/#/login";
                    });
            }else{
                alert("sem token");
                window.location = "/#/login";
            }
        };
	}
]);