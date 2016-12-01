var czu = angular.module("czu", ["ngRoute", "ngMask", "ngMaterial", "ngMessages"]);
czu.config(function($routeProvider) {
    $routeProvider.when("/", {
        templateUrl: "includes/landing.html",
        controller: "LandingCtrl"
    }).when("/login", {
        templateUrl: "includes/login.html",
        controller: "LoginCtrl"
    }).when("/register", {
        templateUrl: "includes/register.html",
        controller: "RegisterCtrl"
    }).otherwise({
        redirectTo: "/"
    })
}), czu.controller("mainCtrl", function($rootScope) {
    $rootScope.domain = "http://api.cardapio01.com.br"
});
angular.module("czu").controller("DialogCtrl", function($scope, $mdDialog, $mdMedia) {
    $scope.status = "  ", $scope.customFullscreen = $mdMedia("xs") || $mdMedia("sm"), $scope.showAdvanced = function(ev) {
        var useFullScreen = ($mdMedia("sm") || $mdMedia("xs")) && $scope.customFullscreen;
        $mdDialog.show({
            controller: function($scope, $mdDialog) {
                $scope.hide = function() {
                    $mdDialog.hide()
                }, $scope.cancel = function() {
                    $mdDialog.cancel()
                }, $scope.answer = function(answer) {
                    $mdDialog.hide(answer)
                }
            },
            templateUrl: "./includes/dialog/" + ev + ".html",
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: !0,
            fullscreen: useFullScreen
        }), $scope.$watch(function() {
            return $mdMedia("xs") || $mdMedia("sm")
        }, function(wantsFullScreen) {
            $scope.customFullscreen = wantsFullScreen === !0
        })
    }
});
angular.module("czu").controller("LandingCtrl", function($scope, $log, $http, $location, $rootScope, $timeout) {
    $scope.cadastrar = function() {
        $location.path("/register")
    }, $scope.sendEmail = function() {
        console.log($scope.formEmail), $http({
            url: $rootScope.domain + "/contact",
            dataType: "json",
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                name: $scope.formEmail.nome,
                email: $scope.formEmail.email,
                subject: $scope.formEmail.assunto,
                message: $scope.formEmail.mensagem
            }
        }).success(function(response) {
            console.log(response.msg), $scope.alertSnack("E-mail enviado com sucesso!"), $scope.formEmail.nome = " ", $scope.formEmail.email = " ", $scope.formEmail.assunto = " ", $scope.formEmail.mensagem = " "
        }).error(function(response) {
            $scope.alertSnack("Tente novamente mais tarde")
        })
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 5e3)
    }
});
angular.module("czu").controller("LoginCtrl", function($scope, $rootScope, $http, $timeout) {
    $scope.isLogado = function() {
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token && $http({
            url: $rootScope.domain + "/tokenVerify",
            dataType: "json",
            method: "GET",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            }
        }).success(function(response) {
            window.location = "/administracao/#/"
        }).error(function(response) {
            console.log("aqui" + response)
        })
    }, $scope.login = function() {
        $scope.login.error = "";
        var email = $scope.usuario.email,
            senha = $scope.usuario.senha,
            manterLogado = $scope.usuario.manterLogado;
        $http({
            url: $rootScope.domain + "/login",
            dataType: "json",
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                email: email,
                password: senha
            }
        }).success(function(response) {
            manterLogado ? localStorage.setItem("user_session", response.token) : sessionStorage.setItem("user_session", response.token), window.location = "/administracao/#/"
        }).error(function(response) {
            $scope.login.error = "O e-mail ou a senha inseridos nÃ£o coicidem."
        })
    }, $scope.recuperarSenha = function() {
        var email = $scope.recuperarEmail.email;
        $http({
            url: $rootScope.domain + "/recuperarSenha",
            dataType: "json",
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                email: email
            }
        }).success(function(response) {
            document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
                document.getElementById("snackbar-location").classList.remove("display-block")
            }, 4e3)
        })
    }
});
angular.module("czu").controller("RegisterCtrl", function($scope, $rootScope, $http, $timeout) {
    $scope.registerValid = !1, $scope.registerValidCorporateName = !1, $scope.registerValidEmail = !1, $scope.registerValidCPNJ = !1, $scope.isLogado = function() {
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token && $http({
            url: $rootScope.domain + "/tokenVerify",
            dataType: "json",
            method: "GET",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            }
        }).success(function(response) {
            window.location = "/administracao/#/"
        }).error(function(response) {
            console.log(response)
        })
    }, $scope.registar = function() {
        $scope.usuarioRegister.error = "", $scope.usuarioRegister.mensagem = "";
        var corporateName = $scope.usuarioRegister.corporateName,
            fantasyName = $scope.usuarioRegister.fantasyName,
            email = $scope.usuarioRegister.email,
            cnpj = $scope.usuarioRegister.cnpj,
            senha = $scope.usuarioRegister.senha,
            senhaRedigitada = $scope.usuarioRegister.senhaRedigitada;
        console.log(corporateName), console.log(fantasyName), console.log(senha), console.log(email), console.log(cnpj), senha == senhaRedigitada ? $http({
            url: $rootScope.domain + "/signup",
            dataType: "json",
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                corporateName: corporateName,
                fantasyName: fantasyName,
                password: senha,
                email: email,
                cnpj: cnpj
            }
        }).success(function(response) {
            document.getElementById("snackbar-location").classList.add("display-block"), $scope.usuarioRegister.mensagem = "UsuÃ¡rio cadastrado com sucesso, redirecionando.", $timeout(function() {
                document.getElementById("snackbar-location").classList.remove("display-block"), $http({
                    url: $rootScope.domain + "/login",
                    dataType: "json",
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    data: {
                        email: email,
                        password: senha
                    }
                }).success(function(response) {
                    sessionStorage.setItem("user_session", response.token), window.location = "/administracao/#/"
                }).error(function(response) {
                    window.location = "/login"
                })
            }, 4e3)
        }).error(function(response) {
            $scope.usuarioRegister.error = response.msg
        }) : $scope.usuarioRegister.error = "As senhas digitadas nÃ£o conhecidem"
    }, $scope.testUniq = function(campo, value) {
        console.log("Testando UNIQ " + campo + ": " + value), void 0 !== value && $http({
            url: $rootScope.domain + "/company/fieldVerify",
            dataType: "json",
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            data: {
                fieldName: campo,
                fieldValue: value
            }
        }).success(function(response) {
            response.success === !1 ? $scope.erroUniq(campo, response.msg) : ($scope.validUniq(campo), $scope.validateRegister())
        }).error(function(response) {
            console("NÃ£o consegiu contato com o servidor"), $scope.testUniq(campo, value)
        })
    }, $scope.erroUniq = function(campo, err) {
        switch (campo) {
            case "corporateName":
                $scope.registerValidCorporateName = !1, $scope.registerValid = !1, $scope.corporateNameErr = err;
                break;
            case "email":
                $scope.registerValidEmail = !1, $scope.registerValid = !1, $scope.emailErr = err;
                break;
            case "cnpj":
                $scope.registerValidCPNJ = !1, $scope.registerValid = !1, $scope.cnpjErr = err;
                break;
            default:
                return 0
        }
    }, $scope.validUniq = function(campo) {
        switch (console.log("campo valido"), campo) {
            case "corporateName":
                $scope.registerValidCorporateName = !0, $scope.corporateNameErr = null;
                break;
            case "email":
                $scope.registerValidEmail = !0, $scope.emailErr = null;
                break;
            case "cnpj":
                $scope.registerValidCPNJ = !0, $scope.cnpjErr = null;
                break;
            default:
                return 0
        }
    }, $scope.validateRegister = function() {
        $scope.registerValidCorporateName && $scope.registerValidEmail && $scope.registerValidCPNJ ? $scope.registerValid = !0 : $scope.registerValid = !1
    }
});
var admin = angular.module("admin", ["ngRoute", "ngMaterial", "ngMessages", "angular-sortable-view", "ngImgCrop", "ngMask"]);
admin.config(function($routeProvider) {
    $routeProvider.when("/", {
        templateUrl: "includes/empresa.html",
        controller: "EmpresaCtrl"
    }).when("/conta", {
        templateUrl: "includes/conta.html",
        controller: "ContaCtrl"
    }).when("/gerenciarcategorias", {
        templateUrl: "includes/gerenciarcategorias.html",
        controller: "GerenciarCategoriasCtrl"
    }).when("/editarcategoria", {
        templateUrl: "includes/editarcategoria.html",
        controller: "EditarCategoriaCtrl"
    }).when("/adicionarcategoria", {
        templateUrl: "includes/adicionarcategoria.html",
        controller: "AdicionarCategoriaCtrl"
    }).when("/itenscategoria", {
        templateUrl: "includes/itenscategoria.html",
        controller: "ItensCategoriaCtrl"
    }).when("/editaritem", {
        templateUrl: "includes/editaritem.html",
        controller: "EditarItemCtrl"
    }).when("/adicionaritem", {
        templateUrl: "includes/adicionaritem.html",
        controller: "AdicionarItemCtrl"
    }).when("/geraretiquetas", {
        templateUrl: "includes/geraretiquetas.html",
        controller: "GerarEtiquetasCtrl"
    }).when("/pagamento", {
        templateUrl: "includes/pagamento.html",
        controller: "PagamentoCtrl"
    }).otherwise({
        redirectTo: "/"
    })
}), admin.controller("mainAdminCtrl", function($rootScope) {
    $rootScope.domain = "http://api.cardapio01.com.br"
});
angular.module("admin").controller("AdicionarCategoriaCtrl", function($scope, $rootScope, $routeParams, $http, $location) {
    $scope.name = "Adicionar Categoria", $scope.adicionarNomeCategoria = function() {
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token ? $http({
            url: $rootScope.domain + "/category/new",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                name: $scope.editarCategoriaNome
            }
        }).success(function(response) {
            console.log(response.msg), $location.path("/gerenciarcategorias")
        }).error(function(response) {
            console.log(response.msg)
        }) : window.location = "/#/login"
    }, $scope.cancelar = function() {
        $location.path("/gerenciarcategorias")
    }
});
angular.module("admin").controller("AdicionarItemCtrl", function($scope, $rootScope, $timeout, $routeParams, $http, $location) {
    $scope.name = "Adicionar novo item", $scope.editarCategoriaID = $routeParams.id, $scope.prices = [], $scope.adicionarItem = function() {
        console.log("funcionando")
    }, $scope.excluirPreco = function(index, id) {
        $scope.item.prices.splice(index, 1), console.log($scope.item.prices)
    }, $scope.adicionarPreco = function() {
        if (console.log("Adicionando valor : " + $scope.novoPreco), console.log("Adicionando tamanho : " + $scope.novoTamanho), void 0 === $scope.novoTamanho || void 0 === $scope.novoPreco) $scope.alertSnack("Adicione o Unidade e PreÃ§o para o novo item.");
        else {
            var novoPreco = {
                price: $scope.novoPreco,
                size: $scope.novoTamanho
            };
            $scope.prices.push(novoPreco), console.log($scope.prices)
        }
    }, $scope.adicionarItem = function() {
        console.log($scope.editarCategoriaID), console.log($scope.item.name), console.log($scope.item.description), console.log($scope.prices);
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token ? 0 !== $scope.prices.length ? $http({
            url: $rootScope.domain + "/item/new",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                categoryID: $scope.editarCategoriaID,
                name: $scope.item.name,
                description: $scope.item.description,
                prices: $scope.prices
            }
        }).success(function(response) {
            console.log(response), $location.path("/itenscategoria")
        }).error(function(response) {
            $scope.alertSnack(response.msg)
        }) : $scope.alertSnack("Adicione pelo menos um preÃ§o.") : window.location = "/#/login"
    }, $scope.excluirPreco = function(index) {
        $scope.prices.splice(index, 1), console.log($scope.prices)
    }, $scope.cancelar = function() {
        $location.path("/itenscategoria")
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 4e3)
    }
});
angular.module("admin").controller("ContaCtrl", function($scope, $rootScope, $http, $timeout) {
    $scope.name = "Minha Conta";
    var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
    $scope.changePassword = function() {
        token ? $scope.usuario.senhaNova == $scope.usuario.senhaNovaRe ? $http({
            url: $rootScope.domain + "/company/changePassword",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                newPassword: $scope.usuario.senhaNova,
                oldPassword: $scope.usuario.senhaAtual
            }
        }).success(function(response) {
            $scope.alertSnack(response.msg), localStorage.getItem("user_session") ? localStorage.setItem("user_session", response.token) : sessionStorage.setItem("user_session", response.token)
        }).error(function(response) {
            $scope.usuario.error = response.msg
        }) : $scope.usuario.error = "As senhas nÃ£o conferem, tente novamente." : window.location = "/#/login"
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 4e3)
    }
});
angular.module("admin").controller("EditarCategoriaCtrl", function($scope, $rootScope, $routeParams, $http, $location, $timeout) {
    $scope.name = "Editar Categoria", $scope.editarCategoriaID = $routeParams.id, $scope.editarCategoriaNome = $routeParams.name, $rootScope.mensagemSnack = " ", $scope.editarNomeCategoria = function() {
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token ? $http({
            url: $rootScope.domain + "/category/edit",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                categoryID: $scope.editarCategoriaID,
                name: $scope.editarCategoriaNome
            }
        }).success(function(response) {
            console.log(response.msg), $scope.limparParametros(), $location.path("/gerenciarcategorias")
        }).error(function(response) {
            console.log(response.msg)
        }) : window.location = "/#/login"
    }, $scope.excluirCategoria = function() {
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token ? $http({
            url: $rootScope.domain + "/category/remove",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                categoryID: $scope.editarCategoriaID
            }
        }).success(function(response) {
            console.log(response.msg), $scope.limparParametros(), $location.path("/gerenciarcategorias")
        }).error(function(response) {
            console.log(response.msg.valueOf()), "Token invÃ¡lido!" == response.msg ? (mensagemSnack = "Realize o Login novamnete para fazer a ediÃ§Ã£o", $scope.alertSnack(mensagemSnack), localStorage.removeItem("user_session"), sessionStorage.removeItem("user_session"), $timeout(function() {
                window.location = "/#/login"
            }, 4e3)) : $scope.alertSnack(response.msg)
        }) : window.location = "/#/login"
    }, $scope.cancelar = function() {
        $scope.limparParametros(), $location.path("/gerenciarcategorias")
    }, $scope.limparParametros = function() {
        $location.search("id", null), $location.search("name", null)
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 4e3)
    }
});
angular.module("admin").controller("EditarItemCtrl", function($scope, $rootScope, $http, $location, $timeout) {
    $scope.item = $rootScope.itemEditar, $scope.name = "Alterar item", $scope.item || $location.path("/gerenciarcategorias"), $scope.excluirPreco = function(index, id) {
        $scope.item.prices.splice(index, 1), console.log($scope.item.prices)
    }, $scope.adicionarPreco = function() {
        if (console.log("Adicionando valor : " + $scope.novoPreco), console.log("Adicionando tamanho : " + $scope.novoTamanho), void 0 === $scope.novoTamanho || void 0 === $scope.novoPreco) $scope.alertSnack("Adicione o Unidade e PreÃ§o para o novo item.");
        else {
            var novoPreco = {
                price: $scope.novoPreco,
                size: $scope.novoTamanho
            };
            $scope.item.prices.push(novoPreco), console.log($scope.item.prices)
        }
    }, $scope.alterarItem = function() {
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token ? (console.log($scope.item.prices.length), 0 !== $scope.item.prices.length ? $http({
            url: $rootScope.domain + "/item/edit",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                itemID: $scope.item._id,
                name: $scope.item.name,
                description: $scope.item.description,
                prices: $scope.item.prices
            }
        }).success(function(response) {
            console.log(response.msg), $location.path("/itenscategoria")
        }).error(function(response) {
            $scope.alertSnack(response.msg)
        }) : $scope.alertSnack("Adicione pelo menos um preÃ§o.")) : window.location = "/#/login"
    }, $scope.excluirItem = function() {
        var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
        token ? $http({
            url: $rootScope.domain + "/item/remove",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                itemID: $scope.item._id
            }
        }).success(function(response) {
            console.log(response), $location.path("/itenscategoria")
        }).error(function(response) {
            $scope.alertSnack(response.msg)
        }) : window.location = "/#/login"
    }, $scope.cancelar = function() {
        $location.path("/itenscategoria")
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 4e3)
    }
});
angular.module("admin").controller("EmpresaCtrl", function($scope, $rootScope, $http, $timeout, $route) {
    $scope.name = "Minha Empresa", $scope.company = " ", $scope.imagen = "view", $scope.informacao = "view", $scope.enviando = !1;
    var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
    $scope.myImageLogo = "", $scope.myImageBanner = "", $scope.myCroppedImageLogo = "", $scope.myCroppedImageBanner = "";
    var handleFileSelectLogo = function(a) {
            var b = a.currentTarget.files[0],
                c = new FileReader;
            c.onload = function(a) {
                $scope.$apply(function(b) {
                    b.myImageLogo = a.target.result
                })
            }, c.readAsDataURL(b)
        },
        handleFileSelectBaner = function(a) {
            var b = a.currentTarget.files[0],
                c = new FileReader;
            c.onload = function(a) {
                $scope.$apply(function(b) {
                    b.myImageBanner = a.target.result
                })
            }, c.readAsDataURL(b)
        };
    angular.element(document.querySelector("#fileInputLogo")).on("change", handleFileSelectLogo), angular.element(document.querySelector("#fileInputBanner")).on("change", handleFileSelectBaner), $scope.alterarLogo = function() {
        $scope.enviando = !1, $scope.imagen = "alterarLogo"
    }, $scope.alterarBanner = function() {
        $scope.enviando = !1, $scope.imagen = "alterarBanner"
    }, $scope.salvarLogo = function() {
        $scope.enviando = !0, token ? $http({
            url: $rootScope.domain + "/company/uploadLogo",
            method: "POST",
            headers: {
                "x-access-token": token
            },
            data: {
                image: $scope.myCroppedImageLogo
            }
        }).success(function(response) {
            console.log(response), $timeout(function() {
                console.log("teste"), location.reload()
            }, 2e3)
        }).error(function(response) {
            $scope.alertSnack("Falha ao enviar, tente novamente."), $scope.enviando = !1
        }) : window.location = "/#/login"
    }, $scope.salvarBanner = function() {
        $scope.enviando = !0, token ? $http({
            url: $rootScope.domain + "/company/uploadBanner",
            method: "POST",
            headers: {
                "x-access-token": token
            },
            data: {
                image: $scope.myCroppedImageBanner
            }
        }).success(function(response) {
            console.log(response), $timeout(function() {
                console.log("teste"), location.reload()
            }, 2e3)
        }).error(function(response) {
            $scope.enviando = !1, $scope.alertSnack("Falha ao enviar, tente novamente.")
        }) : window.location = "/#/login"
    }, $scope.cancelarImage = function() {
        $scope.imagen = "view"
    }, $scope.cancelarInfo = function() {
        $scope.informacao = "view"
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 4e3)
    }, $scope.findCompany = function() {
        token ? (console.log(token), $http({
            url: $rootScope.domain + "/company/get",
            dataType: "json",
            method: "GET",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            }
        }).success(function(response) {
            $scope.company = response.company, console.log($scope.company)
        }).error(function(response) {
            console.log(response)
        })) : window.location = "/#/login"
    }, $scope.alterarInformacoes = function() {
        $scope.informacao = "editInformacao"
    }, $scope.salvarInformacoes = function() {
        $scope.enviando = !0, console.log($scope.company.name + " - " + $scope.company.email + " - " + $scope.company.cnpj + " - " + $scope.company.phone), console.log($scope.address), console.log($scope.social), token ? $http({
            url: $rootScope.domain + "/company/edit",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                corporateName: $scope.company.corporateName,
                fantasyName: $scope.company.fantasyName,
                email: $scope.company.email,
                cpnj: $scope.company.cnpj,
                phone: $scope.company.phone,
                address: $scope.company.address,
                social: $scope.company.social
            }
        }).success(function(response) {
            $scope.enviando = !1, $scope.informacao = "view"
        }).error(function(response) {
            console.log(response), $scope.enviando = !1, $scope.alertSnack("Tente novamente.")
        }) : window.location = "/#/login"
    }
});
angular.module("admin").controller("GerarEtiquetasCtrl", function($scope, $rootScope, $http, $timeout, $window) {
    $scope.name = "Etiquetas";
    var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
    $scope.getTag = function() {
        token ? void 0 === $rootScope.urlEtiquetas && $http({
            url: $rootScope.domain + "/tags/get",
            dataType: "json",
            method: "GET",
            headers: {
                "x-access-token": token
            }
        }).success(function(response) {
            console.log($rootScope.urlEtiquetas), console.log(response), $rootScope.urlEtiquetas = response.url
        }).error(function(response) {
            $scope.alertSnack("Tente novamente.")
        }) : window.location = "/#/login"
    }, $scope.generateTag = function() {
        token ? $http({
            url: $rootScope.domain + "/tags/generate",
            dataType: "json",
            method: "GET",
            headers: {
                "x-access-token": token
            }
        }).success(function(response) {
            console.log($rootScope.urlEtiquetas), console.log(response), $rootScope.urlEtiquetas = response.url, document.getElementById("abrirEtiquetas").remove(), document.getElementById("gerarEtiquetas").remove(), document.getElementById("bntGerarEtiquetas").classList.remove("display-none")
        }).error(function(response) {
            $scope.alertSnack("Tente novamente.")
        }) : window.location = "/#/login"
    }, $scope.openEtiqueta = function() {
        console.log($rootScope.urlEtiquetas), $window.open($rootScope.urlEtiquetas)
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 4e3)
    }
});
angular.module("admin").controller("GerenciarCategoriasCtrl", function($scope, $rootScope, $mdDialog, $mdMedia, $http, $location) {
    $scope.name = "Gerenciar Categorias";
    var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
    $scope.findAllByCompany = function() {
        $scope.loading = !1, token ? (console.log(token), $http({
            url: $rootScope.domain + "/category/findAllByCompany",
            dataType: "json",
            method: "GET",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            }
        }).success(function(response) {
            $rootScope.categorias = response.categories, console.log($scope.categorias), $scope.loading = !0
        }).error(function(response) {
            response.success || (window.location = "/#/login"), console.log("Erro ao buscar todas as categorias"), $scope.findAllByCompany()
        })) : window.location = "/#/login"
    }, $scope.changeStatus = function(id, status) {
        token ? $http({
            url: $rootScope.domain + "/category/changeStatus",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                categoryID: id,
                status: status
            }
        }).success(function(response) {
            console.log(id + ": " + response.msg)
        }).error(function(response) {
            console.log("Erro ao mudar status")
        }) : window.location = "/#/login"
    }, $scope.editarCategoria = function(id, name) {
        $location.path("/editarcategoria").search({
            id: id,
            name: name
        })
    }, $scope.adicionarCategoria = function() {
        $location.path("/adicionarcategoria")
    }, $scope.shortChange = function(item, indexFrom, indexTo) {
        console.log("name: " + item.name), console.log("name: " + item._id), console.log("indexFrom: " + indexFrom), console.log("indexTo: " + indexTo), token ? $http({
            url: $rootScope.domain + "/category/changePosition",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                categoryID: item._id,
                oldIndex: indexFrom,
                newIndex: indexTo
            }
        }).success(function(response) {
            console.log(item._id + ": " + response.msg)
        }).error(function(response) {
            console.log("Erro ao mudar a podiÃ§Ã£o")
        }) : window.location = "/#/login"
    }, $scope.listarItensCategoria = function(id, name) {
        $location.path("/itenscategoria").search({
            id: id,
            name: name
        })
    }
}), angular.module("admin").directive("stopEvent", function() {
    return {
        restrict: "A",
        link: function(scope, element, attr) {
            attr && attr.stopEvent && element.bind(attr.stopEvent, function(e) {
                e.stopPropagation()
            })
        }
    }
});
angular.module("admin").controller("InicioCtrl", function($scope) {
    $scope.name = "InÃ­cio"
});
angular.module("admin").controller("ItensCategoriaCtrl", function($scope, $rootScope, $http, $routeParams, $location) {
    $scope.name = $routeParams.name, $scope.categoriaID = $routeParams.id;
    var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
    $scope.findAllItensByCategory = function() {
        $scope.loading = !1, token ? (console.log(token), $http({
            url: $rootScope.domain + "/item/findAllByCategory",
            dataType: "json",
            method: "GET",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            params: {
                categoryID: $scope.categoriaID
            }
        }).success(function(response) {
            $scope.items = response.items, $scope.loading = !0, console.log(response.items)
        }).error(function(response) {
            response.success || (window.location = "/#/login"), $scope.findAllItensByCategory()
        })) : window.location = "/#/login"
    }, $scope.changeStatusItem = function(id, status) {
        console.log("Change Item: " + id + " - " + status), token ? $http({
            url: $rootScope.domain + "/item/changeStatus",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                itemID: id,
                status: status
            }
        }).success(function(response) {
            console.log(id + ": " + response.msg)
        }).error(function(response) {
            console.log("Erro ao mudar status")
        }) : window.location = "/#/login"
    }, $scope.editarItem = function(item) {
        $rootScope.itemEditar = item, $location.path("/editaritem")
    }, $scope.adicionarItem = function() {
        $location.path("/adicionaritem")
    }, $scope.shortChange = function(item, indexFrom, indexTo) {
        console.log("name: " + item.name), console.log("name: " + item._id), console.log("indexFrom: " + indexFrom), console.log("indexTo: " + indexTo), token ? $http({
            url: $rootScope.domain + "/item/changePosition",
            dataType: "json",
            method: "POST",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            },
            data: {
                categoryID: $scope.categoriaID,
                itemID: item._id,
                oldIndex: indexFrom,
                newIndex: indexTo
            }
        }).success(function(response) {
            console.log(item._id + ": " + response.msg)
        }).error(function(response) {
            console.log("Erro ao mudar a podiÃ§Ã£o")
        }) : window.location = "/#/login"
    }, $scope.returnCategorias = function() {
        $location.path("/gerenciarcategorias")
    }
});
angular.module("admin").controller("MainCtrl", function($scope, $timeout, $mdSidenav, $mdUtil, $http) {
    function buildToggler(navID) {
        var debounceFn = $mdUtil.debounce(function() {
            $mdSidenav(navID).toggle()
        }, 300);
        return debounceFn
    }
    $scope.toggleLeft = buildToggler("left")
});
angular.module("admin").controller("MenuCtrl", function($scope, $location) {
    $scope.menus = [{
        name: "Minha Empresa",
        link: "#/",
        icon: "img/icones/ic_business_black_24px.svg"
    }, {
        name: "CardÃ¡pio",
        link: "#/gerenciarcategorias",
        icon: "img/icones/ic_format_list_bulleted_black_24px.svg"
    }, {
        name: "Etiquetas",
        link: "#/geraretiquetas",
        icon: "img/icones/ic_style_black_24px.svg"
    }, {
        name: "Pagamento",
        link: "#/pagamento",
        icon: "img/icones/ic_payment_white_24px.svg"
    }, {
        name: "Conta",
        link: "#/conta",
        icon: "img/icones/ic_account_circle_black_24px.svg"
    }], $scope.logoff = function() {
        localStorage.removeItem("user_session"), sessionStorage.removeItem("user_session"), window.location = "/#/"
    }
});
angular.module("admin").controller("PagamentoCtrl", function($scope, $rootScope, $http, $window, $timeout) {
    $scope.name = "Pagamento";
    var token = sessionStorage.getItem("user_session") || localStorage.getItem("user_session");
    $scope.assinatura = function() {
        token ? $http({
            url: $rootScope.domain + "/pagseguro/subscription",
            method: "GET",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            }
        }).success(function(response) {
            console.log(response), $scope.reqAssinatura = !0, response.success === !0 ? ($scope.isAssinado = !1, $scope.linkPagueSeguro = response.url) : $scope.isAssinado = !0
        }).error(function(response) {
            console.log(response), $scope.assinatura()
        }) : window.location = "/#/login"
    }, $scope.pay = function() {
        console.log("Abrindo PagueSeguro"), $window.open($scope.linkPagueSeguro)
    }, $scope.cancelarAssinatura = function() {
        $scope.confirmCancel = !0
    }, $scope.notConfirmCancel = function() {
        $scope.confirmCancel = !1
    }, $scope.cancelarAssinaturaConfirmed = function() {
        token ? $http({
            url: $rootScope.domain + "/pagseguro/cancel",
            method: "GET",
            headers: {
                "x-access-token": token,
                "Content-Type": "application/json"
            }
        }).success(function(response) {
            $scope.assinatura(), $scope.confirmCancel = !1, $scope.isAssinado = !1, console.log(response), $scope.alertSnack(response.msg)
        }).error(function(response) {
            console.log(response), $scope.alertSnack(response.msg)
        }) : window.location = "/#/login"
    }, $scope.alertSnack = function(msg) {
        $rootScope.mensagemSnack = msg, document.getElementById("snackbar-location").classList.add("display-block"), $timeout(function() {
            document.getElementById("snackbar-location").classList.remove("display-block"), $rootScope.mensagemSnack = " "
        }, 5e3)
    }
});