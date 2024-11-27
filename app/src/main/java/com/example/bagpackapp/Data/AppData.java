package com.example.bagpackapp.Data;

import android.accessibilityservice.GestureDescription;
import android.app.Application;
import android.content.ClipData;
import android.content.Context;
import android.hardware.camera2.CameraExtensionSession;
import android.nfc.tech.TagTechnology;
import android.os.ParcelUuid;

import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation;

import com.example.bagpackapp.Constants.MyConstants;
import com.example.bagpackapp.Dao.ItemsDao;
import com.example.bagpackapp.Database.RoomDB;
import com.example.bagpackapp.model.items;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {

    RoomDB databse;
    String category;
    Context context;

    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 1;

    public AppData(RoomDB databse) {
        this.databse = databse;
    }

    public AppData(Context context, RoomDB databse) {
        this.context = context;
        this.databse = databse;
    }
    public List<items> getBasicData(){
        category = "Basic Needs";
        List<items> basicItems = new ArrayList<>();
        basicItems.add(new items("Visa",category,false));
        basicItems.add(new items("PassPort",category,false));
        basicItems.add(new items("Ticket",category,false));
        basicItems.add(new items("Wallet",category,false));
        basicItems.add(new items("Driving License",category,false));
        basicItems.add(new items("Currency",category,false));
        basicItems.add(new items("House Key",category,false));
        basicItems.add(new items("Note Books",category,false));

        return basicItems;
    }

    public List<items> getPersonalCareData(){
        String []data = {"Tooth-Brush","Tooth-pase","MouthWash","FaceWash","HairConditional","Shaiving Cream","Nail Polish"};
        return prepareItemsList(MyConstants.PERSONAL_CARE_CAMEL_CASE,data);
    }

    public List<items> getClothingData(){
        String []data = {"Shirt","Jeans","Trousers","Coat","Pajama","Lower","T-shirts","Sweater","Baniyan","Underwears","UnderGarments","Belt","Slipper","Shoes",
        "Winter Cloths"};
         return prepareItemsList(MyConstants.CLOTHING_CAMEL_CASE,data);
    }

    public List<items> getBabyNeedsData(){
        String []data = {"Baby Pajama","Baby Socs","Baby Skin-Care","Baby Cloths","Baby Oil","Baby Soaps","Baby Winter-Cloths"};
        return prepareItemsList(MyConstants.BABY_NEEDS_CAMEL_CASE,data);
    }

    public List<items> getTechnologyData(){
        String []data = {"Mobile","Laptop","Charger","Calculator","Camera","Laptop-Charger","Mobile-Charger","Adapter","USB","DataKable","Mouse","Earphones","Earbuds"
        ,"Speaker","Music-Player"};
        return prepareItemsList(MyConstants.TECHNOLOGY_CAMEL_CASE,data);

    }

    public List<items> getFoodData(){
        String []data = {"Snack","Sandwich","Juice","Tea","Coffee","Water","Bottle","chips","Baby-Food","Maggie"};
        return prepareItemsList(MyConstants.FOOD_CAMEL_CASE,data);
    }

    public List<items> getBeachSuppliesData(){
        String []data = {"Sea-Glasses","Sun-Cream","Umbrella","Beach-Towel","Swim Fins","Beach Bag","Beach Sleeper","Beach Foodie"};
        return prepareItemsList(MyConstants.BEACH_SUPPLIES_CAMEL_CASE,data);
    }

    public List<items> getCarSuppliesData(){
        String []data = {"Key","Pump","Car-Cover","Tier","Petrol","Auto-Refrigerator","Window-Cover","Car Jack"};
        return prepareItemsList(MyConstants.CAR_SUPPLIES_CAMEL_CASE,data);
    }

    public List<items> getNeedsData(){
        String []data = {"BackPackd","Laundary Bag","Travel Lock","Luggage Lock","Magzine","Sports Things"};
        return prepareItemsList(MyConstants.NEEDS_CAMEL_CASE,data);
    }



    public List<items> prepareItemsList(String category,String []data){
        List<String>list = Arrays.asList(data);
        List<items> datalist = new ArrayList<>();

        for (int i=0;i< list.size();i++){
            datalist.add(new items(list.get(i),category,false));
        }
        return datalist;
    }

    public List<List<items>> getAllData(){
        List<List<items>> listOfAllItems = new ArrayList<>();
        listOfAllItems.add(getBasicData());
        listOfAllItems.add(getClothingData());
        listOfAllItems.add(getFoodData());
        listOfAllItems.add(getNeedsData());
        listOfAllItems.add(getTechnologyData());
        listOfAllItems.add(getBabyNeedsData());
        listOfAllItems.add(getPersonalCareData());
        listOfAllItems.add(getBeachSuppliesData());
        listOfAllItems.add(getCarSuppliesData());
        return listOfAllItems;
    }

    public void presistAllData(){
        List<List<items>> listOfAllItems = getAllData();
        for (List<items> list:listOfAllItems){
            for (items items:list){
                databse.mainDao().saveItems(items);

            }
            System.out.print("Data added");
        }
    }
}
