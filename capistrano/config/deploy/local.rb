set :deploy_to, "#{ENV['HOME']}/tmp/capistrano/tutorials"
set :sshkit_backend, SSHKit::Backend::Local
server 'localhost'
