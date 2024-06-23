val rddData = sc.textFile("a.txt")
val output = rddData.flatMap(_.split(" ")).map(word => (word, 1))
val wordCountsReduced = output.reduceByKey(_ + _)
val frequentWords = wordCountsReduced.filter { case (_, count) => count > 4 }
frequentWords.saveAsTextFile("b.txt")
frequentWords.collect().foreach(println)
