package ca.sheridancollege.assignment2

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FlowerApp(viewModel: FlowerViewModel = hiltViewModel()) {
    when (val state = viewModel.uiState) {
        FlowerViewModel.UiState.Loading      -> LoadingScreen()
        is FlowerViewModel.UiState.Error     -> ErrorScreen(state.msg)
        is FlowerViewModel.UiState.Success   -> FlowerList(state.flowers)
    }
}