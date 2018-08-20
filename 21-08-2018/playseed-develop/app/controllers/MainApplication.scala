package controllers

import akka.Done
import forms.SignUp
import javax.inject.Inject
import models.StoreInDatabase
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

class MainApplication @Inject()(controllerComponent: ControllerComponents,
                                signUp: SignUp, storeInDatabase: StoreInDatabase)
  extends AbstractController(controllerComponent) {

  def homePage: Action[AnyContent] = Action.async { implicit request =>

    Future.successful(Ok(views.html.register()))

  }

  def signUpPage: Action[AnyContent] = Action.async { implicit request =>

    signUp.signUp.bindFromRequest().fold(

      formWithError => {
        Future.successful(BadRequest(s"${formWithError.errors}"))
      },

      { data => {

        storeInDatabase.get(data.userName).flatMap { optionalUser =>
          optionalUser.fold {
            storeInDatabase.store(data).map {
              case Done => Ok("Registration succesful")
              case _ => InternalServerError("something went wrong")

            }
          } {
            _ => Future.successful(Ok("User already exist"))
          }
        }
      }
      })

  }


}