package com.knoldus.cruise.api

import akka.NotUsed
import com.knoldus.welcome.api.repository.JsonObject
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

trait ExternalService extends Service {

  def getGuest(): ServiceCall[NotUsed,JsonObject]

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("external-service")
      .withCalls(
        pathCall("/deepakmehra10/227713bfa0aded2196059d6a623ea4e2/raw", getGuest _)
      ).withAutoAcl(true)
    // @formatter:on
  }
}
