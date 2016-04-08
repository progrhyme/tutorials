class Item
  attr :id
  def initialize id
    @id = id
  end
end

items = (1..10).map {|i| Item.new(i)}
p items
ids = items.map(&:id)
p ids
