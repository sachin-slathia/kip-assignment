package com.knoldus


import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import com.knoldus.app.{MainRouter, Tweet, Worker}
import com.typesafe.config.ConfigFactory
import org.scalatest.{Matchers, WordSpecLike}

class TwitterStreamAppSpec extends TestKit(ActorSystem("EchoActorSpec")) with ImplicitSender
  with WordSpecLike with Matchers {


  val system1 = ActorSystem("tweet", ConfigFactory.parseString(
    """my-dispatcher {
                        type = Dispatcher
                        mailbox-type = "com.knoldus.ap p.MyPriorityActorMailbox"
                        }"""))


  "An worker actor" must {
    "return tweet information" in {
      val master = system1.actorOf(Props[Worker])
      master ! Tweet("234cfds-a9df-464d-dsfdsf345", 34234, 43543, "語뢅鴝溎쓎퍁ᖒ乽㡏哂", "Oneplus", 3324)
      expectMsg("Tweet = 234cfds-a9df-464d-dsfdsf345 was tweeted by 語뢅鴝溎쓎퍁ᖒ乽㡏哂 has Friends count 3324")
    }
  }

}




