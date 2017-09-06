package myapp

import (
	"golang.org/x/net/context"
	"google.golang.org/appengine"
	aelog "google.golang.org/appengine/log"
	"net/http"
	"os"
	"path/filepath"
)

var ctx context.Context

func init() {
	http.HandleFunc("/", handler)
}

func handler(w http.ResponseWriter, r *http.Request) {
	ctx = appengine.NewContext(r)
	filepath.Walk("src/myapp/data", showFileInfo)
}

func showFileInfo(path string, f os.FileInfo, err error) error {
	aelog.Infof(ctx, "path: %s\n", path)
	return nil
}
