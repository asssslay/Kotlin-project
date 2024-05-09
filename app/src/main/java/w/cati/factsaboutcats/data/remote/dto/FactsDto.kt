package w.cati.factsaboutcats.data.remote.dto

import w.cati.factsaboutcats.common.Images
import w.cati.factsaboutcats.domain.model.Fact

data class FactsDto(
    val fact: String,
    val length: Int
)
fun FactsDto.toFact(): Fact {
    return Fact(
        fact = fact,
        image = Images.imageList.random()
    )
}