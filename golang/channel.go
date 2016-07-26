package main

import (
	"fmt"
	"time"
)

func oneSecond(c chan string) {
	time.Sleep(1000 * time.Millisecond)
	fmt.Println("1 second passed")
	c <- "finished\n"
}
func main() {
	c := make(chan string)      // チャンネル追加
	fmt.Println(time.Now())     // 開始
	go oneSecond(c)             // 並行処理
	go oneSecond(c)             // 並行処理
	go oneSecond(c)             // 並行処理
	w1, w2, w3 := <-c, <-c, <-c // 並行処理終了
	fmt.Println(time.Now())     // 終了
	fmt.Println(w1, w2, w3)
}
