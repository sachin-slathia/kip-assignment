package models

import akka.Done
import forms.User
import javax.inject.Inject
import play.api.cache.AsyncCacheApi

import scala.concurrent.Future

class StoreInDatabase @Inject()(cache: AsyncCacheApi) {

  def store(user: User): Future[Done] = {
    cache.set(user.userName, user)
  }


  def get(userName: String): Future[Option[User]] = {

    cache.get(userName)
  }


}
