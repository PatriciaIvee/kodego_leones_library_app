package ph.kodego.leones.patricia.ivee.libraryapp.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import android.util.Log
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.Author

interface AuthorDAO {
    fun getAuthors(publicationId:Int):ArrayList<Author>
    fun addAuthor(author: Author)
    fun addAuthors(authors: ArrayList<Author>)
    fun updateAuthor(author: Author)
    fun deleteAuthor(authorId: Int)
}

class AuthorDAOSQLImpl(var context: Context): AuthorDAO {

    override fun addAuthor(author: Author) {
        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.publicationAuthorId, author.publicationAuthorId)
        contentValues.put(DatabaseHandler.firstNamePerson, author.personFirstName)
        contentValues.put(DatabaseHandler.lastNamePerson, author.personLastName)

        val success = db.insert(DatabaseHandler.tableAuthors,null,contentValues)
        db.close()
    }

    override fun addAuthors(authors: ArrayList<Author>) {
        for (author in authors) {
            addAuthor(author)
        }

    }
    override fun getAuthors(publicationId: Int): ArrayList<Author> {
        val authorList: ArrayList<Author> = ArrayList()
        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null


        // DATABASE AUTHOR TABLE
        val columns = arrayOf(DatabaseHandler.authorId,
            DatabaseHandler.publicationId,
            DatabaseHandler.firstNamePerson,
            DatabaseHandler.lastNamePerson)

        try {
//            Search through query(DAtabase) realtime database
            cursor = db.query(DatabaseHandler.tableAuthors,
                columns,
//               exact search of finding student's contact
                "${DatabaseHandler.authorId} = '${publicationId}'",
                null,
                null,
                null,
                null
            )
        }catch (e: SQLiteException) {
            Log.e("ERROR", "SQL Author Dao GET AUTHORS:" + e.message)
            db.close()
            return ArrayList()
        }

        var author = Author()
        if (cursor.moveToFirst()) {
            do {
                author = Author()
                author.authorId = cursor.getInt(0)
                author.publicationAuthorId = cursor.getInt(1)
                author.personFirstName = cursor.getString(2)
                author.personLastName = cursor.getString(3)

                authorList.add(author)

            }while (cursor.moveToNext())
        }

        db.close()
        return authorList
    }


    override fun updateAuthor(author: Author) {
        var databaseHandler: DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase //Open Database as Writeable

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.publicationAuthorId, author.publicationAuthorId)
        contentValues.put(DatabaseHandler.firstNamePerson, author.personFirstName)
        contentValues.put(DatabaseHandler.lastNamePerson, author.personLastName)

        val values = arrayOf("${author.authorId}")
        val success = db.update(
            DatabaseHandler.tableAuthors,
            contentValues,
            "${DatabaseHandler.authorId} = ?",
            values
        )
        db.close()

    }

    override fun deleteAuthor(authorId: Int) {
        var databaseHandler: DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val values = arrayOf("$authorId")
        val success = db.delete(
            DatabaseHandler.tableAuthors,
            "${DatabaseHandler.authorId} = ?",
            values
        )
        db.close()

    }
}