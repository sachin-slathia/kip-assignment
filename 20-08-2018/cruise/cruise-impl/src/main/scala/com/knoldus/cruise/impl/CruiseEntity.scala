package com.knoldus.cruise.impl

import java.time.LocalDateTime

import akka.Done
import com.knoldus.cruise.api.models._
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity

class CruiseEntity extends PersistentEntity {
  override type Command = CruiseCommand[_]
  override type Event = CruiseEvent
  override type State = CruiseState

  override def initialState: CruiseState = CruiseState("GuestList",GuestList(List(Guests(GuestInformation(GuestReservationId("", ""),
    PersonalInfo("", "", "", "", "", "", "", "", "", "", "", "", "", ""), ContactInfo(PhoneNumber("", "", ""), "", "", "", ""),
    TravelPhoto("", 1.0), EmergencyContactInfo("", "", "", ""), InsuranceInfo("", "", ""),
    ImmigrationInfo(MachineReadableTravelDocument("", "", ""), "", "", List(Documents("", "", "", "", "", "", "", "", "", "")))), ""))), LocalDateTime.now.toString)

  override def behavior: Behavior = {
    case CruiseState(name,message, _) =>
      Actions().onCommand[UseGreetingMessage, Done] {

        // Command handler for the UseGreetingMessage command
        case (UseGreetingMessage(newMessage), ctx, state) =>
          println("onCommand message = " + message)
          // In response to this command, we want to first persist it as a
          // GreetingMessageChanged event
          println("newMessage = " + newMessage)
          ctx.thenPersist(
            GreetingMessageChanged(newMessage)
          ) { _ =>
            // Then once the event is successfully persisted, we respond with done.
            println("replying after persist")
            ctx.reply(Done)
          }

      }.onReadOnlyCommand[Hello, String] {

        // Command handler for the Hello command
        case (Hello(name), ctx, state) =>
          // Reply with a message built from the current message, and the name of
          // the person we're meant to say hello to.
          ctx.reply(s"$message, $name!")

      }.onEvent {

        // Event handler for the GreetingMessageChanged event
        case (GreetingMessageChanged(newMessage), state) =>
          println("onEvent message = " + message)
          // We simply update the current state to use the greeting message from
          // the event.
          println("onEvent newMesssage = " + newMessage)
          val helloState = CruiseState(name,newMessage, LocalDateTime.now().toString)

          helloState
      }
  }
}
