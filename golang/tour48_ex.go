package main

import (
	"fmt"
	"math/cmplx"
)

const delta = 1e-6

func Cbrt(x complex128) complex128 {
	z := x
	n := 0.0 + 0i // Point!: 複素数の宣言の仕方。これで complex128 になる
	for cmplx.Abs(n-z) > delta {
		n, z = z, z-(cmplx.Pow(z, 3)-x)/(3*cmplx.Pow(z, 2))
	}
	return z
}

func main() {
	const x = 2
	mine, theirs := Cbrt(x), cmplx.Pow(x, 1.0/3) // Point!: 1.0/3 で 3√ になる
	fmt.Println(mine, theirs, cmplx.Abs(mine-theirs))
}

/*
# command-line-arguments
./tour48_ex.go:21: mine declared and not used
./tour48_ex.go:21: theirs declared and not used
*/
