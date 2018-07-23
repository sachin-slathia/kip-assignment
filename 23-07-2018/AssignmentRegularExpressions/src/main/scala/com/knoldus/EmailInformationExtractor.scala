package com.knoldus


class EmailInformationExtractor {

  object URL {

    def apply(domain: String, params: Map[String, String] = Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112")): String = {
      "https" + "://" + domain + "/" + "console/home" + "?" + (params.map { case (k, v) => k + "=" + v }.mkString("&"))
    }


    def unapply(url: String): Option[(String, String, String, Map[String, String])] = {
      require(url.nonEmpty, "give a valid url")
      val protocal = url.split("://", 2)
      val domain = protocal(1).split("/", 2)
      val path = domain(1).split('?')
      val findMap = path(1).split("=|&", 6)


      val map = Map(findMap(0) -> findMap(1), findMap(2) -> findMap(3), findMap(4) -> findMap(5))

      Some(protocal(0), domain(0), path(0), map)

    }
  }

}