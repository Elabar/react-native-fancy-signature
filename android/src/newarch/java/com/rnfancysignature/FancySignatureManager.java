package com.rnfancysignature;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.FancySignatureManagerDelegate;
import com.facebook.react.viewmanagers.FancySignatureManagerInterface;
import com.facebook.react.bridge.ReadableArray;

@ReactModule(name = FancySignatureManagerImpl.NAME)
public class FancySignatureManager extends SimpleViewManager<FancySignature>
        implements FancySignatureManagerInterface<FancySignature> {

    private final ViewManagerDelegate<FancySignature> mDelegate;

    public FancySignatureManager(ReactApplicationContext context) {
        mDelegate = new FancySignatureManagerDelegate<>(this);
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<FancySignature> getDelegate() {
        return mDelegate;
    }

    @NonNull
    @Override
    public String getName() {
        return FancySignatureManagerImpl.NAME;
    }

    @NonNull
    @Override
    protected FancySignature createViewInstance(@NonNull ThemedReactContext context) {
        return FancySignatureManagerImpl.createViewInstance(context);
    }

    @Override
    @ReactProp(name = "penColor")
    public void setPenColor(FancySignature fancySignature, @Nullable String color) {
        FancySignatureManagerImpl.setPenColor(fancySignature, color);
    }

    @Override
    public void clear(FancySignature fancySignature){
        fancySignature.clear();
    }

    @Override
    public void receiveCommand(FancySignature fancySignature, String commandId, @Nullable ReadableArray args){
        if(commandId.equals("clear")){
            fancySignature.clear();
        }else{
            super.receiveCommand(fancySignature, commandId, args);
        }
    }
}