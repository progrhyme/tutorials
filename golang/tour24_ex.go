package main

import (
	"fmt"
)

func Sqrt(x, z float64) float64 {
	for i := 0; i < 10; i++ {
		// fmt.Println(z)
		z -= (z*z - x) / (z * 2)
	}
	return z
}

func main() {
	fmt.Println(Sqrt(1, 1))
	fmt.Println(Sqrt(2, 1))
	fmt.Println(Sqrt(3, 2))
}
