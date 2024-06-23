def factorial(n: Int): Int = {
  if (n < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers")
  else if (n == 0 || n == 1) 1
  else (1 to n).product
}

def factorialOfItems[A](items: Iterable[A])(implicit numeric: Numeric[A]): Int = {
  import numeric._
  
  items.foldLeft(1) { (acc, item) =>
    acc * factorial(item.toInt)
  }
}

val numbers = List(3, 4, 5) 
val factorialResult = factorialOfItems(numbers)
println(s"Factorial of items in $numbers: $factorialResult")
