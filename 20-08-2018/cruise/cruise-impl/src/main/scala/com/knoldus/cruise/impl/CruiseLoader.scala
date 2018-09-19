package com.knoldus.cruise.impl

/*
import com.knoldus.cruise.api.{CruiseService, ExternalService}
import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.broker.kafka.LagomKafkaComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader}
import com.softwaremill.macwire.wire
import play.api.libs.ws.ahc.AhcWSComponents


class CruiseLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new HellolagomApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new HellolagomApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[CruiseService])
}

abstract class HellolagomApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with CassandraPersistenceComponents
    with LagomKafkaComponents
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[CruiseService](wire[CruiseServiceImpl])

  // Register the JSON serializer registry
  override lazy val jsonSerializerRegistry = CruiseSerializerRegistry

  // Register the hello-lagom persistent entity
  persistentEntityRegistry.register(wire[CruiseEntity])

  //lazy val helloService = serviceClient.implement[LagomApplication]


  //Bind the external service in ServiceModule.
  lazy val externalService = serviceClient.implement[ExternalService]

  //wire[CruiseServiceSubscriber]
  //wire[CruiseScheduler]
}

*/

import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.persistence.cassandra.CassandraPersistenceComponents
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import com.knoldus.cruise.api.{CruiseService, ExternalService}
import com.lightbend.lagom.scaladsl.broker.kafka.LagomKafkaComponents
import com.softwaremill.macwire._

class CruiseLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new CruiseApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new CruiseApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[CruiseService])
}

abstract class CruiseApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with CassandraPersistenceComponents
    with LagomKafkaComponents
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[CruiseService](wire[CruiseServiceImpl])

  // Register the JSON serializer registry
  override lazy val jsonSerializerRegistry = CruiseSerializerRegistry

  // Register the hello-lagom persistent entity
  persistentEntityRegistry.register(wire[CruiseEntity])

  lazy val helloService = serviceClient.implement[CruiseService]
  lazy val externalService = serviceClient.implement[ExternalService]

  wire[CruiseScheduler]
  wire[CruiseServiceSubscriber]

}
