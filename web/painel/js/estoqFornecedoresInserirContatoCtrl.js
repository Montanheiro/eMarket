angular.module('spa')
	.controller('estoqFornecedoresInserirContatosCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$location', '$mdToast',
	function($scope, $rootScope,$routeParams, $http, $location, $mdToast){
    	$scope.name = 'Inserir novos contatos';

        $scope.parametrosDaUrl = $location.search();
        $scope.pessoaId = $scope.parametrosDaUrl.id;

        $scope.cancelar = function(){
            $location.path('estoque/cadastros/fornecedores').search({});
        };

    	$scope.consultar = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({
                        url: $rootScope.api + '/contatos/consultarbypessoa?id=' + $scope.pessoaId,
                        dataType: 'json',
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'},
                    }).success(function (response) {
                        $scope.telefones = response;
                        console.log(response);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }
                        $scope.telefones();
                    });
                $http({
                        url: $rootScope.api + '/emails/consultarbypessoa?id=' + $scope.pessoaId,
                        dataType: 'json',
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'},
                    }).success(function (response) {
                        $scope.emails = response;
                        console.log(response);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }
                        $scope.emails();
                    });
                }
            else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };

        $scope.inserirTelefone = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({
                        url: $rootScope.api + '/contatos/inserir',
                        dataType: 'json',
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: {
                            'telefone': $scope.telefone,
                            'pessoaId': $scope.pessoaId
                        }
                    }).success(function (response) {
                        $scope.telefone = "";
                        let id2 = response.id;
                        let pessoaId2 = response.pessoaId;
                        let telefone2 = response.telefone;
                        $scope.telefones = [{'id': id2, 'pessoaId': pessoaId2, 'telefone': telefone2}];
                        console.log(id2, pessoaId2, telefone2);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Novo telefone inserido com sucesso!")
                                .hideDelay(3000)
                        );
                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                        window.location = "/#/login";
                    });
            }else{
                alert("sem token");
                window.location = "/#/login";
            }
        };

        $scope.deletarTelefone = function(rows){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            for (var i = 0; i < rows.length; i++) {
                if(token) {
                    $http({
                            url: $rootScope.api + '/contatos/deletar',
                            dataType: 'json',
                            method:'POST',
                            headers: {'token': token,'Content-Type': 'application/json'},
                            data: {
                                'id': rows[i]
                            }
                        }).success(function (response) {
                            console.log(response);
                            $mdToast.show(
                                $mdToast.simple()
                                    .content("Telefone excluído com sucesso!")
                                    .hideDelay(3000)
                            );
                        }).error(function (response) {
                            console.log(response);
                            alert("erro ao inserir ou no token");
                            window.location = "/#/login";
                        });
                }else{
                    alert("sem token");
                    window.location = "/#/login";
                }

            }
        };


        $scope.inserirEmail = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({
                        url: $rootScope.api + '/emails/inserir',
                        dataType: 'json',
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: {
                            'email': $scope.email,
                            'pessoaId': $scope.pessoaId
                        }
                    }).success(function (response) {
                        $scope.email = "";
                        let id2 = response.id;
                        let pessoaId2 = response.pessoaId;
                        let email2 = response.email;
                        $scope.emails = [{'id': id2, 'pessoaId': pessoaId2, 'email': email2}];
                        console.log(id2, pessoaId2, email2);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Novo email inserido com sucesso!")
                                .hideDelay(3000)
                        );
                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                        window.location = "/#/login";
                    });
            }else{
                alert("sem token");
                window.location = "/#/login";
            }
        };

        $scope.deletarEmail = function(rows){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            for (var i = 0; i < rows.length; i++) {
                if(token) {
                    $http({
                            url: $rootScope.api + '/emails/deletar',
                            dataType: 'json',
                            method:'POST',
                            headers: {'token': token,'Content-Type': 'application/json'},
                            data: {
                                'id': rows[i]
                            }
                        }).success(function (response) {
                            console.log(response);
                            $mdToast.show(
                                $mdToast.simple()
                                    .content("Email excluído com sucesso!")
                                    .hideDelay(3000)
                            );
                        }).error(function (response) {
                            console.log(response);
                            alert("erro ao inserir ou no token");
                            window.location = "/#/login";
                        });
                }else{
                    alert("sem token");
                    window.location = "/#/login";
                }

            }
        };

	}
]);
