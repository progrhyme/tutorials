#!/usr/bin/env ruby

class A
  def self.foo
    p 'foo'
  end
  private_class_method :foo

  def self.bar
    foo
  end

  def hoo
    p self
    p self.class
    p self.class.bar
    p self.class.foo
  end
end

A.bar
A.new.hoo
