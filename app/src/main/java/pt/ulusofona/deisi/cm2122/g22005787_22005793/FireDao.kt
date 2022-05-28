package pt.ulusofona.deisi.cm2122.g22005787_22005793

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FireDao {

    @Insert
    suspend fun insert(fire: FireRoom)

    @Query("SELECT * FROM fires ORDER BY data ASC")
    suspend fun getAll(): List<FireRoom>

    @Query("SELECT * FROM fires WHERE id = :id")
    suspend fun getById(id: String): FireRoom

    @Query("DELETE FROM fires WHERE id = :id")
    suspend fun delete(id: String): Int
}