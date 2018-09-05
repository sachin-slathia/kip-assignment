package com.knoldus

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.Future

class UserServiceImpl() extends UserService {

  override def getUser(id: Int): ServiceCall[NotUsed, String] =
    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)
      result match {
        case None =>    Future.successful("User Not Exist")
        case _ =>       Future.successful(s" User exists with following values ")
      }
    }
    }

  override def updateUser(id: Int, name: String): ServiceCall[NotUsed, String] =

    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)

      result match {
        case None => Future.successful("User not exist")
        case _ => {

                     User.userList.-=(result.get)
                     User.userList.+=(User(result.get.id, name))
                     Future.successful(s" User Updated ")
        }
      }
    }
    }

  override def deleteUser(id: Int): ServiceCall[NotUsed, String] =
    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)
      result match {
        case None => Future.successful("User doesnot exist")
        case _ => {

                     User.userList.-=(result.get)
                     Future.successful(s" User deleted ")
        }
      }
    }
    }

  override def insertUser(id: Int, name: String): ServiceCall[NotUsed, String] = {

    ServiceCall { _ => {
      val result = User.userList.find(user => user.id.get == id)
      result match {
        case Some(_)=>  Future.successful("User already exist")
        case _ => {

                         User.userList.+=(User(Option(id), name))
                         Future.successful(s" User added ")
        }
      }

    }
    }
  }
}
