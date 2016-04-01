#!/usr/bin/env ruby

class Foo
  attr :member

  def initialize(member)
    @member = member
    bar()
  end

  def foo
    puts @member
    bar()
  end

  def foo2
    puts 'foo2 called'
  end

  def bar
    puts 'private ' + @member
    puts 'member = ' + self.member
    foo2()
    self.foo2()
  end
  private :bar

  def self.baz
    bar()
  end
end

foo = Foo.new('hoo')
p foo.to_s
foo.foo

Foo.baz
