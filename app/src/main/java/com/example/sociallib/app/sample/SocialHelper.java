package com.example.sociallib.app.sample;

import android.content.Context;
import android.content.Intent;

public class SocialHelper {

    public static Intent loginSocial(Context pContext, SocialType pSocialType) {

        String url = null;

        switch (pSocialType) {
            case FACEBOOK:
                url = "https://graph.facebook.com/oauth/access_token?";
                break;

            case GOOGLE_PLUS:

                break;

            case INSTAGRAM:
                url = "https://api.instagram.com/oauth/authorize/?client_id=941ecbadcc4e4f989ec4a959da9d08ba&redirect_uri=http://null&response_type=token";
                break;

            case LINKEDIN:
                url = "https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=7537riy2vq2sxv&state=DCEEFWF45453sdffef424&redirect_uri=http://null.com";
                break;

            case VK:

                break;
        }

        Intent intent = new Intent(pContext, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra("url", url);
        intent.putExtra("type", pSocialType);

        return intent;
    }
}
