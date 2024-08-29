package com.mfa.library;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mfa.library.bottomnavigation.BottomNavigation.OnItemSelectedMFABottomNavigation;
import com.mfa.library.bottomnavigation.MFABottomNavigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MFABottomNavigation mfaBottomNavigation = findViewById(R.id.bottomNavigation);
        mfaBottomNavigation.addItem("Home", 0, "https://wallpapercave.com/wp/wp6400060.jpg");
        mfaBottomNavigation.addItem("Beranda", 0, "https://wallpapercave.com/wp/wp6400060.jpg");
        mfaBottomNavigation.addItem("Dashboard", 0, "https://wallpapercave.com/wp/wp6400060.jpg");

        mfaBottomNavigation.setOnItemSelectedNavigation(new OnItemSelectedMFABottomNavigation.Dialog() {
            @Override
            public void OnItemSelectedNavigation(int position, LinearLayout linearLayoutItem, CardView cardViewBckgroundIcon, ImageView icon, TextView title) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Beranda", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}