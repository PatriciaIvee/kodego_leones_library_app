package ph.kodego.leones.patricia.ivee.libraryapp.model.publications

open class Person() {
    var personFirstName:String = ""
    var personLastName: String = ""
    var personId = 0

    constructor(firstName: String, lastName:String) : this() {
        this.personFirstName = firstName
        this.personLastName = lastName
    }

}

class Author(){
    var personFirstName:String = ""
    var personLastName: String = ""
    var authorId = 0
    var publicationAuthorId = 0

    constructor(firstName: String, lastName:String) : this() {
        this.personFirstName = firstName
        this.personLastName = lastName
    }
}

class Illustrator(): Person() {
    var illustratorId = 0
    var publicationId = 0
}