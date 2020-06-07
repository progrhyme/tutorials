package main

import (
	"fmt"
)

func main() {
	var a, b string
	fmt.Print("Input 2 strings: ")
	n, e := fmt.Scanln(&a, &b)
	if e != nil {
		panic(e)
	}
	fmt.Printf("Read %d words. a = %s, b = %s\n", n, a, b)
}
