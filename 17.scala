val lines = sc.textFile("a.txt")
val wordCounts = lines.flatMap(line => line.split("\\s+")).map(word => (word, 1))              
val wordCountsReduced = wordCounts.reduceByKey(_ + _)             
wordCountsReduced.collect().foreach(println)
