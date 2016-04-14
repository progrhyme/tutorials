#!/bin/bash

set -euo pipefail

foo() {
  i=1
  for l in $(cat -); do
    echo $i $l
    i=$((i + 1))
  done
}

foo <<EOS
foo
bar
EOS

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

YASUTAKE Kiyoshi E<lt>yasutake.kiyoshi@gmail.comE<gt>

=cut

__EOF__


