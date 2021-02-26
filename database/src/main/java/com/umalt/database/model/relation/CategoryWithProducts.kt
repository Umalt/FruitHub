package com.umalt.database.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umalt.database.model.CategoryDBModel
import com.umalt.database.model.ItemDBModel

/**
 * Created by Umalt on 2/22/21
 */
class CategoryWithProducts(
    @Embedded val category: CategoryDBModel,
    @Relation(parentColumn = "id", entityColumn = "parent_id")
    val products: List<ItemDBModel>?
)