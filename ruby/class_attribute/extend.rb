require 'active_support'
require 'active_support/core_ext/class/attribute'

module M
  extend ActiveSupport::Concern

  included do
    class_attribute :param
    self.param = {}

    def self.set_param_var stash
      #stash.each_pair do |k,v|
        #self.param[k] = v
      #end
      self.param = stash
    end
  end
end

class Base
  include M
end

class Child1 < Base
end

class Child2 < Base
end

Child2.set_param_var({:foo => 1})

p Base.param
p Child1.param
p Child2.param
