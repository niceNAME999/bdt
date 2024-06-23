import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object CombineByKeyExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CombineByKeyExample").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val data = Seq(
      ("coffee", 2),
      ("cappuccino", 5),
      ("tea", 3),
      ("coffee", 10),
      ("cappuccino", 15)
    )

    val rdd: RDD[(String, Int)] = sc.parallelize(data)

    val combinedRDD = rdd.combineByKey(
      (value: Int) => value,                     
      (acc: Int, value: Int) => acc + value,      
      (acc1: Int, acc2: Int) => acc1 + acc2     
    )

    println("Combined values by key:")
    combinedRDD.collect().foreach(println)

    sc.stop()
  }
}
