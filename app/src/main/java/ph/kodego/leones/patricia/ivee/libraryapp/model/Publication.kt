package ph.kodego.leones.patricia.ivee.libraryapp.model

import ph.kodego.leones.patricia.ivee.libraryapp.R
import java.sql.Date

open class Publication {

    var publicationId: Int = 0
    var publicationType: String = ""
    var title :String = ""
    var img: Int = 0
    var datePublished = Date(0,0,0)
    var publicationstatus :String = PublicationStatus.UNSPECIFIED.toString()
    var accountId: Int = 0 // For the account that borrowed the book

    constructor(title: String){
        this.title = title
        this.img = R.drawable.book
    }

}

enum class PublicationStatus{
    AVAILABLE,
    BORROWED,
    DAMAGED,
    UNSPECIFIED
}