package w.cati.factsaboutcats.domain.use_case.insert_fact_local

import kotlinx.coroutines.flow.Flow
import w.cati.factsaboutcats.domain.model.Fact
import w.cati.factsaboutcats.domain.repository.FactsRepositoryDB

class InsertFactUseCase(
    private val repositoryDB: FactsRepositoryDB
) {
    suspend operator fun invoke(fact: Fact) {
        return repositoryDB.insertFact(fact)
    }
}