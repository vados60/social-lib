package com.example.sociallib.app.model;

import android.content.Context;

import com.example.sociallib.app.LoginActivity;


public abstract class SocialObject {

    public abstract Boolean isParseResponseSuccess(String response);
    public abstract String getUrl();
    public abstract String getToken();
}
