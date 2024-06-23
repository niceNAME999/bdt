import java.util.Scanner

def findLongestWord(input: String): String = {
  val words = input.split("\\s+")
  var longestWord = ""
  for (word <- words) {
    if (word.length > longestWord.length) {
      longestWord = word
    }
  }
  longestWord
}

println("Enter words separated by spaces:")
val sc  = new Scanner(System.in)
val input = sc.nextLine()

val longestWord = findLongestWord(input)
println(s"The longest word entered is: '$longestWord'")




import scala.io.StdIn
def findLongestWordFromInput(): String = {
  val input = StdIn.readLine()
    val words = input.split("\\s+")
    var longestWord = ""
    for (word <- words) {
      if (word.length > longestWord.length) {
        longestWord = word
      }
    }
    longestWord
  }

val longestWord = findLongestWordFromInput()
println(s"The longest word entered is: '$longestWord'")
