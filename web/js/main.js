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

        $rootScope.api = "http://localhost:8080/build/webresources";
    });

    main.config(function($mdThemingProvider) {
      $mdThemingProvider.theme('default')
        .primaryPalette('indigo')
        .accentPalette('red');
    });

})();



