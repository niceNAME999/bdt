def capitalizeWords(sentence: String): String = {
  val words = sentence.split("\\s+")
  val capitalizedWords = words.map(_.capitalize)
  val capitalizedSentence = capitalizedWords.mkString(" ")
  capitalizedSentence
}

val sentence = "hello scala programm test"
val capitalizedSentence = capitalizeWords(sentence)
println(s"Original Sentence: $sentence")
println(s"Capitalized Sentence: $capitalizedSentence")
