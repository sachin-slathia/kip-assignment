package com.knoldus
class EmailParsing{

  def emailParser(str: String) :String=
  {
    val email = """^([A-Z0-9a-z._%+-]+)@([A-Z0-9a-z._%+-]+[.]+[A-Z0-9a-z._%+-]+)$""".r
    str match {
      case email(user, domain) => s"User $user Domain $domain"
      case _ => "Not a valid email"
    }

  }
}

