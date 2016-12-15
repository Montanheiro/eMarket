angular.module('spa')
	.controller('estoqFornecedoresEditarCtrl', ['$scope', '$rootScope', '$routeParams', '$http', '$location', '$mdToast',
	function($scope, $rootScope,$routeParams, $http, $location, $mdToast){
		$scope.name = 'Editar Fornecedores';

        $scope.parametrosDaUrl = $location.search(); //

        $scope.cancelar = function(){
            $location.path('estoque/cadastros/fornecedores').search({});
        };

		$scope.consultar = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({
                        url: $rootScope.api + '/cargos/consultar',
                        dataType: 'json',
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'}
                    }).success(function (response) {
                        $scope.cargos = response;
                        console.log(response);
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }
                        $scope.cargos();
                    });
                $http({
                        url: $rootScope.api + '/fornecedores/consultarid?id=' + $scope.parametrosDaUrl.id,
                        dataType: 'json',
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'}
                    }).success(function (response) {
                        $scope.fornecedores = response;
                        $scope.telefones = $scope.fornecedores.pessoa.contato;
                        $scope.emails = $scope.fornecedores.pessoa.email;
                        console.log(response);
                        if ($scope.fornecedores.dataDemissao) {
                            $scope.fornecedores.dataDemissao = $rootScope.receberData($scope.fornecedores.dataDemissao);
                            $scope.fornecedores.dataAdimissao = $rootScope.receberData($scope.fornecedores.dataAdimissao);
                        } else {
                            $scope.fornecedores.dataAdimissao = $rootScope.receberData($scope.fornecedores.dataAdimissao);
                        }
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }
                        $scope.fornecedores();
                    });

            }else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };

        $scope.editarFornecedores = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                if($scope.fornecedores.dataDemissao){
                    $http({
                        url: $rootScope.api + '/fornecedores/atualizar',
                        dataType: 'json',
                        method:'PUT',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: {
                            'id': $scope.fornecedores.id,
                            'salario': $scope.fornecedores.salario,
                            'comissao': $scope.fornecedores.comissao,
                            'dataAdimissao': $rootScope.enviarData($scope.fornecedores.dataAdimissao),
                            'dataDemissao': $rootScope.enviarData($scope.fornecedores.dataDemissao),
                            'pessoa': {
                                'id':  $scope.fornecedores.pessoa.id,
                                'cpf_cnpj': $scope.fornecedores.pessoa.cpf_cnpj,
                                'nome': $scope.fornecedores.pessoa.nome,
                                'endereco': {
                                  'id': $scope.fornecedores.pessoa.endereco.id,
                                  'logradouro': $scope.fornecedores.pessoa.endereco.logradouro,
                                  'bairro': $scope.fornecedores.pessoa.endereco.bairro,
                                  'cidade': $scope.fornecedores.pessoa.endereco.cidade,
                                  'estado': $scope.fornecedores.pessoa.endereco.estado,
                                  'pais': $scope.fornecedores.pessoa.endereco.pais,
                                  'cep': $scope.fornecedores.pessoa.endereco.cep
                                }
                              },
                            'cargo': {
                                'id': $scope.fornecedores.cargo.id}
                        }
                    }).success(function (response) {
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Atualizado com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/fornecedoress').search({});

                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                        window.location = "/#/login";
                    });
                }else{
                    $http({
                        url: $rootScope.api + '/fornecedoress/atualizar',
                        dataType: 'json',
                        method:'PUT',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: {
                            'id': $scope.fornecedores.id,
                            'salario': $scope.fornecedores.salario,
                            'comissao': $scope.fornecedores.comissao,
                            'dataAdimissao': $rootScope.enviarData($scope.fornecedores.dataAdimissao),
                            'pessoa': {
                                'id':  $scope.fornecedores.pessoa.id,
                                'cpf_cnpj': $scope.fornecedores.pessoa.cpf_cnpj,
                                'nome': $scope.fornecedores.pessoa.nome,
                                'endereco': {
                                  'id': $scope.fornecedores.pessoa.endereco.id,
                                  'logradouro': $scope.fornecedores.pessoa.endereco.logradouro,
                                  'bairro': $scope.fornecedores.pessoa.endereco.bairro,
                                  'cidade': $scope.fornecedores.pessoa.endereco.cidade,
                                  'estado': $scope.fornecedores.pessoa.endereco.estado,
                                  'pais': $scope.fornecedores.pessoa.endereco.pais,
                                  'cep': $scope.fornecedores.pessoa.endereco.cep
                                }
                              },
                            'cargo': {
                                'id': $scope.fornecedores.cargo.id}
                        }
                    }).success(function (response) {
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Inserido com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/fornecedoress').search({});

                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                        window.location = "/#/login";
                    });
                }
            }else{
            	alert("sem token");
                window.location = "/#/login";
            }
        };

        $scope.excluir = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({
                        url: $rootScope.api + '/fornecedoress/deletar',
                        dataType: 'json',
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: {
                            'id': $scope.fornecedores.id
                        }
                    }).success(function (response) {
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Excluído com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/fornecedoress').search({});
                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao excluir ou no token");
                        window.location = "/#/login";
                    });
            }else{
                alert("sem token");
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
                            'telefone': $scope.campoTelefone,
                            'pessoaId': $scope.fornecedores.pessoa.id
                        }
                    }).success(function (response) {
                        $scope.campoTelefone = "";
                        let id2 = response.id;
                        let telefone2 = response.telefone;
                        $scope.telefones = [{'id': id2, 'pessoaId': $scope.fornecedores.pessoa.id, 'telefone': telefone2}];
                        console.log(id2, $scope.fornecedores.pessoa.id, telefone2);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Novo telefone inserido com sucesso!")
                                .hideDelay(3000)
                        );
                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                       // window.location = "/#/login";
                    });
            }else{
                alert("sem token");
                //window.location = "/#/login";
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
        }


        $scope.inserirEmail = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
            if(token) {
                $http({
                        url: $rootScope.api + '/emails/inserir',
                        dataType: 'json',
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: {
                            'email': $scope.campoEmail,
                            'pessoaId': $scope.fornecedores.pessoa.id
                        }
                    }).success(function (response) {
                        $scope.campoEmail = "";
                        let id2 = response.id;
                        let email2 = response.email;
                        $scope.emails = [{'id': id2, 'pessoaId': $scope.fornecedores.pessoa.id, 'email': email2}];
                        console.log(id2, $scope.fornecedores.pessoa.id, email2);
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

		$scope.estados = [
			{id: "1", uf: "AC", nome: "Acre"},
			{id: "2", uf: "AL", nome: "Alagoas"},
			{id: "3", uf: "AM", nome: "Amazonas"},
			{id: "4", uf: "AP", nome: "Amapá"},
			{id: "5", uf: "BA", nome: "Bahia"},
			{id: "6", uf: "CE", nome: "Ceará"},
			{id: "7", uf: "DF", nome: "Distrito Federal"},
			{id: "8", uf: "ES", nome: "Espírito Santo"},
			{id: "9", uf: "GO", nome: "Goiás"},
			{id: "10", uf: "MA", nome: "Maranhão"},
			{id: "11", uf: "MG", nome: "Minas Gerais"},
			{id: "12", uf: "MS", nome: "Mato Grosso do Sul"},
			{id: "13", uf: "MT", nome: "Mato Grosso"},
			{id: "14", uf: "PA", nome: "Pará"},
			{id: "15", uf: "PB", nome: "Paraíba"},
			{id: "16", uf: "PE", nome: "Pernambuco"},
			{id: "17", uf: "PI", nome: "Piauí"},
			{id: "18", uf: "PR", nome: "Paraná"},
			{id: "19", uf: "RJ", nome: "Rio de Janeiro"},
			{id: "20", uf: "RN", nome: "Rio Grande do Norte"},
			{id: "21", uf: "RO", nome: "Rondônia"},
			{id: "22", uf: "RR", nome: "Roraima"},
			{id: "23", uf: "RS", nome: "Rio Grande do Sul"},
			{id: "24", uf: "SC", nome: "Santa Catarina"},
			{id: "25", uf: "SE", nome: "Sergipe"},
			{id: "26", uf: "SP", nome: "São Paulo"},
			{id: "27", uf: "TO", nome: "Tocantins"}
		];


}]);
