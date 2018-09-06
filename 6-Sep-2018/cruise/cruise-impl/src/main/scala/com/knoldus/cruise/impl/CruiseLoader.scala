package com.knoldus.cruise.impl


import com.knoldus.cruise.api.{CruiseService, ExternalService}
import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader}
import com.softwaremill.macwire.wire
import play.api.libs.ws.ahc.AhcWSComponents

class CruiseLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new WelcomeApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new WelcomeApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[CruiseService])
}

abstract class WelcomeApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[CruiseService](wire[CruiseServiceImpl])

  //Bind the external service in ServiceModule.
  lazy val externalService = serviceClient.implement[ExternalService]
}
