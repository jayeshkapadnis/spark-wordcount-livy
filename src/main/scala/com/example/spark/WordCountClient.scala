package com.example.spark

import java.io.File
import java.net.URI

import com.cloudera.livy.{LivyClient, LivyClientBuilder}

import scala.util.{Failure, Success, Try}

object WordCountClient extends App{

    require(args.length == 3, "Provide Jar path, file path and  Livy URL")

    val jarPath = args(0)
    val filePath = args(1)
    val livyUrl = args(2)

    val client: LivyClient = new LivyClientBuilder()
      .setURI(new URI(livyUrl))
      .build()

    Try{
      client.uploadJar(new File(jarPath)).get()
      client.submit(new WordCountJob(filePath)).get()
    } match {
      case Success(result) => System.err.println(result)
      case Failure(e) => System.err.println(" Exception occurred while excuting wordcount Job")
    }

    client.stop(true)

}
