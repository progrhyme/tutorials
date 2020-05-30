use structopt::StructOpt;

/// Search for a pattern in a file and display the lines that contain it.
#[derive(StructOpt)]
struct Cli {
    /// The pattern to look for
    pattern: String,
    /// The path to the file to read
    #[structopt(parse(from_os_str))]
    path: std::path::PathBuf,
}

//struct Cli {
//    pattern: String,
//    path: std::path::PathBuf,
//}

fn main() {
    let args = Cli::from_args();
    //let pattern = std::env::args().nth(1).expect("no pattern given");
    //let path = std::env::args().nth(2).expect("no path given");
    //let args = Cli {
    //    pattern: pattern,
    //    path: std::path::PathBuf::from(path),
    //};
}
