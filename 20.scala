import org.apache.spark.sql.SparkSession

object AverageMarksCombineByKey {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("AverageMarksCombineByKey")
      .master("local[*]") 
      .getOrCreate()
    
    val sc = spark.sparkContext
    
    val data = Array(
      ("Joe", "Maths", 83), ("Joe", "Physics", 74), ("Joe", "Chemistry", 91), ("Joe", "Biology", 82),
      ("Nik", "Maths", 69), ("Nik", "Physics", 62), ("Nik", "Chemistry", 97), ("Nik", "Biology", 80)
    )
    
    val rdd = sc.parallelize(data)
    
    val pairRDD = rdd.map{ case (student, subject, marks) => (student, (marks, 1)) }
    
    val combineByKeyAvg = pairRDD.combineByKey(
      (marksCount: (Int, Int)) => marksCount,  
      (acc: (Int, Int), marksCount: (Int, Int)) => (acc._1 + marksCount._1, acc._2 + marksCount._2), 
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2) 
    )
    
    val averageMarks = combineByKeyAvg.mapValues { case (totalMarks, totalCount) =>
      totalMarks.toDouble / totalCount
    }
    
    averageMarks.collect().foreach { case (student, avgMarks) =>
      println(s"Student: $student, Average Marks: $avgMarks")
    }
    
    spark.stop()
  }
}
