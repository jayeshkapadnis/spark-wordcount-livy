#!/usr/bin/env bash

java -cp ./target/spark-wordcount-1.0-SNAPSHOT.jar com.example.spark.WordCountClient "/Users/jkn7485/Repos/spark-wordcount/target/spark-wordcount-1.0-SNAPSHOT.jar" "/Users/jkn7485/science.txt" "http://localhost:8998"