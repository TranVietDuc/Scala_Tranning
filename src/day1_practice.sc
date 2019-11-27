
import scala.collection.mutable

def max(x: Int, y: Int): Int = if (x > y) x else y

def min(x: Int , y: Int): Int = if (x < y) x else y

max(3 , 4)

min(3,4);

1+2

val msg3 = "Hello there!"
var num = 3.5
var msg1 = "Hi guy"
var args = "dont worry my dear!"

var i = 0;
while (i < args.length) {
  if (i  != 0) {
    print(" ");
  }
  print(args(i));
  i += 1;
};


args.foreach( i => print(i));

for (i <- args) print(i);

class Person(var name : String,var age: Int ) {
  def +(person: Person): Person = new Person(name + person.name, age + person.age)
}

var duc = new Person( "duc", 26);
var hieu = new Person( "hieu",16);

var dung = duc + hieu;

val dung1 = duc.+(hieu)   ;



println(dung.name  + " " + dung.age.toString);
println(dung1.name  + " " + dung1.age.toString);

val greetStrings = new Array[String](3)


greetStrings(1) = "Hello"
greetStrings(2) = ","
greetStrings(0) = "there!"

val greeting2 = Array("hello", "duc", "there");

val oneTwoThree = List(1,2,3)  ;
val oneTwo = List(1,2)    ;
val threeFour = List(3,4);

val oneTwoThreeFour = oneTwoThree ::: threeFour;
oneTwoThreeFour
val oneTwoThreeFour2 = oneTwo ::: threeFour;
oneTwoThreeFour2
val oneTwoThreeFour3 =  4 :: oneTwoThree;

val testListMethod = List("Will","fill","util")     ;
val testDeclareList = "Will" :: "fill" :: "util" :: Nil;

testListMethod.count(s => s.contains("i")) ;

testDeclareList.filter( s => s.contains("ll"))

testDeclareList.foreach(print)
testDeclareList.map(s => s + "duc") ;

var newTuple = Tuple2(2, "hello")       ;

val treasureMap = mutable.Map[Int, String]








