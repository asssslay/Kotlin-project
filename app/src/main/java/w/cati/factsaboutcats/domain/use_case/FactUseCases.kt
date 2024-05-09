package w.cati.factsaboutcats.domain.use_case

import w.cati.factsaboutcats.domain.use_case.get_facts_local.GetFactsFromDBUseCase
import w.cati.factsaboutcats.domain.use_case.get_facts_remote.GetFactsUseCase
import w.cati.factsaboutcats.domain.use_case.insert_fact_local.InsertFactUseCase


data class FactUseCases (
    val getCoinUseCase: GetFactsUseCase,
    val insertFactUseCase: InsertFactUseCase,
    val getFactsFromDBUseCase: GetFactsFromDBUseCase
)