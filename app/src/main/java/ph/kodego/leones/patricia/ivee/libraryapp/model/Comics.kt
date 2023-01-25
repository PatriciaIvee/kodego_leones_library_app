package ph.kodego.leones.patricia.ivee.libraryapp.model

import ph.kodego.leones.patricia.ivee.libraryapp.R

class Comics(title : String):Publication(title) {
    var comicsId : Int = 0
    var isbn10number : String = ""
    var isbn13number : String = ""
    var authors: ArrayList<Author> = ArrayList()
    var illustrators: ArrayList<Illustrator> = ArrayList()

    constructor(title: String,authors: ArrayList<Author>) : this(title) {
        this.title = title
        this.img = R.drawable.book
        this.authors = authors
    }
}