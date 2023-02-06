package ph.kodego.leones.patricia.ivee.libraryapp.dao

import ph.kodego.leones.patricia.ivee.libraryapp.model.account.Account
import ph.kodego.leones.patricia.ivee.libraryapp.model.account.AccountInfo

interface AccountDAO {
    fun addAccount(account:Account)
    fun deleteAccount(account:Account)
    fun changeUserName(account: Account)
    fun changePassword(account: Account)
    fun updateAccountInfo(accountInfo: AccountInfo)
    fun searchAccount(account: Account)
}