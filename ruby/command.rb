#!/usr/bin/env ruby

`true`
p [$?, $?.exitstatus]

`false`
p [$?, $?.exitstatus]
