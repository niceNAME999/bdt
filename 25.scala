import org.apache.spark.{SparkConf, SparkContext}

object RDDPartitioningExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDPartitioningExample").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val Item = Map(
      "Ball" -> 10,
      "Ribbon" -> 50,
      "Box" -> 20,
      "Pen" -> 5,
      "Book" -> 8,
      "Dairy" -> 4,
      "Pin" -> 20
    )
    
    val rdd = sc.parallelize(Item.toSeq, numSlices = 3)
    
    val numPartitions = rdd.getNumPartitions
    println(s"Number of partitions created for the RDD: $numPartitions")
    
    println("Content of the RDD:")
    rdd.collect().foreach(println)
    
    rdd.glom().zipWithIndex().foreach { case (partition, idx) =>
      println(s"\nPartition $idx:")
      partition.foreach(println)
    }
    
    sc.stop()
  }
}
