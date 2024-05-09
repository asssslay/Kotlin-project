package w.cati.factsaboutcats.presentation.favorite.state

import w.cati.factsaboutcats.domain.model.Fact

data class FavoriteState(
    val facts: List<Fact> = emptyList()
)