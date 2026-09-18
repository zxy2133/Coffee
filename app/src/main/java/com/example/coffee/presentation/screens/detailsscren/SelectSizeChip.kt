package com.example.coffee.presentation.screens.detailsscren

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.presentation.ui.theme.CharcoalGray
import com.example.coffee.presentation.ui.theme.LightBrown


@Composable
fun SelectSizeChip(sizeText: String, selected: Boolean, onClick: () -> Unit,modifier: Modifier) {
    Box(
        modifier = modifier
            .background(
                color = if (selected) LightBrown.copy(alpha = 0.2f) else Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                color = if (selected) LightBrown else Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = sizeText,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) LightBrown else CharcoalGray
        )
    }
}