// +build ignore

package main

import (
	"errors"
	"fmt"
	"sync"
)

type Fetcher interface {
	// Fetch returns the body of URL and
	// a slice of URLs found on that page.
	Fetch(url string) (body string, urls []string, err error)
}

// fetched tracks URLs that have been (or are being) fetched.
// The lock must be held while reading from or writing to the map.
// See http://golang.org/ref/spec#Struct_types section on embedded types.
var fetched = struct {
	m map[string]error
	sync.Mutex
}{m: make(map[string]error)}

var loading = errors.New("url load in progress") // sentinel value

// Crawl uses fetcher to recursively crawl
// pages starting with url, to a maximum of depth.
func Crawl(url string, depth int, fetcher Fetcher) {
	if depth <= 0 {
		fmt.Printf("<- Done with %v, depth 0.\n", url)
		return
	}

	fetched.Lock()
	if _, ok := fetched.m[url]; ok {
		fetched.Unlock()
		fmt.Printf("<- Done with %v, already fetched.\n", url)
		return
	}
	// We mark the url to be loading to avoid others reloading it at the same time.
	fetched.m[url] = loading
	fetched.Unlock()

	// We load it concurrently.
	body, urls, err := fetcher.Fetch(url)

	// And update the status in a synced zone.
	fetched.Lock()
	fetched.m[url] = err
	fetched.Unlock()

	if err != nil {
		fmt.Printf("<- Error on %v: %v\n", url, err)
		return
	}
	fmt.Printf("Found: %s %q\n", url, body)
	done := make(chan bool)
	for i, u := range urls {
		fmt.Printf("-> Crawling child %v/%v of %v : %v.\n", i, len(urls), url, u)
		go func(url string) {
			Crawl(url, depth-1, fetcher)
			done <- true
		}(u)
	}
	for i, u := range urls {
		fmt.Printf("<- [%v] %v/%v Waiting for child %v.\n", url, i, len(urls), u)
		<-done
	}
	fmt.Printf("<- Done with %v\n", url)
}

func main() {
	Crawl("http://golang.org/", 4, fetcher)

	fmt.Println("Fetching stats\n--------------")
	for url, err := range fetched.m {
		if err != nil {
			fmt.Printf("%v failed: %v\n", url, err)
		} else {
			fmt.Printf("%v was fetched\n", url)
		}
	}
}

// fakeFetcher is Fetcher that returns canned results.
type fakeFetcher map[string]*fakeResult

type fakeResult struct {
	body string
	urls []string
}

func (f *fakeFetcher) Fetch(url string) (string, []string, error) {
	if res, ok := (*f)[url]; ok {
		return res.body, res.urls, nil
	}
	return "", nil, fmt.Errorf("not found: %s", url)
}

// fetcher is a populated fakeFetcher.
var fetcher = &fakeFetcher{
	"http://golang.org/": &fakeResult{
		"The Go Programming Language",
		[]string{
			"http://golang.org/pkg/",
			"http://golang.org/cmd/",
		},
	},
	"http://golang.org/pkg/": &fakeResult{
		"Packages",
		[]string{
			"http://golang.org/",
			"http://golang.org/cmd/",
			"http://golang.org/pkg/fmt/",
			"http://golang.org/pkg/os/",
		},
	},
	"http://golang.org/pkg/fmt/": &fakeResult{
		"Package fmt",
		[]string{
			"http://golang.org/",
			"http://golang.org/pkg/",
		},
	},
	"http://golang.org/pkg/os/": &fakeResult{
		"Package os",
		[]string{
			"http://golang.org/",
			"http://golang.org/pkg/",
		},
	},
}

/*
Found: http://golang.org/ "The Go Programming Language"
-> Crawling child 0/2 of http://golang.org/ : http://golang.org/pkg/.
-> Crawling child 1/2 of http://golang.org/ : http://golang.org/cmd/.
<- [http://golang.org/] 0/2 Waiting for child http://golang.org/pkg/.
Found: http://golang.org/pkg/ "Packages"
-> Crawling child 0/4 of http://golang.org/pkg/ : http://golang.org/.
-> Crawling child 1/4 of http://golang.org/pkg/ : http://golang.org/cmd/.
-> Crawling child 2/4 of http://golang.org/pkg/ : http://golang.org/pkg/fmt/.
-> Crawling child 3/4 of http://golang.org/pkg/ : http://golang.org/pkg/os/.
<- [http://golang.org/pkg/] 0/4 Waiting for child http://golang.org/.
<- Error on http://golang.org/cmd/: not found: http://golang.org/cmd/
<- Done with http://golang.org/, already fetched.
<- Done with http://golang.org/cmd/, already fetched.
Found: http://golang.org/pkg/fmt/ "Package fmt"
-> Crawling child 0/2 of http://golang.org/pkg/fmt/ : http://golang.org/.
-> Crawling child 1/2 of http://golang.org/pkg/fmt/ : http://golang.org/pkg/.
<- [http://golang.org/pkg/fmt/] 0/2 Waiting for child http://golang.org/.
Found: http://golang.org/pkg/os/ "Package os"
-> Crawling child 0/2 of http://golang.org/pkg/os/ : http://golang.org/.
-> Crawling child 1/2 of http://golang.org/pkg/os/ : http://golang.org/pkg/.
<- [http://golang.org/pkg/os/] 0/2 Waiting for child http://golang.org/.
<- [http://golang.org/] 1/2 Waiting for child http://golang.org/cmd/.
<- [http://golang.org/pkg/] 1/4 Waiting for child http://golang.org/cmd/.
<- [http://golang.org/pkg/] 2/4 Waiting for child http://golang.org/pkg/fmt/.
<- Done with http://golang.org/, already fetched.
<- Done with http://golang.org/pkg/, already fetched.
<- Done with http://golang.org/, already fetched.
<- Done with http://golang.org/pkg/, already fetched.
<- [http://golang.org/pkg/fmt/] 1/2 Waiting for child http://golang.org/pkg/.
<- Done with http://golang.org/pkg/fmt/
<- [http://golang.org/pkg/os/] 1/2 Waiting for child http://golang.org/pkg/.
<- Done with http://golang.org/pkg/os/
<- [http://golang.org/pkg/] 3/4 Waiting for child http://golang.org/pkg/os/.
<- Done with http://golang.org/pkg/
<- Done with http://golang.org/
Fetching stats
--------------
http://golang.org/pkg/os/ was fetched
http://golang.org/ was fetched
http://golang.org/pkg/ was fetched
http://golang.org/cmd/ failed: not found: http://golang.org/cmd/
http://golang.org/pkg/fmt/ was fetched
*/
