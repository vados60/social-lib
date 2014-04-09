package com.example.sociallib.app.model;

import android.content.Context;

import com.example.sociallib.app.LoginActivity;


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
}
