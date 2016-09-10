class Foo < Thor
  default_command :default

  desc 'default', 'say :foo'
  def default
    MyBatch::Foo.new.run
  end
end
