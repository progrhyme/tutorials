class MyBatch::Foo
  include MyBatch::Functions
  def run
    logger.info('foo run')
    p :foo
  end
end
