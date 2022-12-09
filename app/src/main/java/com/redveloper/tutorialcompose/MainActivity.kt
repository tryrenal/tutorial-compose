package com.redveloper.tutorialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redveloper.tutorialcompose.ui.theme.TutorialComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialComposeTheme {
                HelloJetpackComposableApp()
            }
        }
    }
}

private val listName = listOf(
    "Renal", "Sabdo", "Jati", "Purboningrat"
)


@Composable
fun HelloJetpackComposableApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
        HelloJetpackPreview()
    }
}

@Composable
fun GreetingList(items: List<String>){
    if (items.isNotEmpty()){
        Column {
            for (name in items){
                Greeting(name = name)
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    } else {
        Text(text = "No list Name")
    }
}

@Composable
fun Greeting(name: String) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Image(painter = painterResource(id = R.drawable.ic_android),
            contentDescription = null,
            modifier = Modifier.size(width = 40.dp, height = 40.dp)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Column {
            Text(text = "Hello $name!",
                fontSize = 10.sp,
                color = Color.Green)
            Text(text = "Selamat Malam",
                fontWeight = FontWeight.Bold
            )
        }
        IconButton(onClick = { isExpanded = !isExpanded}) {
            Icon(imageVector =
             if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorialComposeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun HelloJetpackPreview(){
    TutorialComposeTheme {
        GreetingList(items = listName)
    }
}