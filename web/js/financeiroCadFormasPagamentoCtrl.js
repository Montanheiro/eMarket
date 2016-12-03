angular.module('spa')
	.controller('financeiroCadFormasPagamentoCtrl', ['$scope', '$log', function($scope, $log){
		$scope.name = 'Formas de Pagamentos';


		$scope.pagamentos = [

			{id: "1", tipo: "Crédito"},
			{id: "2", tipo: "Débito"}

		];

}]);
