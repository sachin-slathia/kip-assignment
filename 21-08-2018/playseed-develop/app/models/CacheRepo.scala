package models

import akka.Done
import forms.User
import javax.inject.Inject
import play.api.cache.AsyncCacheApi

import scala.concurrent.Future

class CacheRepo @Inject()(cache: AsyncCacheApi) {

  //store

  def store(user: User): Future[Done] = {
    cache.set(user.email, user)
  }


  //get
  def get(email: String): Future[Option[User]] = {

    cache.get(email)
  }
}
