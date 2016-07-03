#!/usr/bin/env bash

set -euo pipefail

test-case-match() {
  local sbj=$1
  local regexp=$2
  case "$sbj" in
    $regexp )
      echo "$sbj matches $regexp"
      ;;
    * )
      echo "$sbj doen't match $regexp"
      ;;
  esac
}

test-case-match foo foo
test-case-match foo 'fo*'
test-case-match foo '*o*'
test-case-match foo o
test-case-match foo ^f
test-case-match foo 'o$'
test-case-match foo '^foo$'
test-case-match foo '^fo+'
test-case-match foo '^.o+'

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


