package com.example.sociallib.app.model;


import android.os.Bundle;

public abstract class SocialObject {
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

    /**
     * <p>Return token that was successful parsed </p>
     *
     * @return token
     */
    public abstract String getToken();

    public abstract void setCallback(SocialCallback pCallback);

    public interface SocialCallback {
        void isSucceed(Bundle pUserBundle);

        void isFailed();
    }
}
