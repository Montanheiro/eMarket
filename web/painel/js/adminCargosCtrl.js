angular.module('spa')
	.controller('adminCargosCtrl', ['$scope', '$rootScope', '$mdToast', '$http', '$location',
	function($scope, $rootScope, $mdToast, $http, location){
		$scope.name = 'Cargos - Administração';

		/*$scope.cargos = $http.get($rootScope.api + '/eMarket/webresources/cargos')
		    .then(function(response) {
		        $scope.cargos = response.data;
		    });*/


		$scope.consultarCargos = function(){
            let teste = true;
            if(teste) {
                $http({ 
                        url: $rootScope.api + '/eMarket/webresources/cargos/consultartudo', 
                        dataType: 'json', 
                        method:'GET',
                        headers: {'Content-Type': 'application/json'},
                    }).success(function (response) {
                        $scope.cargos = response.items;
                        console.log(response.items);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            //caso retornar falso é porque o token não é mais valido e não aceitou a cominicação
                            //window.location = "/#/login";
                        }                       
                        $scope.cargos();             
                    });
                }else{
                    console.log("sem token");
                    //window.location = "/#/login";
                }
        };


		/*$http.get('http://192.168.0.138:37157/eMarket/webresources/cargos');*/

		/*$scope.cargos = [
			{id: 1, nome: 'secretária'},
			{id: 2, nome: 'faxineira'},
			{id: 3, nome: 'gerente'},
			{id: 4, nome: 'repositor', descricao: "invisivel"}
		]*/
		      
      	$scope.getCargosPorId = function(id){
        	return _.find($scope.cargos, function(item){
            	return item.id === id;
        	})
        };




        /*  SE FOR USAR SELECT NA TABELA
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
        };*/

	}]
);