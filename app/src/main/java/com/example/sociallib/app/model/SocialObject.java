package com.example.sociallib.app.model;


public abstract class SocialObject {

    public abstract Boolean isParseResponseSuccess(String response);
    public abstract String getUrl();
    public abstract String getToken();
}
