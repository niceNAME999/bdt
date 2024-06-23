def quickSort(arr: List[Int]): List[Int] = {
  arr match {
    case Nil => Nil
    case pivot :: tail =>
      val (left, right) = tail.partition(_ <= pivot)
      quickSort(left) ::: pivot :: quickSort(right)
  }
}

val array = List(32, 6, 34, 8, 38, 88)
val sortedArray = quickSort(array)
println(s"Original Array: ${array.mkString(", ")}")
println(s"Sorted Array: ${sortedArray.mkString(", ")}")
