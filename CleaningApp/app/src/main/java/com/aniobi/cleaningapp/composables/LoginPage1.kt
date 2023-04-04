package com.aniobi.cleaningapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
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
fun LoginPage1(){
    Box{

        BgMain()
        MainScreen()
    }
}

@Composable
fun BgMain() {
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
                Image(painter = painterResource(id = R.drawable.ic_fb), contentDescription = "")
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = "")
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(painter = painterResource(id = R.drawable.ic_twitter), contentDescription = "")
            }
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(signupText, color = Color.White)
        }
    }
}

@Composable
fun MainScreen() {
    val emailState = remember{ mutableStateOf(TextFieldValue("anthonyaniobi198@gmail.com")) }
    val passState = remember {
        mutableStateOf(TextFieldValue(""))
    }
    Surface(
        color = Color.White,
        modifier = Modifier
            .height(600.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(60.dp)
            .copy(topEnd = ZeroCornerSize, topStart = ZeroCornerSize)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var modifier = Modifier.padding(16.dp)
            Image(painter = painterResource(id= R.drawable.ic_vaccum), contentDescription = "")
            Spacer(modifier = Modifier.padding(16.dp  ))
            OutlinedTextField(
                value = emailState.value,
                label = { Text("Email Adress") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "", modifier = modifier)},
                onValueChange = {
                    emailState.value = it
                },
            )
            Spacer(modifier = Modifier.padding(6.dp  ))
            OutlinedTextField(
                value = passState.value,
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "", modifier = modifier)},
                onValueChange = {
                    passState.value = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                Text(text = "Forget Password?", textAlign = TextAlign.End, modifier = modifier)
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Button(
                onClick = {},
                shape = shapes.medium,
                modifier = modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orangish,
                    contentColor = Color.White),
            ) {
                Text("Login", color = Color.Black)
            }
        }
    }

}