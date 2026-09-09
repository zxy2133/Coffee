package com.example.coffee.presentation.screens.detailsscren

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.domain.model.ui_components.AddMessageDialog
import com.example.coffee.presentation.ui.theme.IvoryWhite
import com.example.coffee.presentation.ui.theme.LightBrown


@Composable
fun DetailsScreenBottomAppBar() {
    var showCardDialog by remember { mutableStateOf(false) }
    BottomAppBar(
        containerColor = Color.Transparent
    ){
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "价格")
        }
        Spacer(modifier = Modifier.width(40.dp))
        Button(
            onClick = {showCardDialog = true},
            modifier = Modifier.weight(1f).height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBrown,
                contentColor = IvoryWhite
            )
        ) {
            Text(text = "添加到购物车", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }
        AddMessageDialog(
            show = showCardDialog,
            title = "购物车",
            message = "商品已成功添加到购物车",
            onDismiss = {showCardDialog = false}
        )
    }
}