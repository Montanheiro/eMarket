(function(){

    angular.module('spa', ['iconesSVG','ngRoute']);

    angular.module('spa').config(function($routeProvider){
        $routeProvider
        .when('/', {
            templateUrl: 'includes/home.html',
            controller: 'HomeCtrl'
        })

        .when('/favorite', {
            templateUrl: 'includes/favorite.html',
            controller: 'FavoriteCtrl'
        })

        .when('/configuration', {
            templateUrl: 'includes/configuration.html',
            controller: 'ConfigurationCtrl'
        })

        .when('/financeiro', {
            templateUrl: 'includes/financeiro.html',
            controller: 'financeiroCtrl'
        })
        .otherwise({ redirectTo: '/'});
    });














    

    





})()

