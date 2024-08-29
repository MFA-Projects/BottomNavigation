package com.mfa.library.bottomnavigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mfa.library.bottomnavigation.BottomNavigation.OnItemSelectedMFABottomNavigation;
import com.mfa.library.bottomnavigation.BottomNavigation.ModelBottomNavigation;

import java.util.ArrayList;
import java.util.List;

public class MFABottomNavigation extends LinearLayout {
    private Context context;
    private List<ModelBottomNavigation> list = new ArrayList<>();
    private OnItemSelectedMFABottomNavigation adapter;

    public MFABottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.adapter = new OnItemSelectedMFABottomNavigation(context, list);
        init(context);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bottom_navigation, this, true);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addItem(String title, int drawable, String sImage) {
        list.add(new ModelBottomNavigation(
                title,
                drawable,
                sImage
        ));
        int jumlahItem = list.size();
        if (jumlahItem == 0) {
            jumlahItem = 1;
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerviewMenuItem);
        GridLayoutManager layoutManager = new GridLayoutManager(context, jumlahItem, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        if (!list.isEmpty()){
            recyclerView.setVisibility(VISIBLE);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setOnItemSelectedNavigation(OnItemSelectedMFABottomNavigation.Dialog listener) {
        adapter.setDialog(listener);
        adapter.notifyDataSetChanged();
    }
}