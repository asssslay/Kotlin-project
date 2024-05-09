package w.cati.factsaboutcats.domain.repository

import w.cati.factsaboutcats.data.remote.dto.FactsDto

interface FactRepository {
    suspend fun getFacts(): FactsDto
}