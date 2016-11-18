#!/usr/bin/env bash

set -euo pipefail

truly() {
  return 0
}

truly2() {
  return
}

falsy() {
  return 1
}

is_true?() {
  return 0
}

#if truly; then
if is_true?; then
  echo true
fi

if ! falsy; then
  echo false
fi

truly2

echo end

exit
