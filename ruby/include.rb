module M
  def self.class_method
    p "class method"
  end

  def pub_method
    p "public method"
  end
  public :pub_method

  def priv_method
    p "private method"
  end
  private :priv_method
end

class C
  include M

  def foo
    priv_method
  end
end

M.class_method
#M.pub_method #=> undefined
#M.priv_method #=> undefined

#C.class_method #=> undefined

c = C.new

c.pub_method
#c.priv_method #=> error
c.foo
