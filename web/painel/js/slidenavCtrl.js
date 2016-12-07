angular.module('spa').controller('SlidenavCtrl', function($scope, $timeout, $mdSidenav, $mdUtil, $log) {
    $scope.toggleLeft = buildToggler('left');
    function buildToggler(navID) {
        var debounceFn = $mdUtil.debounce(function() {
            $mdSidenav(navID)
                .toggle()
        }, 300);
        return debounceFn;
    }
});