package com.example.bagpackapp.Dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bagpackapp.model.items; // Use uppercase

import java.util.List;

@Dao
public interface ItemsDao {

    @Insert(onConflict = REPLACE)
    void saveItems(items items);

    @Query("SELECT * FROM items WHERE category = :category ORDER BY id ASC")
    List<items> getAll(String category);

    @Delete
    void delete(items items);

    @Query("UPDATE items SET checked = :checked WHERE ID = :id")
    void checkUncheck(int id, boolean checked);

    @Query("SELECT COUNT(*) FROM items")
    Integer getItemsCount();

    void CheckUncheck(int id, boolean checked);

    @Query("DELETE FROM items WHERE addedby = :addedBy")
    Integer deleteAllSystemItems(String addedBy); // Change to void

    @Query("DELETE FROM items WHERE category = :category")
    Integer deleteAllByCategory(String category); // Change to void

    @Query("DELETE FROM items WHERE category = :category AND addedby = :addedBy")
    Integer deleteAllByCategoryAndAddedBy(String category, String addedBy); // Change to void

    @Query("SELECT * FROM items WHERE checked = :checked ORDER BY id ASC")
    List<items> getAllSelected(Boolean checked);
}
