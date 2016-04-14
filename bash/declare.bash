#!/bin/bash

set -euo pipefail

foo() {
  echo say foo
}

declare -f foo
declare -F foo
declare -F bar || echo 'error! no such func'
declare -f bar || echo 'error! no such func'

foo

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


