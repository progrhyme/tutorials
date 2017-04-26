package main

import (
	"log"
	"net/http"
	"net/http/httputil"
)

func main() {
	// Proxy to http://localhost:3000
	director := func(request *http.Request) {
		request.URL.Scheme = "http"
		request.URL.Host = ":3000"
	}
	rp := &httputil.ReverseProxy{Director: director}
	server := http.Server{
		Addr:    ":8080",
		Handler: rp,
	}
	if err := server.ListenAndServe(); err != nil {
		log.Fatal(err.Error())
	}
}
