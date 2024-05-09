package w.cati.factsaboutcats.presentation.favorite.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import w.cati.factsaboutcats.domain.use_case.FactUseCases
import w.cati.factsaboutcats.presentation.facts.state.FactsState
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val factUseCases: FactUseCases
) : ViewModel() {

    private val _state = mutableStateOf(FactsState())
    val state: State<FactsState> = _state

    init {
        getFacts()
    }

    fun getFacts() {
        factUseCases.getFactsFromDBUseCase().onEach { facts ->
            _state.value = state.value.copy(
                facts = facts
            )
        }
            .launchIn(viewModelScope)
    }


}