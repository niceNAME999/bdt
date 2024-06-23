val books = List(
    ("Dr. Seuss", "How the Grinch Stole Christmas!"),
    ("Jon Stone", "Monsters at the End of This Book"),
    ("Dr. Seuss", "The Lorax"),
    ("Jon Stone", "Big Bird in China"),
    ("Dr. Seuss", "One Fish, Two Fish, Red Fish, Blue Fish")
  )

val mp = scala.collection.mutable.Map[String,Int]().withDefaultValue(0)

for ((a, b) <- books) {
    mp(a)+=1
}

for ((a, count) <- mp) {
  println("Author name " + a + " : " + count)
}