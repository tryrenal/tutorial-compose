package com.redveloper.tutorialcompose.model

import com.redveloper.tutorialcompose.R

object FakeBookDataSource {
    val _dummyDesc = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
    val dummyBooks = listOf(
        BookModel(id = 1, image = R.drawable.book_1, title = "Book Number 1", description = _dummyDesc, author = "Renaldy Sabdo 1"),
        BookModel(id = 2, image = R.drawable.book_2, title = "Book Number 2", description = _dummyDesc,author = "Renaldy Sabdo 2"),
        BookModel(id = 3, image = R.drawable.book_3, title = "Book Number 3", description = _dummyDesc, author = "Renaldy Sabdo 3"),
        BookModel(id = 4, image = R.drawable.book_4, title = "Book Number 4", description = _dummyDesc, author = "Renaldy Sabdo 4"),
        BookModel(id = 5, image = R.drawable.book_5, title = "Book Number 5", description = _dummyDesc, author = "Renaldy Sabdo 5"),
        BookModel(id = 6, image = R.drawable.book_6, title = "Book Number 6", description = _dummyDesc, author = "Renaldy Sabdo 6"),
        BookModel(id = 7, image = R.drawable.book_7, title = "Book Number 7", description = _dummyDesc, author = "Renaldy Sabdo 7"),
        BookModel(id = 8, image = R.drawable.book_8, title = "Book Number 8", description = _dummyDesc, author = "Renaldy Sabdo 8"),
        BookModel(id = 9, image = R.drawable.book_9, title = "Book Number 9", description = _dummyDesc, author = "Renaldy Sabdo 9"),
        BookModel(id = 10, image = R.drawable.book_10, title = "Book Number 10", description = _dummyDesc, author = "Renaldy Sabdo 10"),
    )
}