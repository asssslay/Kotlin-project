package w.cati.factsaboutcats.presentation.facts.viewmodel


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import w.cati.factsaboutcats.common.Resource
import w.cati.factsaboutcats.domain.model.Fact
import w.cati.factsaboutcats.domain.use_case.FactUseCases
import w.cati.factsaboutcats.presentation.facts.state.FactsState
import javax.inject.Inject

@HiltViewModel
class FactsViewModel @Inject constructor(
    private val factUseCases: FactUseCases
) : ViewModel() {

    private val _state = mutableStateOf(FactsState())
    val state: State<FactsState> = _state

    init {
       getFacts()
    }


    fun onSwipeRight(item: Fact){
        viewModelScope.launch {
            factUseCases.insertFactUseCase(item)
        }
        val list = _state.value.facts.toMutableList()
        list.remove(item)
        if (_state.value.facts.size < 6) {
            getFacts()
        }
        _state.value = state.value.copy(
            facts = list
        )
    }
    fun onSwipeLeft(item: Fact){
        val list = _state.value.facts.toMutableList()
        list.remove(item)
        if (_state.value.facts.size < 6) {
            getFacts()
        }
        _state.value = state.value.copy(
            facts = list
        )
    }



    fun getFacts() {
        factUseCases.getCoinUseCase().onEach { result ->
            when (result){
                is Resource.Success -> {
                    val newList = result.data ?: emptyList()
                    _state.value = state.value.copy(
                        facts = _state.value.facts + newList
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        error = result.message ?: "Unknown error"
                    )
                }
                is Resource.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
            }

        }
            .launchIn(viewModelScope)
    }
}