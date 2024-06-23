import org.apache.spark.{SparkConf, SparkContext}

object WordCountExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCountExample").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val lines = sc.textFile("path/to/words.txt")
    val words = lines.flatMap(_.split("\\s+"))
    
    val wordCounts = words.map(word => (word.toLowerCase, 1)).reduceByKey(_ + _)
    
    val sortedWordCounts = wordCounts.sortByKey()
    
    val wordsStartingWithS = sortedWordCounts.filter { case (word, _) => word.startsWith("s") }
    
    println("Word counts:")
    wordCounts.collect().foreach(println)
    
    println("\nWords starting with 's':")
    wordsStartingWithS.collect().foreach(println)
    
    sc.stop()
  }
}
