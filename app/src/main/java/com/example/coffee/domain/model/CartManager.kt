package com.example.coffee.domain.model

import androidx.compose.runtime.mutableStateMapOf

/**
 * 全局购物车：使用 SnapshotStateMap，商品数量变化时所有观察页面自动重组。
 * key 为商品（data class 可作为 key），value 为数量；同一商品重复添加会累加。
 */
object CartManager {
    private val _items = mutableStateMapOf<Product, Int>()
    val items: Map<Product, Int> get() = _items

    fun add(product: Product) {
        _items[product] = (_items[product] ?: 0) + 1
    }

    fun increase(product: Product) {
        _items[product] = (_items[product] ?: 0) + 1
    }

    fun decrease(product: Product) {
        val quantity = _items[product] ?: return
        if (quantity <= 1) {
            _items.remove(product)
        } else {
            _items[product] = quantity - 1
        }
    }

    fun clear() {
        _items.clear()
    }
}
