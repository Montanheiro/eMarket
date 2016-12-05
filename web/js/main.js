(function(){

    let main = angular.module('spa', ['iconesSVG','ngRoute','ui.utils.masks']);

    angular.module('spa').config(function($routeProvider){
        $routeProvider
        .when('/', {
            templateUrl: 'includes/home.html',
            controller: 'HomeCtrl'
        })

        //ADMINISTRAÇÃO

        .when('/administracao', {
            templateUrl: 'includes/administracao.html',
            controller: 'administracaoCtrl'
        })
        .when('/administracao/empresa', {
            templateUrl: 'includes/adminEmpresa.html',
            controller: 'adminEmpresaCtrl'
        })
        //cadastros
        .when('/administracao/cadastros/funcionarios', {
            templateUrl: 'includes/adminFuncionarios.html',
            controller: 'adminFuncionariosCtrl'
        })
        .when('/administracao/cadastros/funcionarios/inserir', {
            templateUrl: 'includes/adminFuncionariosDados.html',
            controller: 'adminFuncionariosInserirCtrl'
        })
        .when('/administracao/cadastros/funcionarios/editar', {
            templateUrl: 'includes/adminFuncionariosDados.html',
            controller: 'adminFuncionariosEditarCtrl'
        })

        .when('/administracao/cadastros/usuarios', {
            templateUrl: 'includes/adminUsuarios.html',
            controller: 'adminUsuariosCtrl'
        })
        .when('/administracao/cadastros/usuarios/inserir', {
            templateUrl: 'includes/adminUsuariosDados.html',
            controller: 'adminUsuariosInserirCtrl'
        })
        .when('/administracao/cadastros/usuarios/editar', {
            templateUrl: 'includes/adminUsuariosDados.html',
            controller: 'adminUsuariosEditarCtrl'
        })
        
        .when('/administracao/cadastros/cargos', {
            templateUrl: 'includes/adminCargos.html',
            controller: 'adminCargosCtrl'
        })
        .when('/administracao/cadastros/cargos/inserir', {
            templateUrl: 'includes/adminCargosDados.html',
            controller: 'adminCargosInserirCtrl'
        })
        .when('/administracao/cadastros/cargos/editar', {
            templateUrl: 'includes/adminCargosDados.html',
            controller: 'adminCargosEditarCtrl'
        })
        
        .when('/administracao/cadastros/permissoes', {
            templateUrl: 'includes/adminPermissoes.html',
            controller: 'adminPermissoesCtrl'
        })
        .when('/administracao/cadastros/permissoes/inserir', {
            templateUrl: 'includes/adminPermissoesDados.html',
            controller: 'adminPermissoesInserirCtrl'
        })
        .when('/administracao/cadastros/permissoes/editar', {
            templateUrl: 'includes/adminPermissoesDados.html',
            controller: 'adminPermissoesEditarCtrl'
        })
        //relatorios
        .when('/administracao/relatorios/acesso', {
            templateUrl: 'includes/adminRelAcesso.html',
            controller: 'adminRelatorioAcessoCtrl'
        })
        .when('/administracao/relatorios/funcionarios', {
            templateUrl: 'includes/adminRelFuncionarios.html',
            controller: 'adminRelatorioFuncionariosCtrl'
        })
        
        //CONFIGURAÇÃO

        .when('/configuration', {
            templateUrl: 'includes/configuration.html',
            controller: 'ConfigurationCtrl'
        })

        //ESTOQUE

        .when('/estoque', {
            templateUrl: 'includes/estoque.html',
            controller: 'estoqueCtrl'
        })

        .when('/estoque/atual', {
            templateUrl: 'includes/estoqAtual.html',
            controller: 'estoqAtualCtrl'
        })
        .when('/estoque/compras', {
            templateUrl: 'includes/estoqCompras.html',
            controller: 'estoqComprasCtrl'
        })
        //cadastros
        .when('/estoque/cadastros/produtos', {
            templateUrl: 'includes/estoqProdutos.html',
            controller: 'estoqProdutosCtrl'
        })
        .when('/estoque/cadastros/produtos/inserir', {
            templateUrl: 'includes/estoqProdutosDados.html',
            controller: 'estoqProdutosInserirCtrl'
        })
        .when('/estoque/cadastros/produtos/editar', {
            templateUrl: 'includes/estoqProdutosDados.html',
            controller: 'estoqProdutosEditarCtrl'
        })

        .when('/estoque/cadastros/fornecedores', {
            templateUrl: 'includes/estoqFornecedores.html',
            controller: 'estoqFornecedoresCtrl'
        })
        .when('/estoque/cadastros/fornecedores/inserir', {
            templateUrl: 'includes/estoqFornecedoresDados.html',
            controller: 'estoqFornecedoresInserirCtrl'
        })
        .when('/estoque/cadastros/fornecedores/editar', {
            templateUrl: 'includes/estoqFornecedoresDados.html',
            controller: 'estoqFornecedoresEditarCtrl'
        })
        //relatorios
        .when('/estoque/relatorios/compras', {
            templateUrl: 'includes/estoqRelCompras.html',
            controller: 'estoqRelComprasEditarCtrl'
        })
        .when('/estoque/relatorios/itenscompra', {
            templateUrl: 'includes/estoqRelIntensCompra.html',
            controller: 'estoqRelIntensCompraCtrl'
        })
        .when('/estoque/relatorios/estoque', {
            templateUrl: 'includes/estoqRelEstoque.html',
            controller: 'estoqRelEstoqueCtrl'
        })
        .when('/estoque/relatorios/estoqueminimo', {
            templateUrl: 'includes/estoqRelEstoqueMinimo.html',
            controller: 'estoqRelEstoqueMinimoCtrl'
        })

        //FINANCEIRO

        .when('/financeiro', {
            templateUrl: 'includes/financeiro.html',
            controller: 'financeiroCtrl'
        })
        .when('/financeiro/contaspagar', {
            templateUrl: 'includes/finanContasPagar.html',
            controller: 'finanContasPagarCtrl'
        })
        .when('/financeiro/contasreceber', {
            templateUrl: 'includes/finanContasReceber.html',
            controller: 'finanContasReceberCtrl'
        })
        //cadastros
        .when('/financeiro/cadastros/formaspagamento', {
            templateUrl: 'includes/finanFormasPagamento.html',
            controller: 'finanFormasPagamentoCtrl'
        })
        .when('/financeiro/cadastros/formaspagamento/inserir', {
            templateUrl: 'includes/finanFormasPagamentoDados.html',
            controller: 'finanFormasPagamentoInserirCtrl'
        })
        .when('/financeiro/cadastros/formaspagamento/editar', {
            templateUrl: 'includes/estoqFormasPagamentoDados.html',
            controller: 'finanFormasPagamentoEditarCtrl'
        })
        //relatorios
        .when('/financeiro/relatorios/movimentacao', {
            templateUrl: 'includes/finanRelMovimentacao.html',
            controller: 'finanRelMovimentacaoCtrl'
        })
        .when('/financeiro/relatorios/contaspagar', {
            templateUrl: 'includes/finanRelContasPagar.html',
            controller: 'finanRelContasPagarCtrl'
        })
        .when('/financeiro/relatorios/contasreceber', {
            templateUrl: 'includes/finanRelContasReceber.html',
            controller: 'finanRelContasReceberCtrl'
        })

        //VENDAS

        .when('/vendas', {
            templateUrl: 'includes/vendas.html',
            controller: 'vendasCtrl'
        })
        .when('/vendas/resumopdv', {
            templateUrl: 'includes/vendResumoPdv.html',
            controller: 'vendResumoPdvCtrl'
        })
        //cadastros
        .when('/vendas/cadastros/promocoes', {
            templateUrl: 'includes/vendPromocoes.html',
            controller: 'vendPromocoesCtrl'
        })
        .when('/vendas/cadastros/promocoes/inserir', {
            templateUrl: 'includes/vendPromocoesDados.html',
            controller: 'vendPromocoesInserirCtrl'
        })
        .when('/vendas/cadastros/promocoes/editar', {
            templateUrl: 'includes/vendPromocoesDados.html',
            controller: 'vendPromocoesEditarCtrl'
        })
        
        .when('/vendas/cadastros/produtos', {
            templateUrl: 'includes/vendProdutos.html',
            controller: 'vendProdutosCtrl'
        })
        .when('/vendas/cadastros/produtos/inserir', {
            templateUrl: 'includes/vendProdutosDados.html',
            controller: 'vendProdutosInserirCtrl'
        })
        .when('/vendas/cadastros/produtos/editar', {
            templateUrl: 'includes/vendProdutosDados.html',
            controller: 'vendProdutosEditarCtrl'
        })

        .when('/vendas/cadastros/pdvs', {
            templateUrl: 'includes/vendPdvs.html',
            controller: 'vendPdvsCtrl'
        })
        .when('/vendas/cadastros/pdvs/inserir', {
            templateUrl: 'includes/vendPdvsDados.html',
            controller: 'vendPdvsInserirCtrl'
        }) //regra de negócio, não se edita um PDV
        //relatorios
        .when('/vendas/relatorios/vendas', {
            templateUrl: 'includes/vendRelVendas.html',
            controller: 'vendRelVendasCtrl'
        })
        .when('/vendas/relatorios/produtos', {
            templateUrl: 'includes/vendRelProdutos.html',
            controller: 'vendRelProdutosCtrl'
        })
        .when('/vendas/relatorios/itensvenda', {
            templateUrl: 'includes/vendRelItensVenda.html',
            controller: 'vendRelItensVendaCtrl'
        })
        .when('/vendas/relatorios/movimentacao', {
            templateUrl: 'includes/vendRelMovimentacao.html',
            controller: 'vendRelMovimentacaoCtrl'
        })

        //APAGAR
        .when('/modelo', {
            templateUrl: 'includes/modelo.html',
            controller: 'modeloCtrl'
        })

        .otherwise({ redirectTo: '/'});
    });

    main.controller('mainCtrl', function($rootScope) {

        $rootScope.api = "http://teste.com.br";
    });

})();



