require 'benchmark'

n = ARGV[0].to_i || 1000
l = ARGV[1].to_i || 20

patterns = [*'a'..'z'] + [*'A'..'Z']

Benchmark.bm(10, '>total:', '>avg:') do |x|
  ta = x.report('Array.new') { n.times do Array.new(l) { patterns.sample }.join; end }
  tr = x.report('Array.new') { n.times do (1..l).map { patterns.sample }.join; end }
  tt = x.report('Array.new') { n.times do l.times.map { patterns.sample }.join; end }

  [ta+tr+tt, (ta+tr+tt)/3]
end
