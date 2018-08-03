package com.knoldus.app

import akka.actor.Actor
import akka.event.{Logging, LoggingAdapter}


class Worker extends Actor {
  val log: LoggingAdapter = Logging(context.system, this)


  def receive:PartialFunction[Any,Unit] = {

    case w: Tweet =>

   sender()!(s"Tweet = ${w.tweetId} was tweeted by ${w.tweetUserName}" +
        s" has Friends count ${w.friendsCount}")
  }

}
