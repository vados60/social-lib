package com.example.sociallib.app.model;

public class FacebookSocialObject extends SocialObject {

    private String mClientId;
    private String mRedirectUri;
    private String token;

    public FacebookSocialObject(String pClientId, String pRedirectUri) {
        mClientId = pClientId;
        mRedirectUri = pRedirectUri;
    }

    public String getToken() {
        return token;
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

        return "https://m.facebook.com/dialog/oauth/?client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&response_type=token&scope=publish_stream&display=wap";
    }

}