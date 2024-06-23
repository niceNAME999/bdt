import org.apache.spark.{SparkConf, SparkContext}

object MapPartitionsWithIndexExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MapPartitionsWithIndexExample").setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    val data = Array(11, 34, 45, 67, 3, 4, 90)
    val rdd = sc.parallelize(data, numSlices = 3)
    
    val incrementedRDD = rdd.mapPartitionsWithIndex { (index, iterator) =>
      iterator.map(value => value + 1)
    }
    
    incrementedRDD.glom().collect().zipWithIndex.foreach { case (partition, idx) =>
      println(s"Partition $idx:")
      partition.foreach(println)
      println("------------------------")
    }
    
    sc.stop()
  }
}
