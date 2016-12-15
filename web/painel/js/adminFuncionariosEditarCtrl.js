angular.module('spa')
	.controller('adminFuncionariosEditarCtrl', ['$scope', '$rootScope', '$routeParams', '$http', '$location', '$mdToast',
	function($scope, $rootScope,$routeParams, $http, $location, $mdToast){
		$scope.name = 'Editar Funcionário';

        $scope.parametrosDaUrl = $location.search(); //

        $scope.cancelar = function(){
            $location.path('administracao/cadastros/funcionarios').search({});
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
                        url: $rootScope.api + '/funcionarios/consultarid?id=' + $scope.parametrosDaUrl.id, 
                        dataType: 'json', 
                        method:'GET',
                        headers: {'token': token, 'Content-Type': 'application/json'}
                    }).success(function (response) {
                        $scope.funcionario = response;
                        $scope.telefones = $scope.funcionario.pessoa.contato;
                        $scope.emails = $scope.funcionario.pessoa.email;
                        console.log(response);
                        if ($scope.funcionario.dataDemissao) {
                            $scope.funcionario.dataDemissao = $rootScope.receberData($scope.funcionario.dataDemissao);
                            $scope.funcionario.dataAdimissao = $rootScope.receberData($scope.funcionario.dataAdimissao);
                        } else {
                            $scope.funcionario.dataAdimissao = $rootScope.receberData($scope.funcionario.dataAdimissao);
                        }
                    }).error(function (response) {
                        if (!response.success) {
                            console.log("erro response sucess false")
                            console.log(response);
                            window.location = "/#/login";
                        }                       
                        $scope.funcionario();             
                    });

            }else{
                console.log("sem token");
                window.location = "/#/login";
            }
        };

        $scope.editarFuncionario = function(){
            var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");     
            if(token) {
                if($scope.funcionario.dataDemissao){
                    $http({ 
                        url: $rootScope.api + '/funcionarios/atualizar', 
                        dataType: 'json', 
                        method:'PUT',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'id': $scope.funcionario.id,
                            'salario': $scope.funcionario.salario,
                            'comissao': $scope.funcionario.comissao,
                            'dataAdimissao': $rootScope.enviarData($scope.funcionario.dataAdimissao),
                            'dataDemissao': $rootScope.enviarData($scope.funcionario.dataDemissao),
                            'pessoa': {
                                'id':  $scope.funcionario.pessoa.id,
                                'cpf_cnpj': $scope.funcionario.pessoa.cpf_cnpj,
                                'nome': $scope.funcionario.pessoa.nome,
                                'endereco': {
                                  'id': $scope.funcionario.pessoa.endereco.id,
                                  'logradouro': $scope.funcionario.pessoa.endereco.logradouro,
                                  'bairro': $scope.funcionario.pessoa.endereco.bairro,
                                  'cidade': $scope.funcionario.pessoa.endereco.cidade,
                                  'estado': $scope.funcionario.pessoa.endereco.estado,
                                  'pais': $scope.funcionario.pessoa.endereco.pais,
                                  'cep': $scope.funcionario.pessoa.endereco.cep
                                }
                              },
                            'cargo': {
                                'id': $scope.funcionario.cargo.id}                             
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Atualizado com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/funcionarios').search({});

                    }).error(function (response) {
                        console.log(response);
                        alert("erro ao inserir ou no token");
                        window.location = "/#/login";
                    });
                }else{
                    $http({ 
                        url: $rootScope.api + '/funcionarios/atualizar', 
                        dataType: 'json', 
                        method:'PUT',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'id': $scope.funcionario.id,
                            'salario': $scope.funcionario.salario,
                            'comissao': $scope.funcionario.comissao,
                            'dataAdimissao': $rootScope.enviarData($scope.funcionario.dataAdimissao),
                            'pessoa': {
                                'id':  $scope.funcionario.pessoa.id,
                                'cpf_cnpj': $scope.funcionario.pessoa.cpf_cnpj,
                                'nome': $scope.funcionario.pessoa.nome,
                                'endereco': {
                                  'id': $scope.funcionario.pessoa.endereco.id,
                                  'logradouro': $scope.funcionario.pessoa.endereco.logradouro,
                                  'bairro': $scope.funcionario.pessoa.endereco.bairro,
                                  'cidade': $scope.funcionario.pessoa.endereco.cidade,
                                  'estado': $scope.funcionario.pessoa.endereco.estado,
                                  'pais': $scope.funcionario.pessoa.endereco.pais,
                                  'cep': $scope.funcionario.pessoa.endereco.cep
                                }
                              },
                            'cargo': {
                                'id': $scope.funcionario.cargo.id}                             
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Inserido com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/funcionarios').search({});

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
                        url: $rootScope.api + '/funcionarios/deletar', 
                        dataType: 'json', 
                        method:'POST',
                        headers: {'token': token,'Content-Type': 'application/json'},
                        data: { 
                            'id': $scope.funcionario.id
                        }
                    }).success(function (response) {                        
                        console.log(response);
                        $mdToast.show(
                            $mdToast.simple()
                                .content("Excluído com sucesso!")
                                .hideDelay(3000)
                        );
                        $location.path('/administracao/cadastros/funcionarios').search({});
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
                            'pessoaId': $scope.funcionario.pessoa.id
                        }
                    }).success(function (response) {    
                        $scope.campoTelefone = "";                   
                        let id2 = response.id;
                        let telefone2 = response.telefone;
                        $scope.telefones = [{'id': id2, 'pessoaId': $scope.funcionario.pessoa.id, 'telefone': telefone2}];
                        console.log(id2, $scope.funcionario.pessoa.id, telefone2);
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
                            'pessoaId': $scope.funcionario.pessoa.id
                        }
                    }).success(function (response) {
                        $scope.campoEmail = "";                       
                        let id2 = response.id;
                        let email2 = response.email;
                        $scope.emails = [{'id': id2, 'pessoaId': $scope.funcionario.pessoa.id, 'email': email2}];
                        console.log(id2, $scope.funcionario.pessoa.id, email2);
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
