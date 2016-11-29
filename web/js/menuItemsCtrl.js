    angular.module('spa').controller('MenuItemsCtrl', function($scope) {
                            //{name:'exemple', link:'http://exemple.com or #/exemple', icon:'assets-cache.js name'},
        $scope.MenuItems = [{name:'Início', link:'#/', icon:'ic_chevron_right_24px'},
                            {name:'Financeiro', link:'#/financeiro', icon:'favorite'}]
                            //{name:'Compras', link:'#/compras', icon:'favorite'},
                            //{name:'Vendas', link:'#/vendas', icon:'favorite'},
                            //{name:'Estoque', link:'#/estoque', icon:'favorite'}]
    }); 
