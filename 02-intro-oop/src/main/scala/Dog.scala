class Dog(name: String):
  def talk(): Unit =
    println(s"$name: guau")

@main def dogMain(): Unit =
  val dog1 = new Dog("Alexander")
  dog1.talk()
  val dog2 = Dog("Bond")
  dog2.talk()
