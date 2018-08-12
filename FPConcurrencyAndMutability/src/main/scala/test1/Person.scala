package test1

class Person(
        var name: String,
        var town: String,
        var state: String
) {
  override def toString = s"name: $name, town: $town, state: $state"
}
