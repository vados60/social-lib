package com.example.sociallib.app.sample;

import android.content.Context;
import android.content.Intent;
import com.example.sociallib.app.utils.SocialConst;

final class SocialUtils {

    /**
     * <p>Collect the Intent, that launches WebView, with the required type of Social Network </p>
     *
     * @param pSocialType Type of required Social Network (enum)
     * @return collected intent
     */

    static Intent loginSocial(Context pContext, SocialType pSocialType) {

        Intent intent = new Intent(pContext, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra(SocialConst.TYPE, pSocialType);

        return intent;
    }
}
