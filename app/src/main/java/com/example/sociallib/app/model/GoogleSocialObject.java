package com.example.sociallib.app.model;


import android.os.Bundle;


public class GoogleSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;

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

    @Override
    public Boolean isParseResponseSuccess(String response) {

        if (response.contains(ACCESS_TOKEN) && (!response.contains(ERROR_CONST))) {
            Bundle googleBundle = new Bundle();
            googleBundle.putString(ACCESS_TOKEN, response);
            mSocialCallback.isSucceed(googleBundle);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUrl() {
        return "https://accounts.google.com/o/oauth2/auth?client_id=" + mClientId + "&response_type=token&scope=email&redirect_uri=" + mRedirectUri + "&login_hint=jsmith@example.com";
    }


}
