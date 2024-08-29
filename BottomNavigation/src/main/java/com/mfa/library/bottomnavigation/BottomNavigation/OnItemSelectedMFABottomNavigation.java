package com.mfa.library.bottomnavigation.BottomNavigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mfa.library.bottomnavigation.R;

import java.util.List;

public class OnItemSelectedMFABottomNavigation extends RecyclerView.Adapter<OnItemSelectedMFABottomNavigation.MyViewHolder> {
    private final Context context;
    public List<ModelBottomNavigation> list;
    private static Dialog dialog;

    public Dialog setDialog(Dialog dialog) {
        OnItemSelectedMFABottomNavigation.dialog = dialog;
        return dialog;
    }
    public interface Dialog {
        void OnItemSelectedNavigation(int position, LinearLayout linearLayoutItem, CardView cardViewBckgroundIcon, ImageView icon, TextView title);
    }

    public OnItemSelectedMFABottomNavigation(Context context, List<ModelBottomNavigation> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_navigation_menu, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        if (list.get(position).getIcon() != 0) {
            holder.icon.setImageResource(list.get(position).getIcon());
        } else {
            Glide.with(context).load(list.get(position).getsImage()).into(holder.icon);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        LinearLayout LinearLayout;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);
            LinearLayout = itemView.findViewById(R.id.menuItem);
            cardView = itemView.findViewById(R.id.cardView);
            if (dialog != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.OnItemSelectedNavigation(
                                getLayoutPosition(),
                                LinearLayout,
                                cardView,
                                icon,
                                title);
                    }
                });
            }
        }
    }
}