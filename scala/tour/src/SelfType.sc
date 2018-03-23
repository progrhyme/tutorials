trait User {
  def username: String
}

trait Tweeter {
  this: User =>  // reassign this
  def tweet(tweetText: String) = println(s"$username: $tweetText")
}

class VerifiedTweeter(val username_ : String) extends Tweeter with User {  // We mixin User because Tweeter required it
  def username = s"real $username_"
}

val realBeyoncé = new VerifiedTweeter("Beyoncé")
realBeyoncé.tweet("Just spilled my glass of lemonade")


trait Tweeter2 extends User {
  def tweet(tweetText: String) = println(s"$username: $tweetText")
}

class VerifiedTweeter2(val username_ : String) extends Tweeter2 {
  def username = s"real $username_"
}

val foo = new VerifiedTweeter2("foo")
foo.tweet("Hello, world!")