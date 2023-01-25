package ph.kodego.leones.patricia.ivee.libraryapp.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASENAME,null,DATABASEVERSION) {

    companion object {
        private val DATABASEVERSION = 1
        private val DATABASENAME = "publication_database"

        val tableAccount = "account_table"
        val accountId = "account_id"
        val userName = "user_name"
        val password  = "password"

        val tableUser = "user_table"
        val userId  = "user_id"
        val firstNameUser = "user_first_name"
        val lastNameUser = "user_last_name"
        val emailUser = "user_email"

        val tablePerson = "person_table"
        val personId = "person_id"
        val personType = "person_type"
        val firstNamePerson = "person_first_name"
        val lastNamePerson = "person_last_name"

        val tableAuthor = "author_table"
        val authorId = "author_id"
        val tableBookAuthor = "book_author_table"
        val bookAuthorId = "book_author_id"

//        personId

        val tableIllustrator = "illustrator_table"
        val illustratorId = "illustrator_id"
//        personId

        val tablePublisher = "publisher_table"
        val publisherId = "publisher_id"
        val publisherName = "publisher_name"
        val publisherAddress ="publisher_address"
        val dateEstablished = "date_established"

        val tablePublication = "publication_table"
        val publicationId ="publication_id"
        val publicationType = "publication_type"
        val title = "title"
        val datePublished = "date_published"
        val status = "status"
//        account_id



        val tableBooks = "book_table"
        val bookId = "book_id"
//        publicationId
        val isbn10Number = "isbn10_number"
        val isbn13Number = "isbn10_number"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATEPERSONSTABLE =
            "CREATE TABLE $tablePerson " +
                    "($personId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$personType TEXT, " +
                    "$firstNamePerson TEXT, " +
                    "$lastNamePerson TEXT)"
        db?.execSQL(CREATEPERSONSTABLE)

        db?.execSQL("INSERT into $tablePerson($personType,$firstNamePerson,$lastNamePerson)" +
                "values ('Author', 'Arthur', 'Abanico')")
        db?.execSQL("INSERT into $tablePerson($personType,$firstNamePerson,$lastNamePerson)" +
                "values ('Author', 'Juan', 'Carlos')")

        val CREATEAUTHORSTABLE =
            "CREATE TABLE $tableAuthor " +
                    "($authorId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FOREIGN KEY($personId) REFERENCES $tablePerson($personId))"
        db?.execSQL(CREATEAUTHORSTABLE)

        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (1)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (2)")

        val CREATEBOOKAUTHORSTABLE =
            "CREATE TABLE $tableBookAuthor " +
                    "($bookAuthorId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FOREIGN KEY($bookId) REFERENCES $tableBooks($bookId), " +
                    "FOREIGN KEY($authorId) REFERENCES $tableAuthor($authorId))"
        db?.execSQL(CREATEBOOKAUTHORSTABLE)

        db?.execSQL("INSERT into $tableBookAuthor($bookId,$authorId)" +
                "values (1,1)")
        db?.execSQL("INSERT into $tableAuthor($personId)" +
                "values (1,2)")


        val CREATEPUBLICATIONSTABLE =
            "CREATE TABLE $tablePublication " +
                    "($publicationId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$publicationType TEXT, " +
                    "$title TEXT, " +
                    "$datePublished DATE, " +
                    "$status TEXT, " +
                    "$accountId INTEGER)"
        db?.execSQL(CREATEPUBLICATIONSTABLE)

        db?.execSQL("INSERT into $tablePublication($publicationType,$title,$datePublished,$status,$accountId)" +
                " values ('Book','The Lovely Bones', '2004-04-20', 'UNSPECIFIED','' )")

        val CREATEBOOKSTABLE =
        "CREATE TABLE $tableBooks " +
                "($bookId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$isbn10Number TEXT, " +
                "$isbn13Number TEXT, " +
                "FOREIGN KEY ($publicationId) REFERENCES $tablePublication($publicationId), " +
                "FOREIGN KEY ($authorId) REFERENCES $tableAuthor($authorId))"
        db?.execSQL(CREATEBOOKSTABLE)

        db?.execSQL("INSERT into $tableBooks($isbn13Number, $publicationId, $authorId) " +
                "values ('ISBN 0000-123456789', 1, 1)")
    }

}