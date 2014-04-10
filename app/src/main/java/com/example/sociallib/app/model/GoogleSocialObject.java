package com.example.sociallib.app.model;


import android.os.Bundle;

import com.example.sociallib.app.utils.SocialConst;


public class GoogleSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;
    private String token;

    private static final String URL = "https://accounts.google.com/o/oauth2/auth?client_id=1033746217948-p5jn9kgocbbd09c5h7e76tb9152ak5jl.apps.googleusercontent.com&response_type=token&scope=email&redirect_uri=https://www.example.com/oauth2callback&login_hint=jsmith@example.com";

    /**
     * @param pSocialCallback Callback object. SocialCallback interface should be implemented.
     * @param pClientId    Google application ID
     * @param pRedirectUri Redirect URL
     */

    public GoogleSocialObject(SocialCallback pSocialCallback, String pClientId, String pRedirectUri) {
        mSocialCallback = pSocialCallback;
        mClientId = pClientId;
        mRedirectUri = pRedirectUri;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Boolean isParseResponseSuccess(String response) {

        if (response.contains(SocialConst.ACCESS_TOKEN) && (!response.contains(SocialConst.ERROR_CONST))) {
            Bundle b = new Bundle();
            b.putString(SocialConst.ACCESS_TOKEN, response);
            mSocialCallback.isSucceed(b);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUrl() {
        return "https://accounts.google.com/o/oauth2/auth?client_id=" + mClientId + "&response_type=token&scope=email&redirect_uri=" + mRedirectUri + "&login_hint=jsmith@example.com";
    }

    @Override
    public String getToken() {
        return token;
    }

}
