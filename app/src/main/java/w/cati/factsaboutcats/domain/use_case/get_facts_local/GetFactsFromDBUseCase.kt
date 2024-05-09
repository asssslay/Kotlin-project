package w.cati.factsaboutcats.domain.use_case.get_facts_local

import kotlinx.coroutines.flow.Flow
import w.cati.factsaboutcats.domain.model.Fact
import w.cati.factsaboutcats.domain.repository.FactsRepositoryDB

class GetFactsFromDBUseCase(
    private val repositoryDB: FactsRepositoryDB
) {
    operator fun invoke(): Flow<List<Fact>> {
        return repositoryDB.getFacts()
    }
}