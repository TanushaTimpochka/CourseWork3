package com.example.myapplication

import DatabaseHelper
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class ShoppingItem (id: Int, title: String, package_id: Int) {
    val id = id
    val title = title
    val package_id = package_id
}

class ShoppingItemRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun addShoppingItem(item: ShoppingItem) {
        val db: SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_TITLE, item.title)
            put(DatabaseHelper.COLUMN_PACKAGE_ID, item.package_id)
        }

        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    fun getAllShoppingItems(): List<ShoppingItem> {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor = db.query(
            DatabaseHelper.TABLE_NAME,
            arrayOf(DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_TITLE, DatabaseHelper.COLUMN_PACKAGE_ID),
            null,
            null,
            null,
            null,
            null
        )

        val shoppingItems = ArrayList<ShoppingItem>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID))
                val title = getString(getColumnIndexOrThrow(DatabaseHelper.COLUMN_TITLE))
                val packageId = getInt(getColumnIndexOrThrow(DatabaseHelper.COLUMN_PACKAGE_ID))
                shoppingItems.add(ShoppingItem(id, title, packageId))
            }
        }
        cursor.close()
        db.close()

        return shoppingItems
    }

}