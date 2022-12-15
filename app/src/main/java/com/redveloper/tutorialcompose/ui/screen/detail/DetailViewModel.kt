package com.redveloper.tutorialcompose.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redveloper.tutorialcompose.data.BookRepository
import com.redveloper.tutorialcompose.model.BookModel
import com.redveloper.tutorialcompose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: BookRepository
) : ViewModel(){
    private val _uiState: MutableStateFlow<UiState<BookModel>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<BookModel>>
        get() = _uiState

    fun getBookById(bookId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getBookById(bookId))
        }
    }
}