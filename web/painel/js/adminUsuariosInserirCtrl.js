angular.module('spa')
	.controller('adminUsuariosInserirCtrl', ['$scope', '$rootScope', '$routeParams', '$http', '$location', '$mdToast',
	function($scope, $rootScope,$routeParams, $http, $location, $mdToast){
		$scope.name = 'Inserir Usuário';

		$scope.cancelar = function(){
            $location.path('administracao/cadastros/usuarios').search({});
        };

		$scope.consultarFuncionarios = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({ 
                        url: $rootScope.api + '/funcionarios/consultar', 
                        dataType: 'json', 
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'}
                    }).success(function (response) {
                        $scope.funcionarios = response;
                        console.log($scope.funcionarios);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            //window.location = "/#/login";
                        }                       
                        $scope.funcionarios();             
                    });

            }else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };

        $scope.inserirUsuario = function(){
        	var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(token) {
                $http({ 
                        url: $rootScope.api + '/usuarios/inserir', 
                        dataType: 'json', 
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'login': $scope.usuario.login,
                            'senha': $scope.usuario.senha,
                            'funcionarioId': $scope.usuario.funcionarioId,
                            'statusId': $scope.usuario.statusId
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Inserido com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/usuarios').search({});

                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                        window.location = "/#/login";
                    });
            }else{
            	alert("sem token");
                window.location = "/#/login";
            }
        }


    	$scope.statuss = [
    		{id: "1", tipo: "Ativo"},
    		{id: "2", tipo: "Inativo"}
    	];

}]);
