package com.knoldus

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}

object ConvertFile extends App {
  val convertTime = udf(getTime _, StringType)

  val conf = new SparkConf().setAppName("Question").setMaster("local")

  val sc = new SparkContext(conf)

  val spark = SparkSession
    .builder()
    .appName(" SQL ")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  val csvFileDataFrame = spark.read.schema(StructType(Array(StructField("Timestamp", StringType, true),
    StructField("Temperature", StringType, true))))
    .csv("./src/main/resources/data.csv")

  val csvFileUpdatedDataFrame = csvFileDataFrame.withColumn("Time", convertTime(csvFileDataFrame.col("Timestamp")))
    .withColumn("date", to_date(csvFileDataFrame.col("Timestamp")))

  csvFileUpdatedDataFrame.write.partitionBy("Time").partitionBy("Date").
    parquet("./src/main/resources/answer-parquet")

  def getTime(timeStamp: String) = timeStamp.slice(11, 16)

}
