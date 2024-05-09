package w.cati.factsaboutcats.data.repository

import w.cati.factsaboutcats.data.remote.FactsApi
import w.cati.factsaboutcats.data.remote.dto.FactsDto
import w.cati.factsaboutcats.domain.repository.FactRepository
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val api: FactsApi
): FactRepository {

    override suspend fun getFacts(): FactsDto {
        return api.getFacts()
    }

}