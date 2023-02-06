package ph.kodego.leones.patricia.ivee.libraryapp.model.account

import ph.kodego.leones.patricia.ivee.libraryapp.R

class Account(var AccountUserName:String = "Unknown", var AccountPassword:String = "Unknown", var img:Int) {

    var accountId: Int = 0
    var yearStarted: Int = 0
    var course: String = ""

    //    constructor for default values (firstname, lastname, profile picture)
    constructor(): this("","", R.drawable.book)

}

class AccountInfo(var firstName: String = "", var lastName :String = ""){
    var accountInfoId :Int = 0
    var accountId : Int = 0
    var emailAddress: String = ""

}