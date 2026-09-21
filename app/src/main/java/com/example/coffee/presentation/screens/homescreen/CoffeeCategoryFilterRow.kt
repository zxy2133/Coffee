package com.example.coffee.presentation.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//咖啡分类列表
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoffeeCategoryFilterRow(
    selectedCategory: String = "全部",
    onSelected: (String) -> Unit = {}
) {
    val categories = listOf("全部", "咖啡", "拿铁", "其他")
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories){category ->
            CategoryChip(
                text = category,
                isSelected = category == selectedCategory,  //判断当前item和被选中的item是否一致，不一致将设置为未选中
                onSelected = {onSelected(category)}
            )
        }
    }
}
