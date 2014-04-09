package com.example.sociallib.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sociallib.app.model.InstagramSocialObject;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){

        Clicker listener = new Clicker();
        findViewById(R.id.pre_login_activity_layout_facebook_button).setOnClickListener(listener);
        findViewById(R.id.pre_login_activity_layout_linkedin_button).setOnClickListener(listener);
        findViewById(R.id.pre_login_activity_layout_instagram_button).setOnClickListener(listener);
        findViewById(R.id.pre_login_activity_layout_twitter_button).setOnClickListener(listener);
        findViewById(R.id.pre_login_activity_layout_classic_login_button).setOnClickListener(listener);
        findViewById(R.id.pre_login_activity_layout_google_plus_button).setOnClickListener(listener);
    }



    private final class Clicker implements View.OnClickListener {

        @Override
        public void onClick(View v) {

//            String url = null;
            SocialType socialType = null;
            switch (v.getId()) {


                case R.id.pre_login_activity_layout_facebook_button:
                    socialType = SocialType.FACEBOOK;
                    break;

                case R.id.pre_login_activity_layout_linkedin_button:
                    socialType = SocialType.LINKEDIN;
                    break;

                case R.id.pre_login_activity_layout_instagram_button:
                    socialType = SocialType.INSTAGRAM;
                    break;
//
//                case R.id.pre_login_activity_layout_twitter_button:
////                    url = "https://api.twitter.com/oauth/request_token?oauth_callback=http%3A%2F%2Fthemattharris.local%2Fauth.php,twitterclient%3A%2F%2Fcallback";
////                    socialType = SocialType.TWITTER;
////                    launchPrepare();
//
//                    return;
//
                case R.id.pre_login_activity_layout_google_plus_button:
                    socialType = SocialType.GOOGLE_PLUS;
                    break;
//
//                case R.id.pre_login_activity_layout_classic_login_button:
//
//                    break;

            }
            Intent intent = SocialUtils.loginSocial(getApplicationContext(), socialType);
            startActivityForResult(intent, 1);
        }
    }
}
