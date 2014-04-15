package com.example.sociallib.app.model;


import android.os.Bundle;

public abstract class SocialObject {

    protected static final String ACCESS_TOKEN = "access_token";
    protected static final String ERROR_CONST = "error";

    protected SocialCallback mSocialCallback;

    /**
     * <p>Parse response with token for Social Network </p>
     *
     * @param response response with token for Social Network
     * @return TRUE if Url parsed successful, FALSE if there is an error
     */
    public abstract Boolean isParseResponseSuccess(String response);


    /**
     * <p>Return authorization Url for Social Network </p>
     *
     * @return authorization Url
     */
    public abstract String getUrl();

    public interface SocialCallback {
        void isSucceed(Bundle pUserBundle);

        void isFailed();
    }
}
