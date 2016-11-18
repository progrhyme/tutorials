#!/usr/bin/env ruby

require 'dalli'
require 'benchmark'

n = 10_000
servers = %w(10.0.0.1:11211:50 10.0.0.2:11211:50)
options = {
  namespace: 'foo',
  compress: false,
}
dalli = Dalli::Client.new(servers, options)

Benchmark.bm(7, ">total:", ">avg:") do |x|
  tn = x.report("new:") do
    n.times do
      dumped_servers = Marshal.dump(servers)
      Dalli::Client.new(Marshal.load(dumped_servers), options)
    end
  end
  tm = x.report("marshal:") do
    n.times do
      Marshal.load(Marshal.dump(dalli))
    end
  end

  [tn + tm, (tn + tm)/2]
end
