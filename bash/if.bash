#!/usr/bin/env bash

set -euxo pipefail

for i in var `seq 1 10`; do
  if [[ $i =~ ^[0-9]+$ && $i < 5 ]]; then
    continue
  fi
  echo $i
done
