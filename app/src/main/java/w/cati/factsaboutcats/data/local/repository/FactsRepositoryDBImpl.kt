package w.cati.factsaboutcats.data.local.repository

import kotlinx.coroutines.flow.Flow
import w.cati.factsaboutcats.data.local.FactDao
import w.cati.factsaboutcats.domain.model.Fact
import w.cati.factsaboutcats.domain.repository.FactsRepositoryDB

class FactsRepositoryDBImpl(
    private val dao: FactDao
) : FactsRepositoryDB {
    override fun getFacts(): Flow<List<Fact>> {
        return dao.getFacts()
    }

    override suspend fun insertFact(fact: Fact) {
        return dao.insertFact(fact)
    }
}