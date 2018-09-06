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
        case _ =>       Future.successful(s" User exists with following values ID= ${result.get.id} name= ${result.get.name} ")
      }
    }
    }

  override def insertUser(): ServiceCall[User, String] = {

    ServiceCall { user=> {

      val result = User.userList.find(user => user.id == user.id)
      result match {
        case Some(_) => Future.successful("User already exist")
        case _ => {

          User.userList.+=(User(user.id, user.name))
          Future.successful(s" User added ")
        }
      }

    }
    }
  }
  override def updateUser(): ServiceCall[User, String] =

    ServiceCall { user=> {

      val result = User.userList.find(user => user.id == user.id)

      result match {
        case None => Future.successful("User not exist")
        case _ => {

                     User.userList.-=(result.get)
          User.userList.+=(User(user.id, user.name))
                     Future.successful(s" User Updated ID= ${result.get.id} name= ${result.get.name} ")
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
                     Future.successful(s" User deleted ID= ${result.get.id} name= ${result.get.name} ")
        }
      }
    }
    }


}
