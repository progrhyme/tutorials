#!/usr/bin/env bash

set -euo pipefail

foo="foo"

test-matches() {
  local sbj=$1
  local exp=$2
  if [[ $sbj = $exp ]]; then
    echo "$sbj = $exp"
  else
    echo "$sbj != $exp"
  fi
  if [[ $sbj =~ $exp ]]; then
    echo "$sbj =~ $exp"
  else
    echo "$sbj !~ $exp"
  fi
}

test-matches foo foo
test-matches foo 'fo*'
test-matches foo '.o*'
test-matches foo o
test-matches foo ^f
test-matches foo 'o$'
test-matches foo '^foo$'
test-matches foo '^fo+'
test-matches foo '^.o+'

exit

: <<'__EOF__'

=encoding utf8

=head1 NAME

B<script-name> - summary

=head1 SYNOPSYS

    script-name [options ...]

=head1 DESCRIPTION

blah blah blah.

=head1 AUTHORS

IKEDA Kiyoshi E<lt>yasutake.kiyoshi@gmail.comE<gt>

=head1 LICENSE

The MIT License (MIT)

Copyright (c) 2016 IKEDA Kiyoshi

=cut

__EOF__


