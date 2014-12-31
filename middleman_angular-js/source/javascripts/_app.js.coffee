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

    $scope.filter =
      done:
        done: true

      remaining:
        done: false

    $scope.currentFilter = null
    $scope.changeFilter = (filter) ->
      $scope.currentFilter = filter
      return
]
