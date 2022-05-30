package com.navarronet.fcam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navarronet.fcam.ui.theme.FcamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FcamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    show_container()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun show_button() {
    Button(

        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        ),
        onClick = {
        //your onclick code here
    }) {


        Text(
            text = "Mostrar Farmacias",

        )
    }
}

@Composable
fun show_tabs() {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("Listado", "Mapa")
    Column { // 2.
        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> Text("Listado")
            1 -> Text("Mapa")
        }
    }
}

@Composable
fun show_container() {
    Column (

        modifier = Modifier.fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Row(modifier = Modifier.weight(1.0f, true)) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                ) {
                show_button()
            }

        }
        Row(modifier = Modifier.weight(9.0f, true)) {
            show_tabs()
        }

//        Spacer(Modifier.height(5.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FcamTheme {
       show_container()
    }
}