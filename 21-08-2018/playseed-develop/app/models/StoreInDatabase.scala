package models

import akka.Done
import forms.User1
import javax.inject.Inject
import play.api.cache.AsyncCacheApi

import scala.concurrent.Future

class StoreInDatabase @Inject()(cache: AsyncCacheApi) {

  def store(user: User1): Future[Done] = {
    cache.set(user.userName, user)
  }


  def get(userName: String): Future[Option[User1]] = {

    cache.get(userName)
  }


}
