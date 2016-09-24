#!/usr/bin/env ruby

class HooksHandler
  def initialize
    @hooks = []
  end

  def register(&hook)
    @hooks << hook
  end

  def do_hooks
    @hooks.each_with_index do |h, i|
      h.call i
    end
  end
end

handler = HooksHandler.new
handler.register do |x|
  p "#{x} 1st hook"
end

handler.register do |x|
  y = x * x
  p "arg: #{x}, gen: #{y}. 2nd hook"
end

handler.do_hooks
