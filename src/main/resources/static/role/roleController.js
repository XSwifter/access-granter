angular.module('role', [ 'ngRoute', 'ngSanitize', 'ui.bootstrap'])
    .config(function($routeProvider, $httpProvider) {

        $routeProvider.when('/role', {
            templateUrl : 'role/view.html',
            controller : 'roleController',
            activeRoute : 'role'
        }).when('/role/:id', {
            templateUrl : 'role/viewDetails.html',
            controller : 'roleController',
            activeRoute : 'roleDetails'
        });

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    })
    .controller('roleController', function($scope, $route, $http, $routeParams, $location) {

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

        var getRoleDetails = function(id) {
            $http.get('/role/get/'+id,
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.roleDetails = data;
            }).error(function() {

            });
        };

        var getActivePermissions = function(id) {
            $http.get('permission/all-active/'+id,
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.activePermissions = data;
            }).error(function() {

            });
        };

        var getAvailablePermissions = function(id) {
            $http.get('permission/all-available/'+id,
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.availablePermissions = data;
            }).error(function() {

            });
        };

        var onLoad = function() {
            if ($route.current.activeRoute == 'role') {
                getRoles();
            } else if ($route.current.activeRoute == 'roleDetails'){
                getRoleDetails($routeParams.id);
                getActivePermissions($routeParams.id);
                getAvailablePermissions($routeParams.id);
            }
        };

        onLoad();

        $scope.viewRoleDetails = function(id) {
            $location.path('role/'+id);
        };

        $scope.assignPermission = function(permId) {
            var params =  permId;
            $http.post('/role/add-permission/'+$routeParams.id, params,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).success(function (data) {
                onLoad();
                $scope.addAlert('success', 'Permission successfully assigned!');
            }).error(function () {

            });
        };

        $scope.unassignPermission = function(permId) {
            $http.post('/role/remove-permission/'+$routeParams.id, permId,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).success(function (data) {
                onLoad();
                $scope.addAlert('success', 'Permission successfully removed!');
            }).error(function () {

            });
        };
    });