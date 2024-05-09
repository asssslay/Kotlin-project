package w.cati.factsaboutcats.presentation.facts.state

import w.cati.factsaboutcats.domain.model.Fact

data class FactsState(
    val isLoading: Boolean = false,
    val facts: List<Fact> = emptyList(),
    val error: String = ""

)