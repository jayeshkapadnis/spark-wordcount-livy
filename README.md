# spark-wordcount-livy
Sample application to submit job to Livy server

Install Livy server locally or use HDP Sandbox

## Livy Locally

* Download Livy server from http://archive.cloudera.com/beta/livy/livy-server-0.3.0.zip
* Extract it locally
* Go to extracted folder and run
* `export SPARK_HOME=/usr/lib/spark`
* `export HADOOP_CONF_DIR=/etc/hadoop/conf`
* `./bin/livy-server` 
* You may need to setup configuration if you want to upload local jar of Spark Job in `livy-server-0.3.0/conf/livy.conf
--> livy.file.local-dir-whitelist = {directory of Jar}`
* Once done you could submit Job in 2 ways which are shown by `livy-curl.sh and livy-client.sh`