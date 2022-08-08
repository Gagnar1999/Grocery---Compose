package com.example.groceryui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceryui.ui.theme.GroceryUITheme
import com.example.groceryui.ui.theme.skyBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun Dashboard() {
    val selectedIndex = remember { mutableStateOf(0) }
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f, false))
            Image(painterResource(id = R.drawable.project), contentDescription = "", modifier = Modifier.fillMaxWidth().height(180.dp))
            Row(
                modifier = Modifier
                    .weight(1f, false)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(onClick = { /*TODO*/ }, shape = RoundedCornerShape(50)) {
                    Text(text = "Skip", color = Color.Gray)
                }

                LazyRow {
                    items(3) { i ->
                        val color = if (i == selectedIndex.value) Color.Gray else Color.LightGray
                        Spacer(modifier = Modifier.width(4.dp))
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(color)
                        )
                    }
                }

                Button(
                    onClick = { },
                    shape = RoundedCornerShape(50), // = 50% percent
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        backgroundColor = skyBlue
                    )
                ) {
                    Text(text = "Save")
                }
            }
        }

        Row() {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GroceryUITheme {
        Dashboard()
    }
}