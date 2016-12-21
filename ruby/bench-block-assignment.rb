#!/usr/bin/env ruby

require 'benchmark'

n = 1_000_000

Benchmark.bm(7, '>total:', '>avg:') do |x|
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

  [tn + tm, (tn + tm) / 2]
end
