var items = Map(
  "Pen" -> 20,
  "Pencil" -> 10,
  "Eraser" -> 7,
  "Book" -> 25,
  "Sheet" -> 15
)


println("Items:")
for ((item, quantity) <- items) {
  println(s"$item : $quantity")
}


var totalQuantity = 0
for ((_, quantity) <- items) {
  totalQuantity += quantity
}
val totalItems = items.size
println("\nTotal Quantity: " + totalQuantity)
println("Total Number of Items: " + totalItems)

items += ("Book" -> (items.getOrElse("Book", 0) + 3))
println("\nAfter adding 3 Books:")
for ((item, quantity) <- items) {
  println(s"$item : $quantity")
}


items += ("Board" -> 15)
println("\nAfter adding Board:")
for ((item, quantity) <- items) {
  println(s"$item : $quantity")
}

