module M
  module ClassMethods
    attr_accessor :rw_prop
    attr :ro_prop

    def set_ro_prop(x)
      @ro_prop = x
    end
  end

  extend ClassMethods

  def self.included(klass)
    klass.extend ClassMethods
    p "#{klass} extend #{self}::ClassMethods"
  end
end

p M.rw_prop = :set_rw_prop
p M.rw_prop
p M.set_ro_prop :set_ro_prop
p M.ro_prop
#p A.ro_prop = :set_ro_prop2 # ERROR!

class A
  include M
end

p A.rw_prop
p A.ro_prop
