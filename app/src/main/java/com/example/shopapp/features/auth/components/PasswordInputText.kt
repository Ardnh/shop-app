package com.example.shopapp.features.auth.components

import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.app.theme.FontRegular
import com.example.shopapp.app.theme.GrayLight

@Composable
fun PasswordTextInput(value: String, onValueChange: (newVal: String) -> Unit) {

    val shape = RoundedCornerShape(30.dp)
    val passwordTextInputState = remember { mutableStateOf(TextFieldValue()) }
    val interactionEmailSource = remember { MutableInteractionSource() }
    val suffixIconRipple = remember { MutableInteractionSource() }

    var showPassword by remember { mutableStateOf(false) }


    fun setShowPassword(){
        showPassword = !showPassword
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .border(1.4.dp, GrayLight, shape)
    ) {
        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            interactionSource = interactionEmailSource,
            visualTransformation = if(showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = {
                Text(
                    text = "Password",
                    lineHeight = 15.sp
                )
            },
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(50.dp),
            shape = shape,
            singleLine = true,
            suffix = {
                Icon(
                    imageVector = if(showPassword) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility ,
                    contentDescription = "password suffix icon",
                    modifier = Modifier.clickable(
                        interactionSource = suffixIconRipple,
                        indication = null
                    ) {

                        setShowPassword()
                    }
                )
            },
            textStyle = TextStyle(
                lineHeight = 15.sp,
                fontSize = 16.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = GrayLight,
                unfocusedContainerColor = GrayLight,
                disabledContainerColor = Color.LightGray,
                errorContainerColor = GrayLight,
                focusedIndicatorColor = GrayLight
            )
        )
    }
}