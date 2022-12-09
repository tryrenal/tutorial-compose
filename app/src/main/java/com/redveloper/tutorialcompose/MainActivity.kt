package com.redveloper.tutorialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
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
fun GreetingList(names: List<String>){
    if (names.isNotEmpty()){
        /*
        for kurang cocok karena dia akan membuat item sebanyak panjang list

        Column {
            for (name in items){
                Greeting(name = name)
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
        * */

        LazyColumn{
            items(names){ name ->
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
    val animateSizeDp by animateDpAsState(targetValue = if (isExpanded) 80.dp else 40.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessLow
        ))
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painter = painterResource(id = R.drawable.ic_android),
                contentDescription = null,
                modifier = Modifier.size(animateSizeDp),
            )
            Spacer(modifier = Modifier.size(5.dp))
            Column(modifier = Modifier.weight(1f)) {
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
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorialComposeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HelloJetpackPreview(){
    TutorialComposeTheme {
        GreetingList(names = listName)
    }
}