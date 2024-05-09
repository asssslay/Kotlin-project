package w.cati.factsaboutcats.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import w.cati.factsaboutcats.R

@Entity
data class Fact(
    @PrimaryKey(autoGenerate = false)
    val fact: String,
    val image: Int? = null
)
