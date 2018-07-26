package com.knoldus

import java.io.File

class FindFolders {
  def getFile(s: String, list: List[String]): Unit = {


    val file = new File(s)
    val fList = file.listFiles
    for (file <- fList) {
      if (file.isFile) println(file.getAbsolutePath)
      else if (file.isDirectory) getFile(file.getAbsolutePath, list)
    }
  }
}
