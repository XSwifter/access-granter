angular.module('access_granter', ['ngSanitize', 'ngRoute', 'user', 'role', 'permission', 'ui.bootstrap'])
    .config(function($routeProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl : 'view.html',
            controller : 'homeController',
            activeRoute : 'home'
        });

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    })
    .controller('homeController', function($scope, $route, $location) {

        $scope.$route = $route;

        $scope.changeView = function(path){
            $location.path(path);
        }
    });