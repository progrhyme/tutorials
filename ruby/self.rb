#!/usr/bin/env ruby

p "Main #{self}"

class Foo
  p "Class #{self}"

  def initialize
    p "new #{self}"
  end

  def foo
    p "instance method #{self}"
  end
end

foo = Foo.new
foo.foo
