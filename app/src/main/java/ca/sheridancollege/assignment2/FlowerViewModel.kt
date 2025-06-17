package ca.sheridancollege.assignment2


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.sheridancollege.assignment2.data.Flower
import ca.sheridancollege.assignment2.repository.FlowerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class FlowerViewModel @Inject constructor(
    private val repo: FlowerRepository
) : ViewModel() {

    sealed interface UiState {
        object Loading : UiState
        data class Success(val flowers: List<Flower>) : UiState
        data class Error(val msg: String) : UiState
    }

    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set

    init { fetch() }

    private fun fetch() = viewModelScope.launch {
        uiState = try {
            UiState.Success(repo.loadFlowers())
        } catch (e: Exception) {
            UiState.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}