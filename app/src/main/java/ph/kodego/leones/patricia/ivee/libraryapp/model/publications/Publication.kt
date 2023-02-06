package ph.kodego.leones.patricia.ivee.libraryapp.model.publications

import ph.kodego.leones.patricia.ivee.libraryapp.R
import java.sql.Date

open class Publication(var publicationTitle: String = "", var img : Int) {

    var publicationId: Int = 0
    var publicationType: String = ""
    var datePublished = Date(0,0,0)
    var publicationStatus : PublicationStatus = PublicationStatus.UNSPECIFIED
    var accountId: Int = 0 // For the account that borrowed the book

    constructor(): this("", R.drawable.book)
    constructor(title: String) : this()
}


class PublicationAuthors(){
    var publication: Publication = Publication()
    var authors: ArrayList<Author> = ArrayList()
}

enum class PublicationStatus{
    AVAILABLE,
    BORROWED,
    DAMAGED,
    UNSPECIFIED
}