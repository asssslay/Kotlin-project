package w.cati.factsaboutcats.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import w.cati.factsaboutcats.domain.model.Fact


@Database(
    entities = [
        Fact::class
    ],
    version = 2
)
abstract class FactsDatabase: RoomDatabase() {
    abstract val factDao: FactDao

    companion object{
        const val DATABASE_NAME = "facts_db"
    }
}