package com.example.adopt_pet.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adopt_pet.databinding.ActivityGetStartBinding;

public class GetStartActivity extends AppCompatActivity {
    private ActivityGetStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ẩn thanh trạng thái và làm cho Activity hiển thị toàn màn hình
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Đối với Android 11 trở lên
            getWindow().setDecorFitsSystemWindows(false);
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
                insetsController.setSystemBarsBehavior(
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            }
        } else {
            // Đối với Android 10 trở xuống
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
        }

        binding.btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(GetStartActivity.this, HomePage.class);
                startActivity(t);
            }
        });

    }
}
