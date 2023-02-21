package com.example.jetbizcard_course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard_course.ui.theme.JetBizCardCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    // create a click button
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        //Card is a builtin function in kotlin
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.White,
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //We call our create imageprofile function here
                CreateImageProfile()
                //Divider just provide a tiny line
                Divider()
                CreateInfo()

                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value

                }) {
                    Text(
                        "Portfolio", style = MaterialTheme.typography.button
                    )
                }
                if (buttonClickedState.value) {
                    Content()
                } else {
                    Box() {

                    }
                }

            }

        }
    }
}


//Create profile image on the top.
@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)

    ) {
        Image(
            painter = painterResource(id = R.drawable.wahid),
            contentDescription = "profile image",
            modifier = modifier.size(13.dp)
        )

    }
}


@Composable
fun CreateImageForContent() {
    Surface(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)

    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Project image",
            modifier = Modifier.size(5.dp)
        )

    }
}


data class Item(val title: String, val description: String)

@Composable
fun Portfolio(data: List<Item>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.surface)
                        .padding(10.dp),
                ) {
                    CreateImageForContent()
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically),
                    ) {

                        Text(text = item.title, fontWeight = FontWeight.Bold)
                        Text(text = item.description, style = MaterialTheme.typography.body2)
                    }
                }

            }
        }
    }
}

//Create Function for Portfolio button content.
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(
            )
            .padding(3.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            val data = ItemForContent()
            Portfolio(data)
        }
    }
}

@Composable
private fun ItemForContent(): List<Item> {
    val data = listOf(
        Item(
            "InstaBank App",
            "- Worked with different funcationality  " +
                    "and design"
        ),
        Item("Add note App", "- Created app for saving notes"),
        Item("JetBizCard App", "- Created portfolio card"),
        Item(
            "Femi App", "- Created a special App for women " +
                    "who need help in a society"
        )

    )
    return data
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardCourseTheme {
        CreateBizCard()

    }
}