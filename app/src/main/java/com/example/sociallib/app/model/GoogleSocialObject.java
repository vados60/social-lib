package com.example.sociallib.app.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sociallib.app.LoginActivity;


public class GoogleSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;
    private String token;

    private static final String URL = "https://accounts.google.com/o/oauth2/auth?client_id=1033746217948-p5jn9kgocbbd09c5h7e76tb9152ak5jl.apps.googleusercontent.com&response_type=token&scope=email&redirect_uri=https://www.example.com/oauth2callback&login_hint=jsmith@example.com";

    public GoogleSocialObject(String pClientId, String pRedirectUri) {
        mClientId = pClientId;
        mRedirectUri = pRedirectUri;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Boolean isToken(String response) {

        if (response.contains("access_token") & (!response.contains("error"))) {
            setToken(response);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUrl() {
        return "https://accounts.google.com/o/oauth2/auth?client_id="+mClientId+"&response_type=token&scope=email&redirect_uri="+mRedirectUri+"&login_hint=jsmith@example.com";
    }

    @Override
    public String getToken() {
        return token;
    }

}
