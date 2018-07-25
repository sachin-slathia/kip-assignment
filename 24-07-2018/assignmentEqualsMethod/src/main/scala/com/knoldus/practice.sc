import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
//import scala.collection.mutable._

class Person(val name: String,var age: Int) {


  /* override def equals(that: Any): Boolean = that match
     {
     case that: Person=> this.name == that.name && this.age == that.age
     case _ => false
   }

 override def hashCode(): Int = if(name==this.name) name.##  else super.hashCode()

 }*/
  override def equals(that: Any): Boolean = that match
  {
    case that: Person=> this.name == that.name && this.age == that.age
    case _ => false
  }

  override def hashCode(): Int = if(name==this.name) printThis()  else super.hashCode()

  def printThis():Int ={
    return this.##
  }

}
println("sss")
val obj1=new Person("Sachin",22)
obj1.printThis()
val obj2=new Person("Sachin",25)
var obj3:Any=obj2

var hash =scala.collection.mutable.HashSet(obj1)

hash.contains(obj1)
obj1.age+=5
println(obj1.age)


hash contains(obj1)

/*
object A extends App{
  val result =Future{
    1+3}
  print(result)

}*/
