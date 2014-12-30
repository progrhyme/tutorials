angular.module("App", []).controller "MainController", [
  "$scope"
  ($scope) ->
    $scope.todos = []
    $scope.addTodo = ->
      $scope.todos.push
        title: Math.random()
        done: false

      return
]
