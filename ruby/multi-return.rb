#!/usr/bin/env ruby

def multi
  return 1, 2
end

def wrap
  return multi
end

a = multi
p a
a, b = multi
p a, b

x = wrap
p x
x, y = wrap
p x, y
