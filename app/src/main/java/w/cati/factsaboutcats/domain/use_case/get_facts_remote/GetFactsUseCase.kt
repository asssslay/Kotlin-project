package w.cati.factsaboutcats.domain.use_case.get_facts_remote


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import w.cati.factsaboutcats.common.Resource
import w.cati.factsaboutcats.data.remote.dto.toFact
import w.cati.factsaboutcats.domain.model.Fact
import w.cati.factsaboutcats.domain.repository.FactRepository
import java.io.IOException

class GetFactsUseCase(
    private val repository: FactRepository
) {
    operator fun invoke(): Flow<Resource<List<Fact>>> = flow {
        try {
            emit(Resource.Loading())
                val facts = mutableListOf<Fact>()
                for (i in 1..10) {
                    facts.add(repository.getFacts().toFact())
                }
                emit(Resource.Success(facts))

        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown Error"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}