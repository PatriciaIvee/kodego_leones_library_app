package ph.kodego.leones.patricia.ivee.libraryapp.model

open class Person(var personFirstName:String = "", var personLastName: String = "") {
}

class Author( personFirstName:String , personLastName: String): Person(personFirstName, personLastName) {
}

class Illustrator( personFirstName:String , personLastName: String): Person(personFirstName, personLastName) {
}