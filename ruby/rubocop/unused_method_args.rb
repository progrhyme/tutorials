#!/usr/bin/env ruby

def foo(a, _b)
  p [a, _b] # rubocop error!
end

foo(1, 2)
