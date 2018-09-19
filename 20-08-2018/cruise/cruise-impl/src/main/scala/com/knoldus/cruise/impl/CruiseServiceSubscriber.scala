package com.knoldus.cruise.impl

import akka.Done
import akka.stream.scaladsl.Flow
import com.knoldus.cruise.api.CruiseService

class CruiseServiceSubscriber(cruiseService: CruiseService) {

  cruiseService
    .greetingsTopic()
    .subscribe // <-- you get back a Subscriber instance
    .atLeastOnce(

    Flow.fromFunction { msg =>
      print("Atleast once Subscriber" + msg)
      // Do somehting with the `msg`]
      //println(msg.message)
      //doSomethingWithTheMessage(msg)
      Done
    }
  )
}
