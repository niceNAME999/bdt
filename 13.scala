def binarySearch(arr: Array[Int], a: Int, low: Int, high: Int): Int = {
  if (low <= high) {
    val mid = low + (high - low) / 2

    if (arr(mid) == a) {
      return mid+1 // Found the target
    } else if (arr(mid) < a) {
      return binarySearch(arr, a, mid + 1, high) 
    } else {
      return binarySearch(arr, a, low, mid - 1)
    }
  }
  -1 
}

val arr = Array(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
val target = 23
val result = binarySearch(arr, target, 0, arr.length - 1)