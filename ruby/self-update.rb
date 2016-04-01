#!/usr/bin/env ruby

class Foo
  attr :id, :name
  def initialize(id, name)
    @id   = id
    @name = name
    self
  end

  def say
    require 'pp'
    pp self
  end

  def update(id, name)
    @id = id
    @name = name
  end

  #def renew
  #  new()
  #end

  def renew2
    me = initialize(99, 'hana')
    me.say
  end

  def renew3
    Foo.new(3, 'piyo')
  end
end

foo = Foo.new(10, 'taro')
foo.say

#foo2 = foo.renew
foo3 = foo.renew2

foo.update(11, 'hoge')
foo.say

#foo2.say
foo3.say

foo4 = foo.renew3
foo4.say

foo = foo.renew3
foo.say
