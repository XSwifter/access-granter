angular.module('permission', [ 'ngRoute' ])
    .config(function($routeProvider, $httpProvider) {

        $routeProvider.when('/permission', {
            templateUrl : 'permission/view.html',
            controller : 'permissionController',
            activeRoute : 'permission'
        });

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    })
    .controller('permissionController', function($scope, $route, $http) {

        $scope.$route = $route;
        $scope.alerts = [];

        $scope.addAlert = function(type, msg) {
            $scope.alerts.push({type:type, msg: msg});
        };

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };

        $scope.savePermission = function() {
            var params = $scope.permission;
            $http.post('/permission/add', params,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).success(function (data) {
                $scope.permission = null;
                $scope.permissionForm.$setPristine();
                getPermissions();
                $scope.addAlert('success', 'Permission successfully saved!');
            }).error(function () {

            });
        };

        var getPermissions = function() {
            $http.get('/permission/all',
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.permissions = data;
            }).error(function() {

            });
        };

        getPermissions();
    });