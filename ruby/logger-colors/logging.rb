#!/usr/bin/env ruby

require 'active_support/logger'
require 'logger/colors'

#logger = StdLogger.create 'sample.log'

stdout_logger = Logger.new(STDOUT)

logger = ActiveSupport::Logger.new('sample.log')
logger.formatter = Logger::Formatter.new
logger.extend(ActiveSupport::Logger.broadcast(stdout_logger))
logger.level = Logger::DEBUG

logger.debug 'debug log'
logger.info 'info log'
logger.warn 'warn log'
logger.error 'error log'
