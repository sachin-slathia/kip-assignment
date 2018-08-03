package com.knoldus.app

import akka.actor.{Actor, Props, Terminated}
import akka.event.{Logging, LoggingAdapter}
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}


class MainRouter extends Actor {
  val log: LoggingAdapter = Logging(context.system, this)
  var router = {
    val routees = Vector.fill(15) {
      val r = context.actorOf(Props[Worker].withDispatcher("my-dispatcher"))
      context watch r
      ActorRefRoutee(r)
    }

    Router(RoundRobinRoutingLogic(), routees)
  }

  def receive:PartialFunction[Any,Unit] = {
    case w: List[Tweet] =>
     println(s"BufferSize = ${w.size}")
      for (w1 <- w)
        router.route(w1, sender())
    case Terminated(a) =>
      router = router.removeRoutee(a)
      val r = context.actorOf(Props[Worker])
      context watch r
      router = router.addRoutee(r)
  }
}
