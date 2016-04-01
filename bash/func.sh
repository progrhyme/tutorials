#!/bin/bash

set -eu

var=hoge

func() {
  echo $1;
  echo ${2:-"undefined - ${var}"};
}

func a b
func a
