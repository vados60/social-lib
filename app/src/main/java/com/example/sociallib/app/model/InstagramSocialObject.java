package com.example.sociallib.app.model;

import android.os.Bundle;

import com.example.sociallib.app.utils.SocialConst;

public class InstagramSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;

    /**
     * @param pSocialCallback Callback object. SocialCallback interface should be implemented.
     * @param pClientId    Instagram application ID
     * @param pRedirectUri Redirect URL
     */
    public InstagramSocialObject(SocialCallback pSocialCallback, String pClientId, String pRedirectUri) {
        mClientId = pClientId;
        mRedirectUri = pRedirectUri;
        mSocialCallback = pSocialCallback;
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
        return "https://api.instagram.com/oauth/authorize/?client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&response_type=token";
    }

   }
