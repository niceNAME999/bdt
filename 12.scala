val list = scala.collection.mutable.Map("Butter"->20, "Bun"->10, "Egg"->7, "Biscuit"->25,"Bread"->15)

for((item,quantity)<-list){
    println(item + " : " + quantity)
}

println("Size of Item "+list.size)
println("Size of Quantity "+list.values.sum)

list("Bun") = list.getOrElse("Bun", 0) + 3
for ((item, quantity) <- list) {
  println(s"$item : $quantity")
}

list+=("Cheese"->12)