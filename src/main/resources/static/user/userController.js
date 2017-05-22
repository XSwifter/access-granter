angular.module('user', [ 'ngRoute', 'ngSanitize', 'ui.bootstrap' ])
    .config(function($routeProvider, $httpProvider) {

        $routeProvider.when('/user', {
            templateUrl : 'user/view.html',
            controller : 'userController',
            activeRoute : 'user'
        }).when('/user/:id', {
            templateUrl : 'user/viewDetails.html',
            controller : 'userController',
            activeRoute : 'userDetails'
        });

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    })
    .controller('userController', function($scope, $route, $http, $routeParams, $location) {

        $scope.$route = $route;
        $scope.alerts = [];

        $scope.addAlert = function(type, msg) {
            $scope.alerts.push({type:type, msg: msg});
        };

        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };

        $scope.saveUser = function() {
            var params = $scope.user;
            $http.post('/user/add', params,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).success(function (data) {
                    $scope.user = null;
                    $scope.userForm.$setPristine();
                    getUsers();
                    $scope.addAlert('success', 'User successfully saved!');
            }).error(function () {

            });
        };

        var getUsers = function() {
            $http.get('/user/all',
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.users = data;
            }).error(function() {

            });
        };

        var getUserDetails = function(id) {
            $http.get('/user/get/'+id,
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.userDetails = data;
            }).error(function() {

            });
        };

        var getActiveRoles = function(id) {
            $http.get('role/all-active/'+id,
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.activeRoles = data;
            }).error(function() {

            });
        };

        var getAvailableRoles = function(id) {
            $http.get('role/all-available/'+id,
                {
                    headers:
                        {
                            'Content-Type': 'application/json'
                        }
                }).success(function(data) {
                $scope.availableRoles = data;
            }).error(function() {

            });
        };

        var getActivePermissions = function(id) {
            $http.get('permission/all-active-user/'+id,
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

        var onLoad = function() {
            if ($route.current.activeRoute == 'user') {
                getUsers();
            } else if ($route.current.activeRoute == 'userDetails'){
                getUserDetails($routeParams.id);
                getActiveRoles($routeParams.id);
                getAvailableRoles($routeParams.id);
                getActivePermissions($routeParams.id);
            }
        };

        onLoad();

        $scope.viewUserDetails = function(id) {
            $location.path('user/'+id);
        };

        $scope.assignRole = function(roleId) {
            var params =  roleId;
            $http.post('/user/add-role/'+$routeParams.id, params,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).success(function (data) {
                onLoad();
                $scope.addAlert('success', 'Role successfully assigned!');
            }).error(function () {

            });
        };

        $scope.unassignRole = function(roleId) {
            $http.post('/user/remove-role/'+$routeParams.id, roleId,
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).success(function (data) {
                onLoad();
                $scope.addAlert('success', 'Role successfully removed!');
            }).error(function () {

            });
        };

    });