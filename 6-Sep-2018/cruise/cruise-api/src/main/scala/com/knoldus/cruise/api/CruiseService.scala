package com.knoldus.cruise.api

import akka.NotUsed
import com.knoldus.welcome.api.repository.JsonObject
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

trait CruiseService extends Service {

  def consumeGuest(): ServiceCall[NotUsed, JsonObject]

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("welcome")
      .withCalls(
        pathCall("/consume/guest", consumeGuest _)
      )
      .withAutoAcl(true)
    // @formatter:on
  }
}
