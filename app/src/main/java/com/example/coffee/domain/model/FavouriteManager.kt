package com.example.coffee.domain.model

import androidx.compose.runtime.mutableStateListOf

/**
 * 全局收藏夹：使用 SnapshotStateList，收藏变化时所有观察页面自动重组。
 * 按 id 判断去重。
 */
object FavouriteManager {
    private val _items = mutableStateListOf<Product>()
    val items: List<Product> get() = _items

    fun contains(product: Product): Boolean = _items.any { it.id == product.id }

    /** 切换收藏状态，返回切换后是否已收藏 */
    fun toggle(product: Product): Boolean {
        return if (contains(product)) {
            _items.removeAll { it.id == product.id }
            false
        } else {
            _items.add(product)
            true
        }
    }

    fun remove(product: Product) {
        _items.removeAll { it.id == product.id }
    }
}
