package w.cati.factsaboutcats.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import w.cati.factsaboutcats.domain.model.Fact

@Dao
interface FactDao {
    @Query("SELECT * FROM fact")
    fun getFacts(): Flow<List<Fact>>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertFact(fact: Fact)

}