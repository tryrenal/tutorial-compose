package com.redveloper.tutorialcompose.model

import com.redveloper.tutorialcompose.R

object FakeBookDataSource {
    val _dummyDesc = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
    val dummyBooks = listOf(
        BookModel(id = 1, image = R.drawable.book_1, title = R.string.title_book_1, description = R.string.desc_book_1, author = R.string.author_book_1),
        BookModel(id = 2, image = R.drawable.book_2, title = R.string.title_book_2, description = R.string.desc_book_2,author = R.string.author_book_2),
        BookModel(id = 3, image = R.drawable.book_3, title = R.string.title_book_3, description = R.string.desc_book_3, author = R.string.author_book_3),
        BookModel(id = 4, image = R.drawable.book_4, title = R.string.title_book_4, description = R.string.desc_book_4, author = R.string.author_book_4),
        BookModel(id = 5, image = R.drawable.book_5, title = R.string.title_book_5, description = R.string.desc_book_5, author = R.string.author_book_5),
        BookModel(id = 6, image = R.drawable.book_6, title = R.string.title_book_6, description = R.string.desc_book_6, author = R.string.author_book_6),
        BookModel(id = 7, image = R.drawable.book_7, title = R.string.title_book_7, description = R.string.desc_book_7, author = R.string.author_book_7),
        BookModel(id = 8, image = R.drawable.book_8, title = R.string.title_book_8, description = R.string.desc_book_8, author = R.string.author_book_8),
        BookModel(id = 9, image = R.drawable.book_9, title = R.string.title_book_9, description = R.string.desc_book_9, author = R.string.author_book_9),
        BookModel(id = 10, image = R.drawable.book_10, title = R.string.title_book_10, description = R.string.desc_book_10, author = R.string.author_book_10),
    )
}