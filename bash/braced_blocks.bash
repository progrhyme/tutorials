#!/bin/bash

set -euo pipefail

ns() {
  local _ns=$1
}

ns foo:: && {
  echo foo
}

{
  echo bar
}

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


