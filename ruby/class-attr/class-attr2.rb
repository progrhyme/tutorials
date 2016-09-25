
class A
  class << self
    attr_accessor :rw_prop
    attr :ro_prop

    def set_ro_prop(x)
      @ro_prop = x
    end
  end
end

p A.rw_prop = :set_rw_prop
p A.rw_prop
p A.set_ro_prop :set_ro_prop
p A.ro_prop
#p A.ro_prop = :set_ro_prop2 # ERROR!

class B < A; end

p B.rw_prop
p B.ro_prop
