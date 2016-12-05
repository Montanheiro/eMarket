    angular.module('spa').controller('MenuItemsCtrl', function($scope) {
                            //{name:'exemple', link:'http://exemple.com or #/exemple', icon:'assets-cache.js name'},
        $scope.MenuItems = [{name:'Início', link:'#/', icon:'ic_chevron_right_24px'},
                            {name:'Administração', link:'#/administracao', icon:'vendas'},
                            {name:'Estoque', link:'#/estoque', icon:'compras'},
                            {name:'Financeiro', link:'#/financeiro', icon:'ic_attach_money_24px'},
                            {name:'Vendas', link:'#/vendas', icon:'vendas'}]
                            //{name:'Estoque', link:'#/estoque', icon:'favorite'}]
    }); 
