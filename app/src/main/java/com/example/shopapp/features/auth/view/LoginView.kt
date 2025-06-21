package com.example.shopapp.features.auth.view

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shopapp.R
import com.example.shopapp.app.theme.GrayLight
import com.example.shopapp.features.auth.components.EmailTextInput
import com.example.shopapp.features.auth.components.PasswordTextInput

@Composable
fun LoginView(navController: NavController){

    var emailTextInputState by remember { mutableStateOf("") }
    var passwordTextInputState by remember { mutableStateOf("") }

    fun onNewValChange(input:String, currentVal: String){
        if(input == "email"){
            emailTextInputState = currentVal
        }
        if(input == "password"){
            passwordTextInputState = currentVal
        }
    }

    fun onLogin(){
        println(emailTextInputState)
        println(passwordTextInputState)
    }

    Scaffold { innerPadding ->

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_shop_logo),
                    contentDescription = "Shop app logo",
                    modifier = Modifier.size(270.dp)
                )

                Box(
                    modifier = Modifier.height(80.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Welcome Back"
                    )
                }

                Box(
                    modifier = Modifier.height(20.dp)
                )

                EmailTextInput(
                    emailTextInputState,
                    onValueChange = { newVal ->
                        onNewValChange("email", newVal)
                    }
                )
                Box( modifier = Modifier.height(10.dp))
                PasswordTextInput(
                    passwordTextInputState,
                    onValueChange = { newVal ->
                        onNewValChange("password", newVal)
                    }
                )
                Box( modifier = Modifier.height(20.dp))
                FilledTonalButton(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = GrayLight,
                        contentColor = Color.DarkGray,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Gray,
                    ),
                    onClick = { onLogin() }
                ) {
                    Text(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Login"
                    )
                }

            }
        }

    }

}