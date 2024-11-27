package com.example.bagpackapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "items")

public class items implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int ID = 0;

    @ColumnInfo(name = "itemName")
    String itemName;

    @ColumnInfo(name = "category")
    String category;

    @ColumnInfo(name = "adddedby")
    String addedby;

    @ColumnInfo(name = "checkby")
    Boolean checked = false;


    public items() {

    }

    public items(String category, String itemName, Boolean checked) {
        this.addedby = "system";
        this.category = category;
        this.itemName = itemName;
        this.checked = checked;
    }

    public items(String addedby, String category, Boolean checked, String itemName) {
        this.addedby = addedby;
        this.category = category;
        this.checked = checked;
        this.itemName = itemName;
    }

    public String getAddedby() {
        return addedby;
    }

    public void setAddedby(String addedby) {
        this.addedby = addedby;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
