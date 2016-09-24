module Provider
  attr_accessor :rw_prop
  attr :ro_prop

  def set_ro_prop(x)
    @ro_prop = x
  end
end

class A
  extend Provider
end

p A.rw_prop = :set_rw_prop
p A.rw_prop
p A.set_ro_prop :set_ro_prop
p A.ro_prop
#p A.ro_prop = :set_ro_prop2 # ERROR!

class B < A; end

p B.rw_prop
p B.ro_prop

class C
  m = Module.new do
    attr_accessor :rw_prop
    attr :ro_prop
  end

  extend m
  @rw_prop = :rw
  @ro_prop = :ro
end

p C.rw_prop
p C.rw_prop = :rw2
p C.ro_prop
#p C.ro_prop = :ro2 # ERROR!
