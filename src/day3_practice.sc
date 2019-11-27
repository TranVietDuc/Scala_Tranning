import java.io.{FileNotFoundException, FileReader, IOException}

import user.administrators.NormalUser
//Trait
trait Philosophical {
  def philosophize()= {
    println("I consume memory, there for I am!")
  }
}

class Frog extends Philosophical {
  override def toString = "green"

  override def philosophize(): Unit = {
    print("hello")
  }
}

val frog = new Frog
frog.philosophize()

val phil: Philosophical = frog

//Build-in control structure

def getMax(x: Int , y: Int): Int = if (x > y) x else  y;

getMax(4,3)

val filterIf = Array("D", "uc", "tran")


//test for Each
for (elr <- filterIf) println(elr)

//test filer inside for
for (
  ele <- filterIf
  if ele.length >= 2) print(ele)
//Nested iteration
val filesHere = (new java.io.File(".")).listFiles
def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for (file <- filesHere
       if file.getName.endsWith(".xml");
       line <- fileLines(file)
       if line.trim.matches(pattern)
       ) println(file + ": " + line.trim)

grep("a");

def onlyXmlFile(fileType: String) ={
  for {
    file <- filesHere
    if file.getName.endsWith(fileType)
  } yield file
}

onlyXmlFile("xml")

// test Exception Handling
try {
  val file = new FileReader("/duc_tv/IdeaProjects/scalar_test/app/views/test.sc")
  val content = file.toString
  print(content)
} catch {
  case ex: FileNotFoundException => throw new ArrayIndexOutOfBoundsException
  case ex: IOException =>  print("inOut")
} finally {
  print("closed")
}

//test match
val arg = 3
val transfer = arg match {
  case 1 => "mot"
  case 2 => "two"
  case _ => "other"
}
transfer

//tetPackage

val me =new NormalUser
me.printName("duc")


