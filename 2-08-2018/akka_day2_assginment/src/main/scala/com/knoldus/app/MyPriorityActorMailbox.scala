package com.knoldus.app

import akka.actor.{ActorSystem, PoisonPill}
import akka.dispatch.{PriorityGenerator, UnboundedPriorityMailbox}
import com.typesafe.config.Config

class MyPriorityActorMailbox(settings: ActorSystem.Settings, config: Config) extends UnboundedPriorityMailbox(
  PriorityGenerator {

    case x: Tweet if x.friendsCount < 500 => 0

    case x: Tweet if x.friendsCount > 500 => 1

    case PoisonPill => 2

    case _ => 3
  })
