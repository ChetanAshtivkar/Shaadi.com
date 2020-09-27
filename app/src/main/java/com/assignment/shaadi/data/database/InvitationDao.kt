package com.assignment.shaadi.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.assignment.shaadi.data.database.models.Invitation

@Dao
interface InvitationDao {

    @Query("SELECT * FROM invitation")
    fun getAll(): LiveData<List<Invitation>>

    @Query("SELECT COUNT(db_id) FROM invitation")
    fun getRowCount(): Int

//    @Query("SELECT * FROM invitation LIMIT :limit OFFSET :offset")
//    fun getAllPaged(limit: Int, offset: Int): DataSource.Factory<Int, Invitation>

    @Query("SELECT * FROM invitation LIMIT :limit OFFSET :offset")
    fun getPaged(limit: Int, offset: Int): List<Invitation>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(picture: List<Invitation>)

    @Update
    fun updateInvitation(invitation: Invitation)

}
