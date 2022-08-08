package com.example.groceryui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    val selectedIndex = remember {
        mutableStateOf(0)
    }

    val buttons = remember {
        listOf("Top", "Bottom", "Center", "End")
    }
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
        ) {
            AppBar()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Welcome Developer \nShare Your rich experience...",
                fontFamily = FontFamily.SansSerif,
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Compose has good UI.",
                color = Color.LightGray,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            SearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            CategoryBar(selectedIndex, buttons) {
                selectedIndex.value = it
            }
        }
    }
}

@Composable
fun CategoryBar(selectedIndex: State<Int>, buttons: List<String>, onClick: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(buttons.size) { index ->
            if (index == selectedIndex.value)
                OutlinedButton(
                    onClick = { onClick.invoke(index) },
                    border = BorderStroke(1.dp, Color.Yellow),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    ),
                ) {
                    Text(buttons[index])
                }
            else
                TextButton(
                    onClick = { onClick.invoke(index) },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        backgroundColor = Color.Unspecified
                    )
                ) {
                    Text(text = buttons[index])
                }
        }
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp)
        ) {
            Icon(Icons.Outlined.Search, "Search")
            Text(
                text = "Search Vegetable",
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_menu_24),
            contentDescription = "menu icon",
            tint = Color.LightGray,
            modifier = Modifier.padding(start = 20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.project),
            contentDescription = "profile image",
            modifier = Modifier
                .padding(end = 16.dp)
                .size(40.dp)
                .clip(CircleShape)

        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}