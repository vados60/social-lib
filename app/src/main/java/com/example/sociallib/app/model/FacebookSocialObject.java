package com.example.sociallib.app.model;

import android.os.Bundle;

import com.example.sociallib.app.utils.SocialConst;

public class FacebookSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;
    private String token;
    private SocialCallback mSocialCallback;

    /**
     * @param pSocialCallback Callback object. SocialCallback interface should be implemented.
     * @param pClientId    Facebook application ID
     * @param pRedirectUri Redirect URL
     */
    public FacebookSocialObject(SocialCallback pSocialCallback, String pClientId, String pRedirectUri) {
        mSocialCallback = pSocialCallback;
        mClientId = pClientId;
        mRedirectUri = pRedirectUri;
    }

    @Override
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Boolean isParseResponseSuccess(String response) {
        if (response.contains(SocialConst.ACCESS_TOKEN) && (!response.contains(SocialConst.ERROR_CONST))) {
            setToken(response);
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

        return "https://m.facebook.com/dialog/oauth/?client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&response_type=token&scope=publish_stream&display=wap";
    }

}
