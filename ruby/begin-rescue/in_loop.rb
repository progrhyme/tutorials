def foo
  (1..3).each do |i|
    p i
    begin
      if i == 2
        raise "i == 2"
      end
    rescue => e
      p e.inspect
      return :error
    end
  end

  :end
end

p foo
