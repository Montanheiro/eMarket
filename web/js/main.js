(function(){

    let main = angular.module('spa', ['iconesSVG','ngRoute','ui.utils.masks', 'mdDataTable', 'ngMdIcons', 'ngSanitize']);

    angular.module('spa').config(function($routeProvider){
        $routeProvider
        .when('/', {
            templateUrl: 'includes/login.html',
            controller: 'loginCtrl'
        })

        .when('/registrar', {
            templateUrl: 'includes/registrar.html',
            controller: 'registrarCtrl'
        })

        .otherwise({ redirectTo: '/'});
    });

    main.controller('mainCtrl', function($rootScope) {

        $rootScope.api = "http://backend-emarket.montanheiro.me:8080/webresources";
    });

    main.config(function($mdThemingProvider) {
      $mdThemingProvider.theme('default')
        .primaryPalette('indigo')
        .accentPalette('red');
    });

})();



