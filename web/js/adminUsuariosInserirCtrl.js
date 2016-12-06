angular.module('spa')
	.controller('adminUsuariosInserirCtrl', ['$scope', '$log', function($scope, $log){
		$scope.name = 'Inserir Usuário';


    		$scope.statuss = [

    			{id: "1", tipo: "Ativo"},
    			{id: "2", tipo: "Inativo"}

    		];

}]);
