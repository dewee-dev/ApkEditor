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
package com.mcal.apkeditor.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mcal.apkeditor.databinding.MainFragmentBinding;
import com.mcal.apkeditor.ui.base.BaseFragment;
import com.mcal.apkeditor.ui.editor.MainEditorActivity;
import com.mcal.apkeditor.ui.odex.OdexPatcherActivity;

import org.jetbrains.annotations.NotNull;

public class MainFragment extends BaseFragment {
    private MainFragmentBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);

        binding.selectApkFile.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), MainEditorActivity.class));
        });
        binding.selectInstalledApk.setOnClickListener(view -> Toast.makeText(getContext(), "Select Installed Apk", Toast.LENGTH_SHORT).show());
        binding.odexPatcher.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), OdexPatcherActivity.class));
        });

        return binding.getRoot();
    }
}