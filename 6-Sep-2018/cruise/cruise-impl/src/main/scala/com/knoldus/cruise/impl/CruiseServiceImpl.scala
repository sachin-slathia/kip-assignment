package com.knoldus.cruise.impl

import com.knoldus.cruise.api.{CruiseService, ExternalService}
import com.knoldus.welcome.api.repository.JsonObject
import com.lightbend.lagom.scaladsl.api.ServiceCall
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.{ExecutionContext, Future}

class CruiseServiceImpl(externalService: ExternalService)(implicit ec: ExecutionContext) extends CruiseService {

  private final val log: Logger = LoggerFactory.getLogger(classOf[CruiseServiceImpl])

  override def consumeGuest() = ServiceCall { _ =>
    val result: Future[JsonObject] = externalService.getGuest().invoke()
    result.map(response => response)
  }
}
