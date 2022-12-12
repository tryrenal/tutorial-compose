package com.redveloper.tutorialcompose.ui.detail

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.redveloper.tutorialcompose.R
import com.redveloper.tutorialcompose.data.local.entity.NewsEntity
import com.redveloper.tutorialcompose.ui.ViewModelFactory

class NewsDetailActivity : AppCompatActivity() {


    private lateinit var newsDetail: NewsEntity
    private val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
    private val viewModel: NewsDetailViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsDetail = intent.getParcelableExtra<NewsEntity>(NEWS_DATA) as NewsEntity

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NewsDetailScreen(newsDetail = newsDetail, viewModel = viewModel)
                }
            }
        }
    }


    companion object {
        const val NEWS_DATA = "data"
    }
}

@Composable
fun NewsDetailContent(
    title: String,
    url: String,
    bookmarkStatus: Boolean,
    updateBookmarkStatus: () -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    IconButton(
                        onClick = updateBookmarkStatus
                    ) {
                        Icon(
                            painter = if (bookmarkStatus){
                                painterResource(id = R.drawable.ic_bookmarked_white)
                            } else {
                                painterResource(id = R.drawable.ic_bookmark_white)
                            },
                            contentDescription = null
                        )
                    }
                },
            )
        },
        modifier = modifier
    ){ innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()){
            AndroidView(
                factory = {
                    WebView(it).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        webViewClient = WebViewClient()
                        loadUrl(url)
                    }
                },
                update = {
                    it.loadUrl(url)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsDetailContentPreview(){
    MaterialTheme() {
        NewsDetailContent(
            title = "New News",
            url = "",
            bookmarkStatus = false,
            updateBookmarkStatus = {})
    }
}

@Composable
fun NewsDetailScreen(
    newsDetail: NewsEntity,
    viewModel: NewsDetailViewModel
){
    viewModel.setNewsData(newsDetail)
    val boomarkStatus by viewModel.bookmarkStatus.observeAsState(false)
    NewsDetailContent(
        title = newsDetail.title,
        url = newsDetail.url.toString(),
        bookmarkStatus = boomarkStatus,
        updateBookmarkStatus = {
            viewModel.changeBookmark(newsDetail)
        }
    )
}