require 'sequel'

DB = Sequel.sqlite('tmp/sqlite.db')
#DB.run 'CREATE TABLE foo (id INT NOT NULL, name VARCHAR(255) NOT NULL)'

class Foo < Sequel::Model
end

foo = Foo.new do |f|
  #f.id   = 1
  f.name = 'foo'
end
p foo
