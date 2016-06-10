#!/usr/bin/env ruby

class A
  def self.foo
    p 'foo'
  end

  def self.bar
    p self
    foo
    self.foo
  end
end

A.bar
