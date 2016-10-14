#!/usr/bin/env ruby

def try
  begin
    raise 'Foo'
  rescue => e
    require 'pp'
    pp e
    return
  ensure
    p 'ensure'
  end

  p 'try end'
end

try()
p 'end'
