package ir.onlineshop.service

import ir.onlineshop.database.model.Category

interface CategoryService {

    fun save(category: Category)
}