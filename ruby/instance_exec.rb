#!/usr/bin/env ruby

class C
  def initialize(&block)
    @block = block
  end

  def run
    instance_exec(&@block)
  end
end

c = C.new { p :foo }
c.run
