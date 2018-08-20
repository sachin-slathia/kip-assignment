package forms

import play.api.data.Form
import play.api.data.Forms.{email, mapping, number, optional, text}

case class User(email: String, name: Option[String], gender: String, age: Int)

class UserForm {

  val userForm = Form (

    mapping (
      "email" -> email,
      "name" -> optional(text),
      "gender" -> text.verifying("Please select a value", _.nonEmpty),
      "age" -> number

    )(User.apply)(User.unapply)

  )

}
