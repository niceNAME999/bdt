abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification

def showNotification(notification: Notification): Unit = {
  notification match {
    case Email(email, title, _) =>
      println(s"You got an email from $email with title: $title")
    case SMS(number, message) =>
      println(s"You got an SMS from $number! Message: $message")
  }
}

val emailNotification = Email("sender@example.com", "Hello", "How are you?")
val smsNotification = SMS("+123456789", "Hello there!")

showNotification(emailNotification)
showNotification(smsNotification)
