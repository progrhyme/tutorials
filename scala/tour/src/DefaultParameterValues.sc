def log(message: String, level: String = "INFO") = println(s"$level: $message")

log("System starting")
log("User not found", "WARNING")
