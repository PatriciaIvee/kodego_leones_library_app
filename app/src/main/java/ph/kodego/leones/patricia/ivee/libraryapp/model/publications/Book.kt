package ph.kodego.leones.patricia.ivee.libraryapp.model.publications

import ph.kodego.leones.patricia.ivee.libraryapp.R

class Book(title: String): Publication(title) {
//    (var bookTitle: String = "Unknown", var bookAuthor: String = "Unknown", var img: Int)
    var bookId: Int  = 0
//    var publicationId: Int = 0
    var isbn10number: String = ""
    var isbn13number: String = ""
    var authors: ArrayList<Author> = ArrayList()
    var illustrator: ArrayList<Illustrator> = ArrayList()
    var publisherId: Int = 0


    constructor() : this("Unknown", ArrayList(), 0)
    constructor(title: String, authors: ArrayList<Author>, img : Int) : this(title) {
        this.publicationTitle = title
        this.img = R.drawable.book
        this.authors = authors
    }




}
