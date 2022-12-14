package com.redveloper.tutorialcompose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redveloper.tutorialcompose.data.BookRepository
import com.redveloper.tutorialcompose.model.BookModel
import com.redveloper.tutorialcompose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: BookRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<BookModel>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<BookModel>>>
        get() = _uiState

    fun getListBook() {
        viewModelScope.launch {
            repository.getListBook()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { books ->
                    _uiState.value = UiState.Success(books)
                }
        }
    }
}