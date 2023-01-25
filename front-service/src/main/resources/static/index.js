angular.module('app',['ngStorage']).controller('indexController',function ($scope,$http,$localStorage){

    $scope.tryToAuth = function (){
        $http.post('http://localhost:9600/auth/auth',$scope.user)
            .then(function successCallbake(responce){
                if (responce.data.token){
                    $http.defaults.headers.common.Authorization = 'Bearer ' + responce.data.token;
                    $localStorage.market = {username : $scope.user.username, token: responce.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            },function errorCallbake(response){
            });
    };

    $scope.tryToLogout = function (){
        $scope.clearUser();
        $scope.user = null;
    };

    $scope.clearUser = function () {
        delete $localStorage.marketUser;
        $http.defaults.headers.common.Authorization= '';
    }

    $scope.isUserLoggedIn= function (){
        if ($localStorage.marketUser){
            return true;
        } else {
            return false;
        }
    };

    if ($localStorage.marketUser){
        try {
            let jwt = $localStorage.marketUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime()/1000);
            if (currentTime>payload.exp){
                console.Tag("Token is expired");
                delete $localStorage.marketUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }

        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.marketUser.token;
    }

    $scope.loadProducts = function (){
        $http.get('http://localhost:9000/market-core/api/v1/products/').then(function (responce){
            $scope.productList = responce.data;
        });
    }

    $scope.createOrder = function (){
        $http.get('http://localhost:9000/market-core/api/v1/orders').then(function (responce){
            alert('Заказ оформлен');
        });
    }

    $scope.showProductsInfo = function (productId){
        $http.get('http://localhost:9000/market-core/api/v1/products/' + productId).then(function (responce){
            alert(responce.data.title);
        });
    }

    $scope.removeFromCart = function (productId){
        $http.get('http://localhost:9100/market-cart/api/v1/cart/remove/'+ productId).then(function (responce){
            $scope.loadCart();
        });
    }

    $scope.clearCart = function (){
        $http.get('http://localhost:9100/market-cart/api/v1/cart/clear').then(function (responce){
            $scope.loadCart();
        });
    }

    $scope.addToCart = function (productId){
        $http.get('http://localhost:9100/market-cart/api/v1/cart/add/' + productId).then(function (responce){
            alert("!!!");
            $scope.loadCart();
        });
    }

    $scope.loadCart = function (){
        $http.get('http://localhost:9100/market-cart/api/v1/cart').then(function (responce){
            $scope.cart=responce.data;
        });
    }

    $scope.loadProducts();
    $scope.loadCart();


});