package com.example.sociallib.app.model;

import android.os.Bundle;

public class VkSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;
    private String mScope;

    public VkSocialObject(SocialCallback pSocialCallback, String pClientId, String pResirestUri, String pScope) {
        mSocialCallback = pSocialCallback;
        mClientId = pClientId;
        mRedirectUri = pResirestUri;
        mScope = pScope;
    }

    @Override
    public Boolean isParseResponseSuccess(String response) {
        if (response.contains(ACCESS_TOKEN) && (!response.contains(ERROR_CONST))) {
            Bundle vkBundle = new Bundle();
            vkBundle.putString(ACCESS_TOKEN, response);
            mSocialCallback.isSucceed(vkBundle);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUrl() {
        return "https://oauth.vk.com/authorize?client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&scope=" + mScope + "&display=mobile&v=5.5&response_type=token";
    }

}
