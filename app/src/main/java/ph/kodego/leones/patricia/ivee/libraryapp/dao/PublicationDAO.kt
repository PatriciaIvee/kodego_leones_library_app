package ph.kodego.leones.patricia.ivee.libraryapp.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.Publication
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.PublicationAuthors
import ph.kodego.leones.patricia.ivee.libraryapp.model.publications.PublicationStatus
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

interface PublicationDAO {
    fun getPublications(): ArrayList<Publication>
    fun getPublicationType(): ArrayList<Publication>
    fun getPublicationWithAuthors(publicationAuthorId:Int):ArrayList<PublicationAuthors>
    fun addPublication(publication: Publication)
    fun borrowPublication(publication: Publication)
    fun returnPublication(publication: Publication)
    fun deletePublication(publication: Publication)
}
class PublicationDAOSQLImpl(var context: Context): PublicationDAO{

    override fun addPublication(publication: Publication) {
//        Create DatabaseHandler for writing and reading
        var databaseHandler: DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.title, publication.publicationTitle)
        contentValues.put(DatabaseHandler.publicationType, publication.publicationType)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dateString = dateFormat.format(publication.datePublished)
        contentValues.put(DatabaseHandler.datePublished, dateString)

        contentValues.put(DatabaseHandler.pubStatus, publication.publicationStatus.toString())

