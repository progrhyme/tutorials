package main

import (
	"fmt"
	"io/ioutil"
	"os"

	"github.com/h2non/filetype"
)

func main() {
	buf, _ := ioutil.ReadFile(os.Args[1])

	kind, _ := filetype.Match(buf)
	if kind == filetype.Unknown {
		fmt.Println("Unknown file type")
		return
	}

	fmt.Printf("File type: %s. MIME: %s\n", kind.Extension, kind.MIME.Value)
}
