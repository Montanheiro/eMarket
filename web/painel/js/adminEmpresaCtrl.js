angular.module('spa')
	.controller('adminEmpresaCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$location', '$mdToast',
	function($scope, $rootScope,$routeParams, $http, $location, $mdToast){
    	$scope.name = 'Empresa';

        $scope.buscar = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(token) {
                $http({ 
                        url: $rootScope.api + '/empresa/consultarid?id=' + 1, 
                        dataType: 'json', 
                        method:'GET',
                        headers: {'token': token,'Content-Type': 'application/json'}
                    }).success(function (response) {
                        $scope.empresa = response;
                        $scope.empresa.dataContratacao = $rootScope.receberData($scope.empresa.dataContratacao);
                        $scope.empresa.dataCancelamentoContrato = $rootScope.receberData($scope.empresa.dataCancelamentoContrato);
                        console.log($scope.empresa);
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

        $scope.cancelar = function(){
            $location.path('administracao');
        };

    	$scope.editar = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(token) {
                $http({ 
                        url: $rootScope.api + '/empresa/atualizar', 
                        dataType: 'json', 
                        method:'PUT',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'id': $scope.empresa.id,
                            'nome': $scope.empresa.nome,
                            'razaoSocial': $scope.empresa.razaoSocial,
                            'cnpj': $scope.empresa.cnpj,
                            'dataContratacao': $rootScope.enviarData($scope.empresa.dataContratacao),
                            'dataCancelamentoContrato': $rootScope.enviarData($scope.empresa.dataCancelamentoContrato),                           
                            'statusId': $scope.empresa.status.id
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Editado com sucesso!")
                                .hideDelay(3000)
                        );
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
	}
]);