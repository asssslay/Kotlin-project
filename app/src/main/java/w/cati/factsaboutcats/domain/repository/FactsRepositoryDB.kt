package w.cati.factsaboutcats.domain.repository

import kotlinx.coroutines.flow.Flow
import w.cati.factsaboutcats.domain.model.Fact

interface FactsRepositoryDB {

    fun getFacts(): Flow<List<Fact>>

    suspend fun insertFact(fact: Fact)
}