angular.module('spa')
    .controller('loginCtrl',
    function($scope, $rootScope, $http, $timeout){

    	 $scope.isLogado = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            
            if(token) {
                $http({ 
                    url: $rootScope.domain + '/tokenVerify', 
                    dataType: 'json', 
                    method:'GET',
                    headers: {'x-access-token': token,'Content-Type': 'application/json'},
                }).success(function (response) {
                    window.location = "/administracao/#/";
                }).error(function (response) {
                    console.log("aqui" + response);                
                });
            }    
        };

        $scope.login = function(){
            
            $scope.login.error = "";
      
            var email = $scope.usuario.email;
            var senha = $scope.usuario.senha;
            var manterLogado = $scope.usuario.manterLogado;

            $http({ 
                url: $rootScope.domain + '/login', 
                dataType: 'json', 
                method:'POST',
                headers: {'Content-Type': 'application/json'},
                data: { 
                        'email': email, 
                        'password': senha 
                    }
            }).success(function (response) {
                if (manterLogado) {
                    localStorage.setItem('user_session', response.token);
                }else{
                    sessionStorage.setItem('user_session', response.token);
                }
                window.location = "/administracao/#/";
            }).error(function (response) {
                $scope.login.error = "O e-mail ou a senha inseridos não coicidem.";
            });
            
        };

        $scope.recuperarSenha = function(){
            var email = $scope.recuperarEmail.email;
           
            $http({ 
                url: $rootScope.domain + '/recuperarSenha', 
                dataType: 'json', 
                method:'POST',
                headers: {'Content-Type': 'application/json'},
                data: { 
                        'email': email 
                    }
            }).success(function (response) {  
                //mostra a mensagem a mensagem para verificar email          
                document.getElementById("snackbar-location").classList.add("display-block");
                $timeout(function () {                
                        document.getElementById("snackbar-location").classList.remove("display-block");
                    }, 4000);
             });
        };

	}
);