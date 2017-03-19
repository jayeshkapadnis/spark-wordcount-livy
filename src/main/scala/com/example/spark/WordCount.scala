package com.example.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]) {
    require(args.length > 0, "Pass file path for execution")
    val path = args(0)
    val conf = new SparkConf().setAppName("Sample word count application")
    val sc = new SparkContext(conf)
    val file: RDD[String] = sc.textFile(path)
    val wordCount = file.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    System.err.println(s"""Word count in file $path is ${wordCount.collect().mkString(", ")}""")
    sc.stop()
  }

}
