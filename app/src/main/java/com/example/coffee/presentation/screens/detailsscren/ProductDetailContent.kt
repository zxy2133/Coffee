package com.example.coffee.presentation.screens.detailsscren

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.domain.model.Product

@Composable
fun ProductDetailContent(product: Product, innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(innerPadding)
    ) {
        item {
            Image(
                painter = painterResource(product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(text = product.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = product.description,
                fontSize = 24.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "温度", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                var selectedTemperature by remember { mutableStateOf("冷") }
                listOf("冷", "热").forEach { temp ->
                    SelectTemperature(
                        temperature = temp,
                        icon = painterResource(if (temp == "冷")R.drawable.ice else R.drawable.hot),
                        iconContentDescription = if (temp == "冷") "冷" else "热",
                        tint = if (temp == "冷") Color(0xFF4820DC) else Color(0xFFDC630A),
                        selected = selectedTemperature == temp,
                        onClick = { selectedTemperature = temp },
                        modifier = Modifier
                            .weight(1f)
                            .height(46.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = Color.Black.copy(0.5f))
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "杯型", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            var selectedSizeText by remember { mutableStateOf("中杯") }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                listOf("小杯", "中杯", "大杯").forEach { size ->
                    SelectSizeChip(
                        sizeText = size,
                        selected = selectedSizeText == size,
                        onClick = { selectedSizeText = size },
                        modifier = Modifier
                            .weight(1f)
                            .height(46.dp)
                    )
                }
            }
        }
    }
}
