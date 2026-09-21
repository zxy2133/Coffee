package com.example.coffee.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import android.widget.Toast
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.domain.model.CartManager
import com.example.coffee.domain.model.FavouriteManager
import com.example.coffee.domain.model.Product
import com.example.coffee.presentation.navigation.Routes
import com.example.coffee.presentation.ui.theme.LightBrown
import com.example.coffee.presentation.ui.theme.LightGray


@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val context = LocalContext.current
    val isFavourite = FavouriteManager.contains(product)
    Card(
        modifier = modifier
            .padding(8.dp)
            .clickable{navController.navigate(Routes.DetailScreen(product.id))},
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Image(
                    painter = painterResource(product.imageRes),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(24.dp))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)  //放在background前决定外边距
                        .background(
                            color = LightGray.copy(alpha = 0.8f),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 4.dp, vertical = 4.dp)   //放在background后决定内边距
                ) {
                    IconButton(
                        onClick = {
                            val added = FavouriteManager.toggle(product)
                            Toast.makeText(
                                context,
                                if (added) "已添加到收藏夹" else "已取消收藏",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Icon(
                            painter = painterResource(
                                if (isFavourite) R.drawable.favorite_filled
                                else R.drawable.favorite
                            ),
                            contentDescription = "收藏",
                            tint = if (isFavourite) Color(0xFFE53935) else LightBrown,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = product.description,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,    //当文本超过一行时显示省略号
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${product.price} 元",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                )
                IconButton(
                    onClick = {
                        CartManager.add(product)
                        Toast.makeText(context, "已添加到购物车", Toast.LENGTH_SHORT).show()
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = LightBrown,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.add),
                        contentDescription = "购物车添加按钮"
                    )
                }
            }
        }
    }
}