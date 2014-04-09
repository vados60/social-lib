package com.example.sociallib.app;

import com.example.sociallib.app.model.FacebookSocialObject;
import com.example.sociallib.app.model.GoogleSocialObject;
import com.example.sociallib.app.model.InstagramSocialObject;
import com.example.sociallib.app.model.LinkedinSocialObject;
import com.example.sociallib.app.model.SocialObject;
import com.example.sociallib.app.model.TwitterSocialObject;


public class SocialFactory {

    public static SocialObject getSocialObject(SocialType pSocialType) {
        switch (pSocialType) {

            case TWITTER:
//                return new TwitterSocialObject();

            case INSTAGRAM:
                return new InstagramSocialObject("941ecbadcc4e4f989ec4a959da9d08ba", "http://null");

            case LINKEDIN:
                return new LinkedinSocialObject();

            case FACEBOOK:
                return new FacebookSocialObject("426034244199496", "http://null.com");

            case GOOGLE_PLUS:
                return new GoogleSocialObject("1033746217948-p5jn9kgocbbd09c5h7e76tb9152ak5jl.apps.googleusercontent.com", "https://www.example.com/oauth2callback");
        }

        return null;
    }


}
