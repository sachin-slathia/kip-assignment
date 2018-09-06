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
        restCall(Method.GET, "/api/get/:id", getUser _),
        restCall(Method.POST, "/api/insert/", insertUser _),
        restCall(Method.DELETE, "/api/delete/:id", deleteUser _),
        restCall(Method.PUT, "/api/update/", updateUser _)
      )
      .withAutoAcl(true)
    // @formatter:on
  }

  def getUser(id: Int): ServiceCall[NotUsed, String]

  def updateUser(): ServiceCall[User, String]

  def deleteUser(id: Int): ServiceCall[NotUsed, String]

  def insertUser(): ServiceCall[User, String]
}

case class User(id: Option[Int], name: String)

object User {
  var userList = new ListBuffer[User]()

  implicit val format: Format[User] = Json.format[User]
}

