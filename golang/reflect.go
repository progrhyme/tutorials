package main

import (
	"fmt"
	"reflect"
)

func main() {
	t := reflect.TypeOf(3)
	fmt.Println("Type of 3 is ", t.Name())
}
