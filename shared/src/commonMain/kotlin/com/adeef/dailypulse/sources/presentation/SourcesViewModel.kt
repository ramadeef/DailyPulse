package com.adeef.dailypulse.sources.presentation

import com.adeef.dailypulse.BaseViewModel
import com.adeef.dailypulse.sources.domain.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel (
    private val useCase: SourcesUseCase
): BaseViewModel() {
    private val _sourcesState: MutableStateFlow<SourcesState> = MutableStateFlow(SourcesState(loading = true))

    val sourcesState : StateFlow<SourcesState> get() = _sourcesState


    init {

        getSources()
    }
    fun getSources(forceFetch: Boolean = false){
        scope.launch{

            _sourcesState.emit(SourcesState(loading = true,  sources  = _sourcesState.value.sources))

            val fetchedSources = useCase.getSources(forceFetch)

            _sourcesState.emit(SourcesState(sources = fetchedSources))
        }
    }


}


