package com.example.sociallib.app.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sociallib.app.LoginActivity;


public class InstagramSocialObject extends SocialObject {
    //    private static final String URL = "https://api.instagram.com/oauth/authorize/?client_id=941ecbadcc4e4f989ec4a959da9d08ba&redirect_uri=http://null&response_type=token";
    private String mClientId;
    private String mRedirectUri;
    private String token;

    public InstagramSocialObject(String pClientId, String pRedirectUri) {
        mClientId = pClientId;
        mRedirectUri = pRedirectUri;
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
        return "https://api.instagram.com/oauth/authorize/?client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&response_type=token";
    }

    @Override
    public String getToken() {
        return null;
    }

    public void setToken(String token) {
        this.token = token;
    }

//    private String mAppId;
//
//    private static final String URL = "https://api.instagram.com/oauth/authorize/?client_id=941ecbadcc4e4f989ec4a959da9d08ba&redirect_uri=http://null&response_type=token";
//
//    public InstagramSocialObject(){
//
//    }
//
//    public InstagramSocialObject(String pAppId) {
//        mAppId = pAppId;
//    }
//
//    @Override
//    public void getWebViewClient(LoginActivity.ClientCallback pCallback, Context pContext) {
//        WebViewClient client = new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if (url.contains("access_token") & (!url.contains("error"))) {
//
//                    Log.w("IL", url.toString());
//
//                    return true;
//                } else if (url.contains("error")) {
//
//                    Log.w("IL", "--- error --");
//
//                    return false;
//                } else {
//
//                    Log.w("IL", "--- url not contains callback url --");
//                }
//                view.loadUrl(url);
//                return true;
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            }
//        };
//
//        pCallback.getClient(client, mAppId);
//    }
}
