package com.knoldus.cruise.impl

import akka.{Done, NotUsed}
import com.knoldus.cruise.api
import com.knoldus.cruise.api.models._
import com.knoldus.cruise.api.{CruiseService, ExternalService, GreetingMessage}
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.api.broker.Topic
import com.lightbend.lagom.scaladsl.broker.TopicProducer
import com.lightbend.lagom.scaladsl.persistence.{EventStreamElement, PersistentEntityRegistry}
import org.slf4j.{Logger, LoggerFactory}
import play.api.libs.json.Json

import scala.concurrent.{ExecutionContext, Future}

class CruiseServiceImpl(externalService: ExternalService, persistentEntityRegistry: PersistentEntityRegistry)(implicit ec: ExecutionContext) extends CruiseService {

  private final val log: Logger = LoggerFactory.getLogger(classOf[CruiseServiceImpl])


  override def consumeGuest() = ServiceCall { _ =>
    val result: Future[GuestList] = externalService.getGuest().invoke
    val t = result.map(response => response)
    t.map(result => println("jnkmclcdlcdl" + result))
    val consume=new CruiseServiceImpl(externalService,persistentEntityRegistry)
    consume.greetingsTopic()
    t
  }

  override def greetingsTopic(): Topic[api.GreetingMessageChanged] =
    TopicProducer.singleStreamWithOffset {
          println("Inside topic ")
      fromOffset =>
        persistentEntityRegistry.eventStream(CruiseEvent.Tag, fromOffset)
          .map(ev => {print("printing elements inside topic"+ev);(convertEvent(ev), ev.offset)})
    }

  private def convertEvent(helloEvent: EventStreamElement[CruiseEvent]): api.GreetingMessageChanged = {
    helloEvent.event match {
      case GreetingMessageChanged(msg) => api.GreetingMessageChanged(msg)
    }
  }

  override def useGreeting(id: String): ServiceCall[GreetingMessage, Done] = ServiceCall { request =>
    // Look up the hello-lagom entity for the given ID.
    println("Before calling ask")
    /*val ref = persistentEntityRegistry.refFor[CruiseEntity](id)

    // Tell the entity to use the greeting message specified.

    val answer = ref.ask(UseGreetingMessage(request.message))
    /*val answer = ref.ask(UseGreetingMessage({
      for {
        guests <- externalService.getGuest().invoke()
      } yield new JsonObject(guests)
    })*/
    println("After calling ask answer =" + answer)*/
    Future(Done)
  }
}
object CruiseServiceImpl{


}

