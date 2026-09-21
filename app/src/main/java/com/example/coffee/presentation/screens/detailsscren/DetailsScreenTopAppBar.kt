package com.example.coffee.presentation.screens.detailsscren

import android.widget.Toast
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.domain.model.FavouriteManager
import com.example.coffee.domain.model.Product
import com.example.coffee.presentation.ui.theme.LightBrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenTopAppBar(navController: NavController, product: Product) {
    val context = LocalContext.current
    val isFavourite = FavouriteManager.contains(product)
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
                onClick = {
                    val added = FavouriteManager.toggle(product)
                    Toast.makeText(
                        context,
                        if (added) "已添加到收藏夹" else "已取消收藏",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier.padding(end = 10.dp)
            ) {
                Icon(
                    painter = painterResource(
                        if (isFavourite) R.drawable.favorite_filled
                        else R.drawable.favorite
                    ),
                    contentDescription = "添加到收藏",
                    tint = if (isFavourite) Color(0xFFE53935) else LightBrown,
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
                    .clickable(onClick = { navController.navigateUp() })
            )
        }
    )

}
