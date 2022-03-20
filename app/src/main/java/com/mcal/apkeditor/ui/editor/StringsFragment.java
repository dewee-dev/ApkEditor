package com.mcal.apkeditor.ui.editor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mcal.apkeditor.R;
import com.mcal.apkeditor.ui.base.BaseFragment;

public class StringsFragment extends BaseFragment {
    @NonNull
    public static StringsFragment newInstance(String info) {
        Bundle args = new Bundle();
        StringsFragment fragment = new StringsFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_editor_strings_fragment, null);

        return view;
    }
}