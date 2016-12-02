
angular.module('spa')
	.controller('financeiroCadClienteCtrl', ['$scope', '$log', function($scope, $log){
		$scope.name = 'Cadastro de Clientes';

		$scope.estados = [

			{id: 1, nome: 'São Paulo'},
			{id: 2, nome: 'Goias'},
			{id: 3, nome: 'Tocantins'}

		];

		$scope.selecionarEstado = [
			{id: 1, nome: 'São Paulo'}
		];

}]);