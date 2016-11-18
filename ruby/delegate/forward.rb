#!/usr/bin/env ruby

require 'forwardable'

class C
  extend Forwardable
  def_delegator :child, :foo

  def child
    p Child.new
  end

  class Child
    def foo
      p :foo
    end
  end
end

c = C.new
c.foo
c.foo
