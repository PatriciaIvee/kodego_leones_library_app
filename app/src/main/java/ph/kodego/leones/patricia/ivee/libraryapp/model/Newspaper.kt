package ph.kodego.leones.patricia.ivee.libraryapp.model

import ph.kodego.leones.patricia.ivee.libraryapp.R

class Newspaper(title: String):Publication(title)  {
//    (var magazineTitle:String = "Unknown", var magazinePublisher: String = "Unknown", var img: Int)

    var newspaperId: Int = 0
    var publisherId: Int = 0
}