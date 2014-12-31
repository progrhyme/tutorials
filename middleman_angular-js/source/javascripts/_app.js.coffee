//= require _angular-1.2.28.min
angular.module("App", []).controller "MainController", [
  "$scope"
  "$filter"
  ($scope, $filter) ->
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

    where = $filter("filter")
    $scope.$watch "todos", ((todos) ->
      length = todos.length
      $scope.allCount = length
      $scope.doneCount = where(todos, $scope.filter.done).length
      $scope.remainingCount = length - $scope.doneCount
      return
    ), true
]
