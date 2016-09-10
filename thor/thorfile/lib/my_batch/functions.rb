module MyBatch::Functions
  def logger
    @logger ||= -> {
      StdLogger.create('log/my_batch.log')
    }.call
  end
end
