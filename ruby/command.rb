#!/usr/bin/env ruby

`true`
p [$?, $?.exitstatus, $?.success?]

`false`
p [$?, $?.exitstatus, $?.success?]