        val success = db.insert(DatabaseHandler.tablePublication,null,contentValues)
//        Always close after use because it will cause memory build up
        db.close()


    }

    override fun borrowPublication(publication: Publication) {
        var databaseHandler: DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()

        contentValues.put(DatabaseHandler.pubStatus, PublicationStatus.BORROWED.toString())

       val values =  arrayOf("${publication.publicationId}")
        val success = db.update(
            DatabaseHandler.tablePublication,
            contentValues,
            "${DatabaseHandler.pubStatus} = ?",
            values,

        )
        db.close()
    }

    override fun returnPublication(publication: Publication) {
        var databaseHandler: DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        // Return Book and it is available to be borrowed again
        contentValues.put(DatabaseHandler.pubStatus, PublicationStatus.AVAILABLE.toString())

        val values =  arrayOf("${publication.publicationId}")
        val success = db.update(
            DatabaseHandler.tablePublication,
            contentValues,
            "${DatabaseHandler.pubStatus} = ?",
            values,

            )
        db.close()
    }

    override fun deletePublication(publication: Publication) {
        var databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val values = arrayOf("${publication.publicationId}")
        val success = db.delete(DatabaseHandler.tablePublication,
            "${DatabaseHandler.publicationId} = ?",
            values)
        db.close()
    }


    override fun getPublications(): ArrayList<Publication> {
        val publicationList :ArrayList<Publication> = ArrayList()
        val selectQuery = "SELECT ${DatabaseHandler.publicationId}, " +
                "${DatabaseHandler.publicationType}, " +
                "${DatabaseHandler.title}, " +
                "${DatabaseHandler.datePublished}, " +
                "${DatabaseHandler.pubStatus} " +
                "FROM ${DatabaseHandler.tablePublication}"

        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: SQLiteException) {
            db.close()
            return ArrayList()
        }

        var publication = Publication()
        if (cursor.moveToFirst()) {
            do {
                publication = Publication()
                publication.publicationId = cursor.getInt(0)
                publication.publicationType = cursor.getString(1)
                publication.publicationTitle = cursor.getString(2)

                val date = java.sql.Date.valueOf(cursor.getString(3))
                publication.datePublished = date

                val statusString = cursor.getString(4)
                publication.publicationStatus =
                    when(statusString) {
                    "BORROWED" -> PublicationStatus.BORROWED
                    "AVAILABLE" -> PublicationStatus.AVAILABLE
                    "DAMAGED" -> PublicationStatus.DAMAGED
                    else -> PublicationStatus.UNSPECIFIED
                }

                publicationList.add(publication)

            }while (cursor.moveToNext())
        }

        db.close()
        return publicationList
    }

    override fun getPublicationType(): ArrayList<Publication> {
        val publicationList: ArrayList<Publication> = ArrayList()
//        Find string in the columns (search)
        val columns  = arrayOf(DatabaseHandler.publicationId,
            DatabaseHandler.publicationType,
            DatabaseHandler.title,
            DatabaseHandler.datePublished,
            DatabaseHandler.pubStatus)

        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null

        try {
//            Search through query(DAtabase) realtime database
            cursor = db.query(DatabaseHandler.tablePublication,
                columns,
//                parang wild search
                "${DatabaseHandler.publicationType} =  ?",
                null,
                null,
                null,
                DatabaseHandler.title
            )
        }catch (e:SQLiteException) {
            db.close()
            return ArrayList()
        }

        var publication = Publication()
        if (cursor.moveToFirst()) {
            do {
                publication = Publication()
                publication.publicationId = cursor.getInt(0)
                publication.publicationType = cursor.getString(1)
                publication.publicationTitle = cursor.getString(2)

                val date = java.sql.Date.valueOf(cursor.getString(3))
                publication.datePublished = date

                val statusString = cursor.getString(4)
                publication.publicationStatus =
                    when(statusString) {
                        "BORROWED" -> PublicationStatus.BORROWED
                        "AVAILABLE" -> PublicationStatus.AVAILABLE
                        "DAMAGED" -> PublicationStatus.DAMAGED
                        else -> PublicationStatus.UNSPECIFIED
                    }

                publicationList.add(publication)

            }while (cursor.moveToNext())
        }


        db.close()
        return publicationList
    }

    override fun getPublicationWithAuthors(publicationAuthorId: Int): ArrayList<PublicationAuthors> {
        val publicationAuthorsList: ArrayList<PublicationAuthors> = ArrayList()

        val databaseHandler:DatabaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var cursor: Cursor? = null



        val selectQuery = "SELECT ${DatabaseHandler.publicationId}, " +
                "${DatabaseHandler.publicationType}, " +
                "${DatabaseHandler.title}, " +
                "${DatabaseHandler.datePublished}, " +
                "${DatabaseHandler.pubStatus} " +
                "FROM ${DatabaseHandler.tablePublication}"



        try {
            cursor = db.rawQuery(selectQuery,null)
        }catch (e:SQLiteException) {
            db.close()
            return ArrayList()
        }

        var publicationAuthors = PublicationAuthors()
        if (cursor.moveToFirst()) {
            do {
                var publication = Publication()
                publicationAuthors = PublicationAuthors()
//                publicationAuthorsList = publicationAuthors()
                publication.publicationId = cursor.getInt(0)
                publication.publicationType = cursor.getString(1)
                publication.publicationTitle = cursor.getString(2)

                val date = java.sql.Date.valueOf(cursor.getString(3))
                publication.datePublished = date

                val statusString = cursor.getString(4)
                publication.publicationStatus =
                    when(statusString) {
                        "BORROWED" -> PublicationStatus.BORROWED
                        "AVAILABLE" -> PublicationStatus.AVAILABLE
                        "DAMAGED" -> PublicationStatus.DAMAGED
                        else -> PublicationStatus.UNSPECIFIED
                    }
                publicationAuthors.publication = publication

                publicationAuthorsList.add(publicationAuthors)

            }while (cursor.moveToNext())
        }
        db.close()

        var authorDAO = AuthorDAOSQLImpl(context)
//        Use Either one of these codes to retrieve data from another table
        for(publicationAuthor in publicationAuthorsList){
            publicationAuthor.authors = authorDAO.getAuthors(publicationAuthor.publication.publicationId)
        }

        for (index in 0 until publicationAuthorsList.size){
            publicationAuthorsList[index].authors = authorDAO.getAuthors(publicationAuthorsList[index].publication.publicationId)
        }

        db.close()
        return publicationAuthorsList
    }


}
