package com.example.sociallib.app.model;

import android.content.Context;

import com.example.sociallib.app.LoginActivity;


public abstract class SocialObject {

//    public abstract void getWebViewClient(LoginActivity.ClientCallback pCallback, Context pContext);
    public abstract Boolean isToken(String response);
    public abstract String getUrl();
    public abstract String getToken();
}
