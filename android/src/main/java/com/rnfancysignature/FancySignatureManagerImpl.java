package com.rnfancysignature;

import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ThemedReactContext;
import android.graphics.Color;

public class FancySignatureManagerImpl {
    public static final String NAME = "FancySignature";

    public static FancySignature createViewInstance(ThemedReactContext context) {
        return new FancySignature(context, null);
    }

    public static void setPenColor(FancySignature fancySignature, String color) {
        fancySignature.setPenColor(Color.parseColor(color));
    }
}