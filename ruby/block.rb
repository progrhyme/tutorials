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

  def run_hooks
    @hooks.each do |h|
      instance_eval(&h)
    end
  end

  module Verbose
    def say(str)
      puts str
    end
  end

  include Verbose

  def exec_hook(&hook)
    @x = :exec
    instance_eval(&hook)
  end
end

handler = HooksHandler.new
handler.register do |x|
  p "#{x} 1st hook"
end

handler.register do |x|
  p "#{x} 2nd hook"
end

handler.exec_hook do
  say "say x = #{@x} - 3rd hook"
end

handler.do_hooks
handler.run_hooks
