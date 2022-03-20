package com.mcal.apkeditor.ui.editor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mcal.apkeditor.R;
import com.mcal.apkeditor.databinding.MainEditorActivityBinding;
import com.mcal.apkeditor.ui.base.BaseActivity;

import java.util.ArrayList;

public class MainEditorActivity extends BaseActivity {
    MenuItem prevMenuItem;
    private MainEditorActivityBinding binding;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainEditorActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Editor");

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
                item -> {
                    int itemId = item.getItemId();
                    if (itemId == R.id.menu_main_editor_strings) {
                        binding.viewpager.setCurrentItem(0);
                    } else if (itemId == R.id.menu_main_editor_files) {
                        binding.viewpager.setCurrentItem(1);
                    } else if (itemId == R.id.menu_main_editor_manifest) {
                        binding.viewpager.setCurrentItem(2);
                    }
                    return false;
                });

        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    binding.bottomNavigation.getMenu().getItem(0).setChecked(false);
                }
                binding.bottomNavigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = binding.bottomNavigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Пролистывание
        binding.viewpager.setOnTouchListener((v, event) -> false);

        setupViewPager(binding.viewpager);
    }

    private void setupViewPager(@NonNull ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(StringsFragment.newInstance("Strings"));
        adapter.addFragment(FilesFragment.newInstance("Files"));
        adapter.addFragment(ManifestFragment.newInstance("Manifest"));
        viewPager.setAdapter(adapter);
    }
}