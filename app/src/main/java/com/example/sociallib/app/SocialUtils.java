package com.example.sociallib.app;

import android.content.Context;
import android.content.Intent;
import com.example.sociallib.app.utils.SocialConst;

final class SocialUtils {

    static Intent loginSocial(Context pContext, SocialType pSocialType) {

        Intent intent = new Intent(pContext, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra(SocialConst.TYPE, pSocialType);

        return intent;
    }
}
