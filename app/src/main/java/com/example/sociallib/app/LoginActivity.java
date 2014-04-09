package com.example.sociallib.app;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sociallib.app.model.SocialObject;
import com.example.sociallib.app.utils.SocialConst;


public class LoginActivity extends Activity {


    private WebView mWebView;
    private SocialObject mSocialObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_social_login);

        mWebView = (WebView) findViewById(R.id.social_login_web_view);

        mWebView.setWebViewClient(new WebViewClientCallback());
        mSocialObject = SocialFactory.getSocialObject((SocialType) getIntent().getExtras().getSerializable(SocialConst.TYPE));
        mWebView.loadUrl(mSocialObject.getUrl());

    }

    private final class WebViewClientCallback extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (mSocialObject.isParseResponseSuccess(url)){
//                Log.e("FB", mSocialObject.getToken());
            }

            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }
    }
}
