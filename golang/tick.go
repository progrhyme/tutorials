// Example of never-ending program
// Tick time by every second
package main

import (
	"fmt"
	"time"
)

func main() {
	for {
		t := time.Now()
		fmt.Println(t)
		time.Sleep(time.Second)
	}
}
