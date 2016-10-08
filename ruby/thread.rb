#!/usr/bin/env ruby

(1..3).each do |i|
  th = Thread.new(i) do
    p "start #{i}"
    th[:foo] = i
    p th
    p th[:foo]
  end
  th.join
end
