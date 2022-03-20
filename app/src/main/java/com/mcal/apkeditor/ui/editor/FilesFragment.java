package com.mcal.apkeditor.ui.editor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mcal.apkeditor.R;
import com.mcal.apkeditor.ui.base.BaseFragment;

public class FilesFragment extends BaseFragment {
    @NonNull
    public static FilesFragment newInstance(String info) {
        Bundle args = new Bundle();
        FilesFragment fragment = new FilesFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_editor_files_fragment, null);

        return view;
    }
}
