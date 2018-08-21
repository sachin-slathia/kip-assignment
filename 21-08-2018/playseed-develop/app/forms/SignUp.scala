package forms

import play.api.data.Form
import play.api.data.Forms.{email,mapping, number, text}

case class User(firstName: String, middleName: String, lastName: String,
                userName: String, password: String,
                phoneNumber: Int, gender: String)


class SignUp {

  val signUp = Form(

    mapping(
      "first-name" -> text.verifying("Please enter valid first-name", _.nonEmpty),
      "middle-name" -> text.verifying("Please enter valid first-name", _.nonEmpty),

      "last-name" -> text.verifying("Please enter valid last-name", _.nonEmpty),
      "user-name" -> email,
      "password" -> text.verifying("Enter valid password", _.nonEmpty),
      "phone-number" -> number,
       "gender" -> text.verifying("Enter gender", _.nonEmpty)

    )(User.apply)(User.unapply)

  )


}



