package com.example.coffee.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.presentation.ui.theme.LightBrown
import com.example.coffee.presentation.ui.theme.LightGray

@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean, //表示是否处于被选中状态
    onSelected: () -> Unit  //表示被选中后的事件
) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable { onSelected() }
            .background(
                color = if (isSelected) LightBrown else LightGray.copy(0.6f),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
    }

}