package ph.kodego.leones.patricia.ivee.libraryapp.model

import ph.kodego.leones.patricia.ivee.libraryapp.R

class Book(var bookTitle:String = "Unknown", var bookAuthor: String = "Unknown", var img: Int) {
    constructor(): this("","", R.drawable.book)
}