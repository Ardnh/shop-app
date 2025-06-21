package com.example.shopapp.app.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R

// Set of Material typography styles to start with
val DefaultTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

// Font Size
val TitleFontSize = 24.sp
val SubtitleFontSize = 20.sp
val BodyFontSize = 16.sp
val CaptionFontSize = 12.sp
val ButtonFontSize = 14.sp

// Font Weight
val BoldFontWeight = FontWeight.Bold
val MediumFontWeight = FontWeight.Medium
val NormalFontWeight = FontWeight.Normal
val LightFontWeight = FontWeight.Light

// Border Radius
val ButtonBorderRadius = 8.dp
val CardBorderRadius = 12.dp
val ImageBorderRadius = 16.dp
val SmallBorderRadius = 4.dp
val LargeBorderRadius = 24.dp

// Input BorderRadius
val InputBorderRadius = 20.dp

// Font Family
val FontLight = FontFamily(Font(R.font.inter_light))
val FontRegular = FontFamily(Font(R.font.inter_regular))
val FontSemiBold = FontFamily(Font(R.font.inter_semibold))
val FontBold = FontFamily(Font(R.font.inter_bold))