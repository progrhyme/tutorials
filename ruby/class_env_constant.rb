class A
  if ENV['FOO'] == 'foo'
    FOO = :foo
  else
    FOO = :bar
  end
  def b
    p FOO
  end

  def c
    b
  end
end

aa = A.new
aa.b
aa.c