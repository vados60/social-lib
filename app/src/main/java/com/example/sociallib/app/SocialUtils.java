package com.example.sociallib.app;

import android.content.Context;
import android.content.Intent;

final class SocialUtils {

    static Intent loginSocial(Context pContext, SocialType pSocialType) {

        Intent intent = new Intent(pContext, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra("type", pSocialType);

        return intent;
    }
}
