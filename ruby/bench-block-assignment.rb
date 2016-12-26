#!/usr/bin/env ruby

require 'benchmark'

n = 1_000_000

Benchmark.bm(7) do |x|
  tn = x.report('lambda:') do
    n.times do
      foo = -> {
        :foo
      }.call
    end
  end
  tm = x.report('begin:') do
    n.times do
      foo = begin
        :foo
      end
    end
  end
end
