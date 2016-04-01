package main

import (
    // "fmt"
    "code.google.com/p/go-tour/pic"
)

func Pic(dx, dy int) [][]uint8 {
    // row := make([]uint8, dx)
    // col := make([]uint8, dy)
    var matrix [dx][dy]uint8
    return matrix
}

func main() {
    pic.Show(Pic)
}
