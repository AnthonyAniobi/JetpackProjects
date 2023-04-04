package com.aniobi.cleaningapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aniobi.cleaningapp.R
import com.aniobi.cleaningapp.ui.theme.Orangish
import com.aniobi.cleaningapp.ui.theme.Purplish

@Preview(showBackground = true)
@Composable
fun OnboardingPage1(){
    BgMain2()
    MainScreen2()
}

@Composable
fun BgMain2() {
    val signupText = buildAnnotatedString {
        append("Dont have an account? ")
        withStyle(SpanStyle(color = Orangish)){
            append("Sign up here")
        }
    }

    Surface(color = Purplish, modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y=(-30).dp)
        ) {
            Row(){
                Box(modifier = Modifier
                    .background(Color.Gray)
                    .size(10.dp)
                    .clip(CircleShape))
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Box(modifier = Modifier
                    .background(Color.White)
                    .size(12.dp)
                    .clip(CircleShape))
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Box(modifier = Modifier
                    .background(Color.Gray)
                    .size(10.dp)
                    .clip(CircleShape))
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                TextButton(onClick = {  }) {
                    Text("Skip", color = Color.White)
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                }
                TextButton(onClick = {  }) {
                    Text("Next", color = Color.White)
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                    Image(painter = painterResource(id = R.drawable.ic_next), contentDescription = "")
                }
            }
        }
    }
}

@Composable
fun MainScreen2() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .height(600.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(60.dp)
            .copy(topEnd = ZeroCornerSize, topStart = ZeroCornerSize)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
                ){
            Image(
                painter = painterResource(id = R.drawable.ic_cleaning),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.padding(32.dp))
            Text("Cleaning on Demand", style= MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.padding(12.dp))
            Text("Book an appointment in 30 seconds and get on the schedule as early as tomorrow morning. ",
                style = MaterialTheme.typography.caption, textAlign = TextAlign.Center)
        }
    }

}