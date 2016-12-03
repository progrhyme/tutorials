#!/usr/bin/env ruby

require 'retryable'

@times = 0
Retryable.retryable do
  @times += 1
  p "try #{@times}"
  raise
end
