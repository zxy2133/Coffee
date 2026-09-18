package com.example.coffee.presentation.screens.detailsscren

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.presentation.ui.theme.LightBrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenTopAppBar(navController: NavController) {
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

            Icon(
                painter = painterResource(R.drawable.back),
                contentDescription = "返回",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(30.dp)
                    .clickable(onClick = {navController.navigateUp()})
            )
        }
    )

}