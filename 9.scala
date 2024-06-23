def search(arr: Array[Int], num: Int): Boolean = {
  for (i <- 0 until arr.length) {
    if (arr(i) == num) {
      return true 
    }
  }
  false 
}

val b = Array(10,20,30,40,50)
val num = 30
search(b,num)