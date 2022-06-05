package pt.ulusofona.deisi.cm2122.g22005787_22005793

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FireDao {

    @Insert
    suspend fun insert(fire: FireRoom)

    @Insert
    suspend fun insertAll(operations: List<FireRoom>)

    @Query("SELECT * FROM fires ORDER BY data DESC")
    suspend fun getAll(): List<FireRoom>

    @Query("SELECT * FROM fires WHERE distrito = :distrito ORDER BY data DESC ")
    suspend fun getFromRegion(distrito: String): List<FireRoom>

    @Query("SELECT COUNT (*) FROM fires WHERE distrito = :distrito")
    suspend fun getFromRegionCount(distrito: String): Int

    @Query("SELECT * FROM fires WHERE id = :id")
    suspend fun getById(id: String): FireRoom

    @Query("DELETE FROM fires WHERE id = :id")
    suspend fun delete(id: String): Int

    @Query("DELETE FROM fires WHERE porConfirmar == 0")
    suspend fun deleteAll()
}