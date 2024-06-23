import org.apache.spark.sql.SparkSession

object HashPartitionExample {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("HashPartitionExample")
      .master("local[*]")  
      .getOrCreate()
    
    val sc = spark.sparkContext
    
    val data = List(
      (1, "HR", "Manager"),
      (2, "IT", "Developer"),
      (3, "HR", "Assistant"),
      (4, "Admin", "Clerk"),
      (5, "IT", "Tester"),
      (6, "Admin", "Manager"),
      (7, "IT", "Architect"),
      (8, "HR", "Coordinator")
    )
    
    val rdd = sc.parallelize(data)
    
    val pairRDD = rdd.map { case (empId, dept, empDesg) => (dept, (empId, dept, empDesg)) }
    
    val partitionedRDD = pairRDD.partitionBy(new org.apache.spark.HashPartitioner(4))
    
    partitionedRDD.glom().collect().zipWithIndex.foreach { case (partition, idx) =>
      println(s"Partition $idx:")
      partition.foreach(println)
      println("------------------------")
    }
    
    spark.stop()
  }
}
