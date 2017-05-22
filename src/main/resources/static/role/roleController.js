angular.module('role', [ 'ngRoute', 'ngSanitize', 'ui.bootstrap'])
    .config(function($routeProvider, $httpProvider) {

        $routeProvider.when('/role', {
            templateUrl : 'role/view.html',
            controller : 'roleController',
            activeRoute : 'role'
        });

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    })
    .controller('roleController', function($scope, $route, $http) {

        $scope.$route = $route;

        $scope.$route = $route;
        $scope.alerts = [];

        $scope.addAlert = function(type, msg) {
            $scope.alerts.push({type:type, msg: msg});
        };

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };

        $scope.saveRole = function() {
            var params = $scope.role;
            $http.post('/role/add', params,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).success(function (data) {
                $scope.role = null;
                $scope.roleForm.$setPristine();
                getRoles();
                $scope.addAlert('success', 'Role successfully saved!');
            }).error(function () {

            });
        };

        var getRoles = function() {
            $http.get('/role/all',
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.roles = data;
            }).error(function() {

            });
        };

        getRoles();
    });