//= require _angular-1.2.28.min
angular.module('App', [])
.service('todos', [
  '$rootScope'
  '$filter'
  ($scope, $filter) ->
    list = []
    $scope.$watch (->
      list
    ), ((value) ->
      $scope.$broadcast 'change:list', value
      return
    ), true
    where = $filter('filter')
    done = done: true
    remaining = done: false
    @filter =
      done: done
      remaining: remaining

    @getDone = ->
      where list, done

    @add = (title) ->
      list.push
        title: title
        done: false

      return

    @remove = (currentTodo) ->
      list = where(list, (todo) ->
        currentTodo isnt todo
      )
      return

    @removeDone = ->
      list = where(list, remaining)
      return

    @changeState = (state) ->
      angular.forEach list, (todo) ->
        todo.done = state
        return

      return
])
.controller('RegisterController', [
  '$scope'
  'todos'
  ($scope, todos) ->
    $scope.newTitle = ''
    $scope.addTodo = ->
      todos.add $scope.newTitle
      $scope.newTitle = ''
      return
])
.controller('ToolbarController', [
  '$scope'
  'todos'
  ($scope, todos) ->
    $scope.filter = todos.filter
    $scope.$on 'change:list', (evt, list) ->
      length = list.length
      doneCount = todos.getDone().length
      $scope.allCount = length
      $scope.doneCount = doneCount
      $scope.remainingCount = length - doneCount
      return

    $scope.checkAll = ->
      todos.changeState !!$scope.remainingCount
      return

    $scope.changeFilter = (filter) ->
      $scope.$emit 'change:filter', filter
      return

    $scope.removeDoneTodo = ->
      todos.removeDone()
      return
])
.controller('TodoListController', [
  '$scope'
  'todos'
  ($scope, todos) ->
    $scope.$on 'change:list', (evt, list) ->
      $scope.todoList = list
      return

    originalTitle = undefined
    $scope.editing = null
    $scope.editTodo = (todo) ->
      originalTitle = todo.title
      $scope.editing = todo
      return

    $scope.doneEdit = (todoForm) ->
      $scope.editing.title = originalTitle  if todoForm.$invalid
      $scope.editing = originalTitle = null
      return

    $scope.removeTodo = (todo) ->
      todos.remove todo
      return
])
.controller('MainController', [
  '$scope'
  ($scope) ->
    $scope.currentFilter = null
    $scope.$on 'change:filter', (evt, filter) ->
      $scope.currentFilter = filter
      return
])
.directive 'mySelect', [->
  (scope, $el, attrs) ->
    scope.$watch attrs.mySelect, (val) ->
      $el[0].select()  if val
      return

    return
]
