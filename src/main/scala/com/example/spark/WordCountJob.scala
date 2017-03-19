package com.example.spark

import com.cloudera.livy.{Job, JobContext}
import org.apache.spark.api.java.JavaRDD

class WordCountJob(path: String) extends Job[Map[String, Int]]{

  override def call(jobContext: JobContext): Map[String, Int] = {
    val file: JavaRDD[String] = jobContext.sc().textFile(path)
    val result: Map[String, Int] = JavaRDD.toRDD(file).flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _).collect().toMap
    result
  }
}
