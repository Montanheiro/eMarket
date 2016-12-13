angular.module('spa')
    .controller('loginCtrl',
    function($scope, $rootScope, $http, $timeout){

    	$scope.verificar = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            
            if(token) {
                $http({ 
                    url: $rootScope.api + '/login/verificar', 
                    dataType: 'json', 
                    method:'GET',
                    headers: {'token': token, 'Content-Type': 'application/json'},
                }).success(function (response) {
                    console.log("esta logado");
                    window.location = "/painel/#/";
                }).error(function (response) {
                    console.log("não esta logado --" + response);                
                });
            }    
        };

        $scope.login = function(){
            
            $scope.login.error = "";
      
            var login = $scope.usuario.login;
            var senha = $scope.usuario.senha;
            var manterLogado = $scope.usuario.manterLogado;

            $http({ 
                url: $rootScope.api + '/login/logar', 
                dataType: 'json', 
                method:'POST',
                headers: {'Content-Type': 'application/json'},
                data: { 
                        'login': login, 
                        'senha': senha 
                    }
            }).success(function (response) {
                 console.log(response);

                if (manterLogado) {
                    localStorage.setItem('user_session', response);
                    console.log("token gravado no local storage");
                }else{
                    sessionStorage.setItem('user_session', response);
                    console.log("token gravado no session storage");
                }
                window.location = "/painel/#/";
            }).error(function (response) {
                $scope.login.error = "Usuário ou a senha inseridos não coicidem.";
                console.log(response);
            });
            
        };
	}
);