package main

import (
	"fmt"
	"log"

	"gopkg.in/yaml.v2"
)

func main() {
	var m map[string]interface{}

	data := `
name: Tanaka
age: 30
foo:
  bar: baz
  hoge:
    - x
    - "y"
list:
- aaa
- bbb: ccc
  xxx: yyy
`
	err := yaml.Unmarshal([]byte(data), &m)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Printf("%v\n", m)
	fmt.Printf("%v\n", m["foo"])
	fmt.Printf("%v\n", m["foo"].(map[interface{}]interface{})["hoge"])
	fmt.Printf("%v\n", m["list"])
	fmt.Printf("%v\n", m["list"].([]interface{})[1])
	fmt.Printf("%v\n", m["list"].([]interface{})[1].(map[interface{}]interface{})["bbb"])
}
