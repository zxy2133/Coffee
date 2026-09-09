package com.example.coffee.presentation.screens.detailsscren

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee.R
import com.example.coffee.presentation.ui.theme.LightBrown

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailsScreenTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "详情",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(
                onClick = {},
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.favorite),
                    contentDescription = "添加到收藏",
                    tint = LightBrown,
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {},
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "返回",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    )

}