package com.example.shopapp.features.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.app.theme.FontRegular
import com.example.shopapp.app.theme.GrayLight

@Composable
fun EmailTextInput(value: String, onValueChange: (newVal: String) -> Unit) {
    val shape = RoundedCornerShape(30.dp)
    val emailTextInputState = remember { mutableStateOf(TextFieldValue()) }
    val interactionEmailSource = remember { MutableInteractionSource() }

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
            placeholder = {
                Text(
                    text = "Email",
                    lineHeight = 15.sp
                )
            },
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(50.dp),
            shape = shape,
            singleLine = true,
            textStyle = TextStyle(
                lineHeight = 15.sp,
                fontSize = 16.sp
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = GrayLight,
                unfocusedContainerColor = GrayLight,
                disabledContainerColor = GrayLight,
                errorContainerColor = GrayLight,
                focusedIndicatorColor = GrayLight
            )
        )
    }
}
