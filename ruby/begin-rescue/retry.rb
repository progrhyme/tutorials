#!/usr/bin/env ruby

def retry_on_error(times: 3)
  @__try__ ||= 0
  yield
rescue
  @__try__ += 1
  retry if @__try__ < times
  raise
end

def retry_on_error2(times: 3)
  try = 0
  begin
    try += 1
    yield
  rescue
    retry if try < times
    raise
  end
end

@try = 0
retry_on_error2 do
  @try += 1
  p @try
  raise "Failed after #{@try} trials."
end
