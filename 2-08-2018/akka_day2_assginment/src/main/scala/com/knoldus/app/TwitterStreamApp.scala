package com.knoldus.app


import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable.ListBuffer
import scala.concurrent.duration._
//import scala.concurrent.ExecutionContext.Implicits.global


case class Tweet(tweetId: String,
                 createdAt: Long,
                 userId: Long,
                 tweetUserName: String,
                 countryName: String,
                 friendsCount: Long)


object TwitterStreamApp extends App {
  //val config = ConfigFactory.load()

  val system = ActorSystem("tweet", ConfigFactory.parseString(
    """my-dispatcher {
                        type = Dispatcher
                        mailbox-type = "com.knoldus.app.MyPriorityActorMailbox"
                        }"""))
  val master = system.actorOf(Props[MainRouter])

  val buffer: ListBuffer[Tweet] = scala.collection.mutable.ListBuffer[Tweet]()

  implicit val executionContext = system.dispatcher

  system.scheduler.schedule(0 millis, 50 millis) {
    val rg = scala.util.Random
    buffer += Tweet(java.util.UUID.randomUUID().toString, rg.nextLong(), rg.nextLong(),
      rg.nextString(10), "India", rg.nextInt(2000))


  }

  system.scheduler.schedule(0 millis, 1000 millis) {

    master ! buffer.toList

    buffer.clear()


  }

}



