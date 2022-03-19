package com.mcal.apkeditor.utils;

import android.app.Activity;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.mcal.apkeditor.data.Preferences;

import java.util.Locale;

public class I18n {
    public static void setLanguage(@NonNull Activity context) {
        Locale defaultLocale = context.getResources().getConfiguration().locale;
        Configuration config = context.getResources().getConfiguration();

        switch (Preferences.getLanguageType()) {
            case 0:
            default:
                config.locale = Locale.getDefault();
                break;
            case 1:
                config.locale = Locale.ENGLISH;
                break;
            case 2:
                config.locale = new Locale("ru", "RU");
                break;
        }
        if (!defaultLocale.equals(config.locale))
            context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }
}