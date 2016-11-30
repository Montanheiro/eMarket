(function(){

    angular.module('spa', ['iconesSVG','ngRoute']);

    angular.module('spa').config(function($routeProvider){
        $routeProvider
        .when('/', {
            templateUrl: 'includes/home.html',
            controller: 'HomeCtrl'
        })

        .when('/configuration', {
            templateUrl: 'includes/configuration.html',
            controller: 'ConfigurationCtrl'
        })

        .when('/financeiro', {
            templateUrl: 'includes/financeiro.html',
            controller: 'financeiroCtrl'
        })
        .when('/financeiro/cadastrar/cliente', {
            templateUrl: 'includes/financeiroCadCliente.html',
            controller: 'financeiroCadClienteCtrl'
        })


        .when('/compras', {
            templateUrl: 'includes/compras.html',
            controller: 'comprasCtrl'
        })

        .when('/vendas', {
            templateUrl: 'includes/vendas.html',
            controller: 'vendasCtrl'
        })
        
        .otherwise({ redirectTo: '/'});
    });









  

    





})();

