def lenOfEach(arr: Array[String]): Unit = {
  val n = arr.length
  for (i <- 0 until n) {
    println("Length of Word " + arr(i) + " = " + arr(i).length)
  }
}

val a = Array("Hello", "this", "is", "a", "program")
lenOfEach(a)

