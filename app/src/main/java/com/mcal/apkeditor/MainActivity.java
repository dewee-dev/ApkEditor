/*
 * Copyright (C) 2022 Тимашков Иван
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.mcal.apkeditor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.mcal.apkeditor.databinding.MainPagerBinding;
import com.mcal.apkeditor.ui.main.base.BaseActivity;
import com.mcal.apkeditor.ui.main.MainProjectsFragment;
import com.mcal.apkeditor.ui.main.MainSettingsFragment;
import com.mcal.apkeditor.ui.main.MainFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MainPagerBinding binding;
    private ViewPager mMainViewPager;
    private MainProjectsFragment mMainProjectsFragment;
    private MainSettingsFragment mMainSettingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Fragment> fragment_list = new ArrayList<>();
        ArrayList<CharSequence> titles_list = new ArrayList<>();

        MainFragment startFragment = new MainFragment();
        fragment_list.add(startFragment);
        titles_list.add(getString(R.string.app_name));

        mMainProjectsFragment = new MainProjectsFragment();
        fragment_list.add(mMainProjectsFragment);
        titles_list.add(getString(R.string.app_projects));

        mMainSettingsFragment = new MainSettingsFragment();
        fragment_list.add(mMainSettingsFragment);
        titles_list.add(getString(R.string.app_settings));

        MainFragmentPagerAdapter pagerAdapter = new MainFragmentPagerAdapter(fragment_list, titles_list);

        mMainViewPager = findViewById(R.id.view_pager);
        mMainViewPager.setAdapter(pagerAdapter);
        mMainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setTitle(mMainViewPager.getAdapter().getPageTitle(position));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });
    }

    @Override
    protected void setDefaultActionBar() {
        super.setDefaultActionBar();

        final View burgerButton = getLayoutInflater().inflate(R.layout.button_menu, null);
        burgerButton.findViewById(R.id.moddedpe_ui_button_item_image_button).setOnClickListener(p1 -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, burgerButton);
            popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                switchViewPager(item);
                return true;
            });
            popup.show();
        });
        setActionBarViewRight(burgerButton);
    }

    private void switchViewPager(@NotNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_main_page) {
            mMainViewPager.setCurrentItem(0, false);
        } else if (id == R.id.item_main_projects) {
            mMainViewPager.setCurrentItem(1, false);
        } else if (id == R.id.item_main_settings) {
            mMainViewPager.setCurrentItem(2, false);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mMainProjectsFragment.onActivityResult(requestCode, resultCode, data);
        mMainSettingsFragment.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class MainFragmentPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments;
        private final List<CharSequence> mTitles;

        MainFragmentPagerAdapter(List<Fragment> fragments, List<CharSequence> titles) {
            super(getSupportFragmentManager());
            mFragments = fragments;
            mTitles = titles;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public @NotNull
        Fragment getItem(int p1) {
            return mFragments.get(p1);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}