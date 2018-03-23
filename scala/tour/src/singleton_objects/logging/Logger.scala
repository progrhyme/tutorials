package singleton_objects.logging

object Logger {
  def info(message: String): Unit = println(s"INFO: $message")
}
