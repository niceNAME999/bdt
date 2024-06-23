val rdd = sc.parallelize(Array(1, 2, 3, 4, 5))
val aRdd = rdd.fold(0)((acc, value) => acc + value + 100)
aRdd.collect() 


val rdd  = sc.parallelize(Array(1, 2, 3, 4, 5))
val uRDD = rdd.aggregate(0)(
  (acc, value) => acc + value + 100,  
  (acc1, acc2) => acc1 + acc2        
)
uRDD  
