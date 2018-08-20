package controllers

import akka.Done
import forms.UserForm
import javax.inject.Inject
import models.CacheRepo
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Application @Inject()(controllerComponent: ControllerComponents,
                            userForm: UserForm, cacheRepo: CacheRepo) extends AbstractController(controllerComponent) {

  def index: Action[AnyContent] = Action.async { implicit request =>

    Future.successful(Ok(views.html.register()))

  }

  def register: Action[AnyContent] = Action.async { implicit request =>

    userForm.userForm.bindFromRequest.fold(
      formWithError => {
        Future.successful(BadRequest(s"${formWithError.errors}"))
      },
      data => {

        cacheRepo.get(data.email).flatMap { optionalUser =>
          optionalUser.fold {
            cacheRepo.store(data).map {
              case Done => Ok("Registration succesful")
              case _ => InternalServerError("something went wrong")

            }
          } {
            _ => Future.successful(Ok("User already exist"))
          }


        }
      }
    )
  }
  def getUser(email:String): Action[AnyContent] = Action.async { implicit request =>

    cacheRepo.get(email).map{optionalUser=>
      optionalUser.fold{
        NotFound("User does not exist")

      }
      {
        user=>
          Ok(s"$email,${user.name},${user.gender}")
      }


    }



  }
}
