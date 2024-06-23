import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object AverageOf100Items {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("AverageOf100Items")
      .master("local[*]") 
      .getOrCreate()
    
    val csvFilePath = "path/to/your/csv/file.csv"
    val df = spark.read.option("header", "true").csv(csvFilePath)
    val integerRDD = df.select("value").rdd.map(row => row.getString(0).toInt)
    val count = integerRDD.count()
    val sum = integerRDD.reduce(_ + _)
    val average = sum.toDouble / count
    println(s"Average of ${count} items: $average")
    spark.stop()
  }
}
