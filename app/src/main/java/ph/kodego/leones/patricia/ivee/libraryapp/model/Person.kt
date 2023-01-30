package ph.kodego.leones.patricia.ivee.libraryapp.model

open class Person(var personFirstName:String = "", var personLastName: String = "") {
    var personId = 0
}

class Author( personFirstName:String , personLastName: String): Person(personFirstName, personLastName) {
    var authorId = 0
}

class Illustrator( personFirstName:String , personLastName: String): Person(personFirstName, personLastName) {
    var illustratorId = 0
}