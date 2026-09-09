package com.example.coffee.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee.R
import com.example.coffee.presentation.ui.theme.LightBrown

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier.size(30.dp)
                )
            },
            placeholder = {
                Text(text = "寻找心仪的咖啡", color = Color.Gray)
            },
            shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp),
            singleLine = true,
            modifier = Modifier.weight(1f).height(56.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.DarkGray,

            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(
            onClick = {},
            modifier = Modifier.size(56.dp)
                .background(
                color = LightBrown,
                shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.filter),
                contentDescription = "Filter",
                tint = Color.White
            )
        }
    }
}