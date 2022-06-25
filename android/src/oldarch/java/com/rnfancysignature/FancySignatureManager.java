package com.rnfancysignature;

import androidx.annotation.Nullable;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReactApplicationContext;
import android.graphics.Color;
import java.util.Map;
import java.util.HashMap;
import com.facebook.react.bridge.ReadableArray;

public class FancySignatureManager extends SimpleViewManager<FancySignature> {

    ReactApplicationContext mCallerContext;

    public FancySignatureManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public String getName() {
        return FancySignatureManagerImpl.NAME;
    }

    @Override
    public FancySignature createViewInstance(ThemedReactContext context) {
        return FancySignatureManagerImpl.createViewInstance(context);
    }

    @ReactProp(name = "penColor")
    public void setPenColor(FancySignature fancySignature, String color){
        FancySignatureManagerImpl.setPenColor(fancySignature, color);
    }

    @Override
    public void receiveCommand(FancySignature fancySignature, int commandType, @Nullable ReadableArray args){
        switch (commandType) {
            case 1:
                fancySignature.clear();
                break;
            default:
                break;
        }
    }
} 