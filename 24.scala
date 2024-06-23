import org.apache.spark.{SparkConf, SparkContext}

object RDDPartitionExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDPartitionExample").setMaster("local[*]")
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
    
    val rdd = sc.parallelize(Item.toSeq)
    
    val numPartitions = rdd.getNumPartitions
    
    println(s"Number of partitions created for the RDD: $numPartitions")
    
    val partitionedRDD = rdd.glom()
    
    partitionedRDD.zipWithIndex.foreach { case (partition, idx) =>
      println(s"Partition $idx:")
      partition.foreach(println)
      println("------------------------")
    }
    
    sc.stop()
  }
}
