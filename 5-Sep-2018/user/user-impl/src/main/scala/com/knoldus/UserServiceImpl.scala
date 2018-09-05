package com.knoldus

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.persistence.PersistentEntityRegistry

import scala.concurrent.Future

class UserServiceImpl(persistentEntityRegistry: PersistentEntityRegistry) extends UserService {

  override def getUser(id: Int): ServiceCall[NotUsed, String] =
    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)
      result match {
        case Some(_) => Future.successful("User Not Exist")
        case _ =>       Future.successful(s" User exists with following values ${result.get.id} ${result.get.name}")
      }
    }
    }

  override def updateUser(id: Int, name: String): ServiceCall[NotUsed, String] =

    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)

      result match {
        case Some(_) => Future.successful("User not exist")
        case _ => {

                     User.userList.-=(result.get)
                     User.userList.+=(User(result.get.id, name))
                     Future.successful(s" User Updated with following values${result.get.id} ${result.get.name}")
        }
      }
    }
    }

  override def deleteUser(id: Int): ServiceCall[NotUsed, String] =
    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)
      result match {
        case Some(_) => Future.successful("User already exist")
        case _ => {

                     User.userList.-=(result.get)
                     Future.successful(s" User deleted with following values${result.get.id} ${result.get.name}")
        }
      }
    }
    }

  override def insertUser(id: Int, name: String): ServiceCall[NotUsed, String] = {

    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)
      result match {
        case Some(_) =>  Future.successful("User already exist")
        case _ => {

                         User.userList.+=(User(Option(id), name))
                         Future.successful(s" User added with following values${result.get.id} ${result.get.name}")
        }
      }

    }
    }
  }
}
