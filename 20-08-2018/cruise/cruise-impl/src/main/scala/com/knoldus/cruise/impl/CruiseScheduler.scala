package com.knoldus.cruise.impl

import akka.actor.ActorSystem
import akka.stream.Materializer
import com.knoldus.cruise.api.ExternalService
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._


class CruiseScheduler(system: ActorSystem,externalService: ExternalService,persistentEntityRegistry: PersistentEntityRegistry)
                   (implicit val mat: Materializer, ec: ExecutionContext){
  system.scheduler.schedule(
    initialDelay = 0.microseconds,
    interval = 30.seconds) {

  val consume = new CruiseServiceImpl(externalService, persistentEntityRegistry)

    println("Before Calling External Service")
    consume.consumeGuest()
    //consume.greetingsTopic()*/
    println("zsxdfghjkl")
  }
}