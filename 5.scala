import scala.collection.mutable.ArrayBuffer

def quickSort(arr: ArrayBuffer[Int]): Unit = {
  def partition(low: Int, high: Int): Int = {
    val pivot = arr(high)
    var i = low - 1
    
    for (j <- low until high) {
      if (arr(j) <= pivot) {
        i += 1
        val temp = arr(i)
        arr(i) = arr(j)
        arr(j) = temp
      }
    }
    
    val temp = arr(i + 1)
    arr(i + 1) = arr(high)
    arr(high) = temp
    
    i + 1
  }
  
  def sort(low: Int, high: Int): Unit = {
    if (low < high) {
      val pi = partition(low, high)
      sort(low, pi - 1)
      sort(pi + 1, high)
    }
  }
  
  val n = arr.length
  sort(0, n - 1)
}

val array = ArrayBuffer(32, 6, 34, 8, 38, 88)
println("Original Array: " + array.mkString(", "))
quickSort(array)
println("Sorted Array: " + array.mkString(", "))