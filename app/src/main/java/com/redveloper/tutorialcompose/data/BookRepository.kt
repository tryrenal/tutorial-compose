package com.redveloper.tutorialcompose.data

import com.redveloper.tutorialcompose.model.BookModel
import com.redveloper.tutorialcompose.model.FakeBookDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BookRepository {
    private val listBook = mutableListOf<BookModel>()

    init {
        if (listBook.isEmpty()){
            FakeBookDataSource.dummyBooks.forEach{
                listBook.add(it)
            }
        }
    }

    fun getListBook(): Flow<List<BookModel>>{
        return flowOf(listBook)
    }

    companion object{
        @Volatile
        private var instance: BookRepository? = null

        fun getInstance(): BookRepository =
            instance ?: synchronized(this){
                BookRepository().apply {
                    instance = this
                }
            }
    }
}