angular.module('spa')
	.controller('adminCargosCtrl', ['$scope', '$mdToast', 
	function($scope, $mdToast){
		$scope.name = 'Cargos';

		$scope.cargos = [
			{id: 1, descricao: 'secretária'},
			{id: 2, descricao: 'faxineira'},
			{id: 3, descricao: 'gerente'},
			{id: 4, descricao: 'repositor'},
			{id: 1, descricao: 'secretária'},
			{id: 2, descricao: 'faxineira'},
			{id: 3, descricao: 'gerente'},
			{id: 4, descricao: 'repositor'},
			{id: 1, descricao: 'secretária'},
			{id: 2, descricao: 'faxineira'},
			{id: 3, descricao: 'gerente'},
			{id: 4, descricao: 'repositor'},
			{id: 1, descricao: 'secretária'},
			{id: 2, descricao: 'faxineira'},
			{id: 3, descricao: 'gerente'},
			{id: 4, descricao: 'repositor'}
		]


	}]
);