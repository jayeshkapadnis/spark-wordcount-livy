#!/usr/bin/env bash
scriptdir=`dirname $0; pwd`
jarpath="$scriptdir/target/spark-wordcount-1.0-SNAPSHOT.jar"
echo $jarpath
curl -X POST --data '{"file": "/Users/jkn7485/Repos/spark-wordcount/target/spark-wordcount-1.0-SNAPSHOT.jar", "className": "com.example.spark.WordCount", "args": ["/Users/jkn7485/science.txt"]}' -H "Content-Type: application/json" localhost:8998/batches