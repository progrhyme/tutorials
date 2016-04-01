package main

import (
	"code.google.com/p/go-tour/wc"
	"strings"
)

func WordCount(s string) map[string]int {
	fields := strings.Fields(s)
	m := make(map[string]int)
	for _, str := range fields {
		m[str]++
	}
	return m
}

func main() {
	wc.Test(WordCount)
}
