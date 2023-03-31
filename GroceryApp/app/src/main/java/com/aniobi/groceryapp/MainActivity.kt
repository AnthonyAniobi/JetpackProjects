package com.aniobi.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aniobi.groceryapp.ui.theme.GroceryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun MainTheme(content :@Composable ()->Unit){
    GroceryAppTheme {
        Surface(color = MaterialTheme.colors.primary) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen(){
    Box(modifier=Modifier.background(color = Color.White)){
        Image(
            modifier= Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Scaffold(
            topBar = { AppBar() },
            backgroundColor = Color.Transparent
        ) { paddingValues ->
            Content(paddingValues)
        }
    }
}

@Composable
fun AppBar(){

    Row(
        modifier = Modifier
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ){
        TextField(
            value = "",
            label = {Text("Search Food, Vegetable, etc", maxLines = 1)},
            onValueChange = {},
            leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search")},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier=Modifier.width(8.dp))
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "", tint=Color.White)
        }
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "", tint=Color.White)
        }

    }
}

@Composable
fun Content(paddingValues: PaddingValues){
    Column(modifier= Modifier.padding(paddingValues)) {
        Header()
    }
}

@Composable
fun Header(){
    Card(modifier = Modifier
        .height(64.dp)
        .padding(horizontal = 16.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            QRButton()
            VerticalDivider()
        }
    }
}

@Composable
fun QRButton() {
    IconButton(
        onClick={},
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
    ){
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
fun VerticalDivider() {
    Divider(
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
                
    )
}

@Composable
fun MoneyStats() {
    
}