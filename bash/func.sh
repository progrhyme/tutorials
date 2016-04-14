#!/bin/bash

set -eu

var=hoge

func() {
  echo $1;
  echo ${2:-"undefined - ${var}"};
}

ns::f() {
  echo "Func with Namespace"
}

func a b
func a

ns::f
