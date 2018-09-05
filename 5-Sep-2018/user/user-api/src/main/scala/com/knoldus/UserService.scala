package com.knoldus

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}
import play.api.libs.json.{Format, Json}

import scala.collection.mutable.ListBuffer

trait UserService extends Service {

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("user")
      .withCalls(
        restCall(Method.GET, "/api/getuser/:id", getUser _),
        restCall(Method.POST, "/api/insertuser/:id/:name", insertUser _),
        restCall(Method.DELETE, "/api/deleteuser/:id", deleteUser _),
        restCall(Method.PUT, "api/update/:id/:name", updateUser _)
      )
      .withAutoAcl(true)
    // @formatter:on
  }

  def getUser(id: Int): ServiceCall[NotUsed, String]

  def updateUser(id: Int, name: String): ServiceCall[NotUsed, String]

  def deleteUser(id: Int): ServiceCall[NotUsed, String]

  def insertUser(id: Int, name: String): ServiceCall[NotUsed, String]
}

case class User(id: Option[Int], name: String)

object User {
  var userList = new ListBuffer[User]()

  implicit val format: Format[User] = Json.format[User]
}

