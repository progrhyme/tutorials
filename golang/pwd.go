package main

import (
	"fmt"
	"os"
)

func main() {
	pwd, err := os.Getwd()
	fmt.Println(pwd, err)
}
