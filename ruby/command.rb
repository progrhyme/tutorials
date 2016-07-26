#!/usr/bin/env ruby

p "Kernel#system"

ret = system('true')
p [ret, $?]

ret = system('false')
p [ret, $?]

p "Backquote"

`true`
p [$?, $?.exitstatus, $?.success?]

`false`
p [$?, $?.exitstatus, $?.success?]
