def sumAll(a: Int, b: Int): Int = {
  (a <= b) match {
    case true => (0 /: (a to b)) (_ + _)
    case false => sumAll(b, a)
  }
}
sumAll(4,1)


def timeConversion(a: String): String = {
  var split = a.split(":")
  if(split(0).equals("12") && split(2).endsWith("AM")) "00" + ":" + split(1) + ":" + split(2).substring(0,2)
  else if (split(2).endsWith("PM") && !split(0).equals("12")) (split(0).toInt + 12) + ":" + split(1) + ":" + split(2).substring(0,2)
  else split(0) + ":" + split(1) + ":" + split(2).substring(0,2)

}

timeConversion("07:05:45PM")
timeConversion("12:40:22AM")

def jumpingOnClouds(a: Array[Int]): Int = {
  val a1 = a.filter(b => b == 0).zipWithIndex.map(c => c._2)

}