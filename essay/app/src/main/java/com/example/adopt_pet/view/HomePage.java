package com.example.adopt_pet.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.adopt_pet.R;
import com.example.adopt_pet.databinding.ActivityHomePageBinding;

public class HomePage extends AppCompatActivity {
    private int[] images = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3};
    private ActivityHomePageBinding binding;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Khởi tạo SliderAdapter và thiết lập cho ViewPager2
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        binding.viewPagerSlider.setAdapter(sliderAdapter);

        // Bắt đầu chạy slider tự động
        sliderHandler.postDelayed(sliderRunnable, 2500);
    }

    // Runnable để chuyển trang
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = binding.viewPagerSlider.getCurrentItem(); // Sử dụng binding để lấy currentItem
            int nextItem = (currentItem + 1) % images.length; // Di chuyển vòng lặp
            binding.viewPagerSlider.setCurrentItem(nextItem, true); // true để có hiệu ứng chuyển động
            sliderHandler.postDelayed(this, 3000); // Lặp lại sau 3 giây
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sliderHandler.removeCallbacks(sliderRunnable);
    }
}
