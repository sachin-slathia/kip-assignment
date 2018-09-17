package com.knoldus

import com.knoldus.ConvertFile.getTime
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.types.StringType
import org.apache.spark.{SparkConf, SparkContext}

object DataScientist extends App {

  val to_time = udf(getTime _, StringType)

  val conf = new SparkConf().setAppName("Question").setMaster("local")

  val sc = new SparkContext(conf)

  val spark = SparkSession
    .builder()
    .appName(" SQL ")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  val parquetFileDataFrame = spark.read.
    parquet("./src/main/resources/answer-parquet")

  parquetFileDataFrame.createOrReplaceTempView("Data")

  spark.sql("SELECT * FROM Data where date='2010-03-01' and time between '14:00' and '16:12' ")
    .show(10000)
}
