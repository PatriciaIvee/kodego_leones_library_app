package ph.kodego.leones.patricia.ivee.libraryapp.dao

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.Author

interface AuthorDAO {
    fun getAuthors(publicationId:Int):ArrayList<Author>
}

class AuthorDAOSQLImpl(var context: Context): AuthorDAO {
    override fun getAuthors(publicationId: Int): ArrayList<Author> {
        val authorList: ArrayList<Author> = ArrayList()
        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null


        // DATABASE AUTHOR TABLE
        val columns  = arrayOf(DatabaseHandler.authorId,
            DatabaseHandler.publicationId,
            DatabaseHandler.firstNamePerson,
            DatabaseHandler.lastNamePerson)

        try {
//            Search through query(DAtabase) realtime database
            cursor = db.query(DatabaseHandler.tablePublication,
                columns,
//               exact search of finding student's contact
                "${DatabaseHandler.publicationId} = '${publicationId}'",
                null,
                null,
                null,
                null
            )
        }catch (e: SQLiteException) {
            db.close()
            return ArrayList()
        }

        var author = Author()
        if (cursor.moveToFirst()) {
            do {
                author = Author()
                author.authorId = cursor.getInt(0)
                author.publicationId = cursor.getInt(1)
                author.personFirstName = cursor.getString(2)
                author.personLastName = cursor.getString(3)

                authorList.add(author)

            }while (cursor.moveToNext())
        }

        db.close()
        return authorList
    }

}