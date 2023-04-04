package com.aniobi.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Box(modifier= Modifier
        .background(color = Color.White)
        .verticalScroll(rememberScrollState())){
        Image(
            modifier= Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "Header Background",
            contentScale = ContentScale.FillWidth
        )
        Column() {
            AppBar()
            Content()
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
fun Content(){
    Column() {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        Promotions()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(16.dp))
        BestSellerSection()
        Spacer(modifier = Modifier.height(16.dp))
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
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable {}
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(painter = painterResource(id = R.drawable.ic_money), contentDescription = "", tint = Color(0xFF6FCF97))
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "$120", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text="Top up", color = MaterialTheme.colors.primary, fontSize = 12.sp)
                }
            }
            VerticalDivider()
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable {}
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(painter = painterResource(id = R.drawable.ic_coin), contentDescription = "", tint = MaterialTheme.colors.primary)
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "$10", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Points", color = Color.LightGray, fontSize = 12.sp)
                }
            }
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
fun Promotions() {
    LazyRow(
        modifier = Modifier
            .height(160.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item{
            PromotionItem(
                title = "Fruit",
                subtitle = "Start @",
                header = "$1",
                imageResource = painterResource(id = R.drawable.fruitimage),
                backgroundColor = MaterialTheme.colors.primary,
            )
        }
        item{
            PromotionItem(
                title = "Meat",
                subtitle = "Discount",
                header = "20%",
                imageResource = painterResource(id = R.drawable.fruitimage),
                backgroundColor = Color(0xff6EB6F5),
            )
        }
    }
}

@Composable
fun PromotionItem(
    title:String = "",
    subtitle: String = "",
    header: String = "",
    backgroundColor: Color =  Color.Transparent,
    imageResource: Painter,
){
    Card(
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = backgroundColor,
        elevation = 0.dp
    ){
        Row{
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ){
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(text = subtitle, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = header, fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imageResource,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun CategorySection(){
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Category", style = MaterialTheme.typography.h6, color= Color.Black)
            TextButton(onClick = {}) {
                Text(text="More", color=MaterialTheme.colors.primary)
            }
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            CategoryButton(
                text = "Fruits",
                icon = painterResource(id = R.drawable.ic_orange),
                backgroundColor = Color(0xFFFEF4E7),
            )
            CategoryButton(
                text = "Vegetable",
                icon = painterResource(id = R.drawable.ic_veg),
                backgroundColor = Color(0xFFF6F8F3),
            )
            CategoryButton(
                text = "Diary",
                icon = painterResource(id = R.drawable.ic_cheese),
                backgroundColor = Color(0xFFFFFBF3),
            )
            CategoryButton(
                text = "Meats",
                icon = painterResource(id = R.drawable.ic_meat),
                backgroundColor = Color(0xFFF6E6E9),
            )
        }
    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color
) {
    Column(
        modifier = Modifier
            .width(72.dp)
            .clickable { }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp),
                )
                .padding(12.dp),

        ){
            Image(painter = icon, contentDescription = "", modifier=Modifier.fillMaxSize())
        }
        Text(text= text,fontSize=14.sp, color=Color.Black,  modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}

@Composable
fun BestSellerSection(){
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Best Sellers", style = MaterialTheme.typography.h6, color=Color.Black)
            TextButton(onClick = {}) {
                Text(text="More", color=MaterialTheme.colors.primary)
            }
        }
        BestSellerItems()
    }
}

@Composable
fun BestSellerItems() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item{
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_lettuce),
                title = "Iceberg lettuce",
                price = "1.99",
                discountPercent = 10
            )
        }
        item{
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_apple),
                title = "Apple",
                price = "2.65",
                discountPercent = 5
            )
        }
        item{
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_meat),
                title = "Meat",
                price = "4.76",
                discountPercent = 20
            )
        } 
    }
}


@Composable
fun BestSellerItem(
    title: String = "",
    price: String = "",
    discountPercent: Int = 0,
    imagePainter: Painter,
){
    Card(
        modifier = Modifier
            .width(160.dp)
    ){
        Column (
            modifier = Modifier.padding(bottom = 32.dp)
                ){
            Image(painter = imagePainter, contentDescription = "", modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
                contentScale = ContentScale.Fit,
                )
            Column(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold, color = Color.Black)
                Row {
                    Text(
                        "$${price}",
                        textDecoration = if (discountPercent > 0) TextDecoration.LineThrough else TextDecoration.None,
                        color = if (discountPercent > 0) Color.Black else Color.Gray

                    )
                    if (discountPercent > 0) {
                        Text("[$discountPercent%]", color = MaterialTheme.colors.primary)
                    }
                }
            }
        }
    }
}

