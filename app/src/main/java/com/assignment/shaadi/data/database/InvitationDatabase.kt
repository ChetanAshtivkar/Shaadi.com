package com.assignment.shaadi.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.assignment.shaadi.data.database.models.Invitation

/**
 * Created by Chetan on 28/09/20.
 */
private const val DATABASE_NAME = "shaadi_db"

@Database(
    entities = [Invitation::class],
    version = 1,
    exportSchema = false
)
abstract class InvitationDatabase : RoomDatabase() {

    abstract fun invitationDao(): InvitationDao

    companion object {
        private var INSTANCE: InvitationDatabase? = null

        fun getInstance(context: Context): InvitationDatabase? {
            if (INSTANCE == null) {
                synchronized(InvitationDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        InvitationDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}