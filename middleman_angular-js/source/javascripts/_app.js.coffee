//= require _angular-1.2.28.min
angular.module("App", []).controller "MainController", [
  "$scope"
  ($scope) ->
    $scope.todos = []
    $scope.newTitle = ""
    $scope.addTodo = ->
      $scope.todos.push
        title: $scope.newTitle
        done: false

      $scope.newTitle = ""
      return
]
