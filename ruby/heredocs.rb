#!/usr/bin/env ruby

x = 'xxx'

# Since Ruby 2.3
puts <<~EOS
  #{x}

  bar
  baz
EOS
