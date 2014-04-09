package com.example.sociallib.app.model;

import com.example.sociallib.app.utils.SocialConst;

public class InstagramSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;
    private String token;

    /**
     * @param pClientId    Instagram application ID
     * @param pRedirectUri Redirect URL
     */
    public InstagramSocialObject(String pClientId, String pRedirectUri) {
        mClientId = pClientId;
        mRedirectUri = pRedirectUri;
    }

    @Override
    public Boolean isParseResponseSuccess(String response) {
        if (response.contains(SocialConst.ACCESS_TOKEN) && (!response.contains(SocialConst.ERROR_CONST))) {
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
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
