package com.mcal.apkeditor.ui.odex;

import android.os.Bundle;

import com.mcal.apkeditor.R;
import com.mcal.apkeditor.databinding.OdexPatcherActivityBinding;
import com.mcal.apkeditor.ui.base.BaseActivity;

public class OdexPatcherActivity extends BaseActivity {
    private OdexPatcherActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = OdexPatcherActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle(R.string.app_odex_patcher);
    }
}
