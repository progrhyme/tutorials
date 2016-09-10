class Foo < Thor
  default_command :default

  desc 'default', 'say :foo'
  def default
    p :foo
  end
end
