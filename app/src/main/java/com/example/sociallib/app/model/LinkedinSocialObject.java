package com.example.sociallib.app.model;

import android.net.ParseException;
import android.net.Uri;
import android.util.Log;

import com.example.sociallib.app.utils.SocialConst;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.Executors;

public class LinkedinSocialObject extends SocialObject {

    private static final String STATE_PARAM = "state";
    private static final String CODE_PARAM = "code";
    private String mApiKey;
    private String mRedirectUri;
    private String mState;
    private String mSecretKey;
    private String accessToken;

    public LinkedinSocialObject(String pApiKey, String pRedirectUri, String pState, String pSecretKey) {
        mApiKey = pApiKey;
        mRedirectUri = pRedirectUri;
        mState = pState;
        mSecretKey = pSecretKey;
    }

    @Override
    public Boolean isParseResponseSuccess(String response) {
        if (response.startsWith(mRedirectUri)) {
            Uri uri = Uri.parse(response);
            String stateToken = uri.getQueryParameter(STATE_PARAM);
            if (stateToken == null || !stateToken.equals(mState)) {
                Log.e("Authorize", "State token doesn't match");
                return false;
            }
            String authorizationToken = uri.getQueryParameter(CODE_PARAM);
            if (authorizationToken == null) {
                Log.i("Authorize", "The user doesn't allow authorization.");
                return false;
            }
            Log.i("Authorize", "Auth token received: " + authorizationToken);

            executePostRequest("https://www.linkedin.com/uas/oauth2/accessToken?grant_type=authorization_code&code=" + authorizationToken + "&redirect_uri=" + mRedirectUri + "&client_id=" + mApiKey + "&client_secret=" + mSecretKey);
        }
        return true;
    }

    @Override
    public String getUrl() {

        return "https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=" + mApiKey + "&state=" + mState + "&redirect_uri=" + mRedirectUri;
    }

    @Override
    public String getToken() {
        return accessToken;
    }

    private void executePostRequest(final String pUrl) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(pUrl);
                try {
                    HttpResponse response = httpClient.execute(httpPost);
                    if (response != null) {
                        if (response.getStatusLine().getStatusCode() == 200) {
                            String result = EntityUtils.toString(response.getEntity());
                            JSONObject resultJson = new JSONObject(result);
                            accessToken = resultJson.has(SocialConst.ACCESS_TOKEN) ? resultJson.getString(SocialConst.ACCESS_TOKEN) : null;
                            Log.e("Tokenm", "" + accessToken);
                        }
                    }
                } catch (IOException e) {
                    Log.e("Authorize", "Error Http response " + e.getLocalizedMessage());
                } catch (ParseException e) {
                    Log.e("Authorize", "Error Parsing Http response " + e.getLocalizedMessage());
                } catch (JSONException e) {
                    Log.e("Authorize", "Error Parsing Http response " + e.getLocalizedMessage());
                }

            }
        });
    }

}
