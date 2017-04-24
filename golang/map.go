package main

import (
	"fmt"
)

func main() {
	var ages map[string]int
	// 下の行をコメントアウトすると未割り当てのmapに対してデータ挿入が行われ、パニック
	ages = make(map[string]int)
	// 2行を縮めて以下でもOK
	// ages := make(map[string]int)
	ages["carol"] = 21
	fmt.Printf("%v", ages)
}
