#!/usr/bin/env bash

set -eo pipefail

foo() {
  local v x=1
  echo 'v = ' $v
  echo 'x = ' $x
}

foo

exit
