import java.io.File

val file=new File("/home/knoldus/handsOn")
file.isDirectory()


val v= file.listFiles().filter(_.isFile).toList
file.getAbsolutePath
val f1=new File("/home/knoldus")

val v1= f1.listFiles().filter(_.isFile).toList
v:::v1
f1.getAbsolutePath



def getFile(s:String,list:List[String]): Unit ={


  val f=new File(s)
  val fList = f.listFiles
  for (file <- fList) {
    if (file.isFile) System.out.println(file.getAbsolutePath)
    else if (file.isDirectory) getFile(file.getAbsolutePath,list)
  }


}
println(9)
getFile("/home/knoldus/handsOn",List())



