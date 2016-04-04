module CamelSnake
  def to_pascalcase
    split('_').map(&:capitalize).join('')
  end

  def to_camelcase firstletter=:capital
    if firstletter == :capital
      to_pascalcase
    else
      gsub(/_([a-z])/) { $1.upcase }
    end
  end

  def to_snakecase
    gsub(/(.)([A-Z])/, '\1_\2').downcase
  end
end

class String
  include CamelSnake
end

p "FooBarBaz11 5PiyoPiyo".to_snakecase
p "foo_bar_baz11 5piyo_piyo".to_camelcase
p "foo_bar_baz11 5piyo_piyo".to_camelcase :lower
