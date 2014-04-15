package com.example.sociallib.app.model;

import android.os.Bundle;

public class FacebookSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;
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
    public Boolean isParseResponseSuccess(String response) {
        if (response.contains(ACCESS_TOKEN) && (!response.contains(ERROR_CONST))) {
            Bundle fbBundle = new Bundle();
            fbBundle.putString(ACCESS_TOKEN, response);
            mSocialCallback.isSucceed(fbBundle);
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
