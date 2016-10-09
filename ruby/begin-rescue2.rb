#!/usr/bin/env ruby

def try(success)
  if success
    true
  else
    raise 'oops!'
  end
rescue => e
  p e
  false
end

p try true
p try false
