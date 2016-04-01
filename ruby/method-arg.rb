require 'pp'

def foo(config)
  config ||= {}
  p config.object_id
  config['foo'] = 3
  pp config
end

#stash = {}
stash = {'config' => {}}

foo(stash['config'])

p stash.object_id
pp stash
