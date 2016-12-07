angular.module('spa')
	.controller('adminCargosCtrl', ['$scope', '$rootScope', '$mdToast', '$http', 
	function($scope, $rootScope, $mdToast, $http){
		$scope.name = 'Cargos - Administração';

		$scope.deleteRowCallback = function(rows){
            $mdToast.show(
                $mdToast.simple()
                    .content('Deleted row id(s): '+rows)
                    .hideDelay(3000)
            );
        };

        $scope.selecionaElementos = function(rows){
            $mdToast.show(
                $mdToast.simple()
                    .content('Elemento selecionado: '+rows)
                    .hideDelay(3000)
            );
        };

		/*$scope.cargos = $http.get($rootScope.api + '/eMarket/webresources/cargos')
		    .then(function(response) {
		        $scope.cargos = response.data;
		    });


		$scope.cargos = $http({ 
                        url: $rootScope.api + '/eMarket/webresources/cargos', 
                        dataType: 'json', 
                        method:'POST',
                        headers: {'x-access-token': token,'Content-Type': 'application/json'},
                        data: { 
                                'newPassword': $scope.usuario.senhaNova,
                                'oldPassword': $scope.usuario.senhaAtual
                            }
                    }).success(function (response) {

                        $scope.alertSnack(response.msg);

                        if(localStorage.getItem("user_session")){
                        	localStorage.setItem('user_session', response.token);
                        }else{
                        	sessionStorage.setItem('user_session', response.token);
                        }
                        
                    }).error(function (response) {
                        $scope.usuario.error = response.msg;
                    });

		$http.get('http://192.168.0.138:37157/eMarket/webresources/cargos');*/

		$scope.cargos = [
			{id: 1, nome: 'secretária'},
			{id: 2, nome: 'faxineira'},
			{id: 3, nome: 'gerente'},
			{id: 4, nome: 'repositor', descricao: "invisivel"}
		]
		      
      	$scope.getCargosPorId = function(id){
        	return _.find($scope.cargos, function(item){
            	return item.id === id;
        	})
        };



	}]
);