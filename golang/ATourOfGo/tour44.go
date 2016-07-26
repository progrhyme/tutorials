package main

import "fmt"

// fibonacci is a function that returns
// a function that returns an int.
func fibonacci() func() int {
	foo, bar := 0, 1
	return func() int {
		baz := foo
		foo = bar
		bar += baz
		return baz
	}
}

func main() {
	f := fibonacci()
	for i := 0; i < 20; i++ {
		fmt.Println(f())
	}
}
