package com.knoldus.cruise.api

import akka.NotUsed
import com.knoldus.cruise.api.models.GuestList
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

trait ExternalService extends Service {

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("external-service")
      .withCalls(
        pathCall("/deepakmehra10/227713bfa0aded2196059d6a623ea4e2/raw", getGuest _)
      ).withAutoAcl(true)
    // @formatter:on
  }

  def getGuest(): ServiceCall[NotUsed, GuestList]
}
