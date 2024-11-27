package com.example.bagpackapp.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.text.NoCopySpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bagpackapp.Database.RoomDB;
import com.example.bagpackapp.R;
import com.example.bagpackapp.model.items;

import java.util.List;

public class CheckListAdapter extends RecyclerView.Adapter<CheckListViewHolder> {
    Context context;
    List<items> itemsList;
    RoomDB database;
    String show;

    public CheckListAdapter(){

    }

    public CheckListAdapter(Context context, RoomDB database, List<items> itemsList, String show) {
        this.context = context;
        this.database = database;
        this.itemsList = itemsList;
        this.show = show;
    }

    @NonNull
    @Override
    public CheckListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CheckListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class CheckListViewHolder extends RecyclerView.ViewHolder{

    LinearLayout linearLayout;
    CheckBox checkBox;
    Button btnDelete;

    public CheckListViewHolder(@NonNull View itemView) {
        super(itemView);

        linearLayout = itemView.findViewById(R.id.linearLayout);
        checkBox = itemView.findViewById(R.id.checkbox);
        btnDelete = itemView.findViewById(R.id.btn_delete);


    }
}
