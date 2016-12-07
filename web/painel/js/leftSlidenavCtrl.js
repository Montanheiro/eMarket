    angular.module('spa').controller('LeftSlidenavCtrl', function($scope, $timeout, $mdSidenav, $log) {
        $scope.close = function() {
            $mdSidenav('left').close();
        };
    });