package com.example.sociallib.app.model;

import android.net.ParseException;
import android.net.Uri;
import android.util.Log;

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
    private static final String STATE = "DCEEFWF45453sdffef424";
    private static final String API_KEY = "7537riy2vq2sxv";
    private static final String SECRET_KEY = "AitA0VM2ZcLTdU19";
    private static final String REDIRECT_URI = "http://null.com";
    private static final String URL = "https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=" + API_KEY + "&state=" + STATE + "&redirect_uri=" + REDIRECT_URI;

    @Override
    public Boolean isToken(String response) {
        if (response.startsWith(REDIRECT_URI)) {
                    Uri uri = Uri.parse(response);
                    String stateToken = uri.getQueryParameter(STATE_PARAM);
                    if (stateToken == null || !stateToken.equals(STATE)) {
                        Log.e("Authorize", "State token doesn't match");
                        return true;
                    }
                    String authorizationToken = uri.getQueryParameter(CODE_PARAM);
                    if (authorizationToken == null) {
                        Log.i("Authorize", "The user doesn't allow authorization.");
                        return true;
                    }
                    Log.i("Authorize", "Auth token received: " + authorizationToken);

                    executePostRequest("https://www.linkedin.com/uas/oauth2/accessToken?grant_type=authorization_code&code=" + authorizationToken + "&redirect_uri=" + REDIRECT_URI + "&client_id=" + API_KEY + "&client_secret=" + SECRET_KEY);
                }
                return true;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }

//    @Override
//    public void getWebViewClient(LoginActivity.ClientCallback pCallback, Context pContext) {
//        WebViewClient client = new WebViewClient() {
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if (url.startsWith(REDIRECT_URI)) {
//                    Uri uri = Uri.parse(url);
//                    String stateToken = uri.getQueryParameter(STATE_PARAM);
//                    if (stateToken == null || !stateToken.equals(STATE)) {
//                        Log.e("Authorize", "State token doesn't match");
//                        return true;
//                    }
//                    String authorizationToken = uri.getQueryParameter(CODE_PARAM);
//                    if (authorizationToken == null) {
//                        Log.i("Authorize", "The user doesn't allow authorization.");
//                        return true;
//                    }
//                    Log.i("Authorize", "Auth token received: " + authorizationToken);
//
//                    executePostRequest("https://www.linkedin.com/uas/oauth2/accessToken?grant_type=authorization_code&code=" + authorizationToken + "&redirect_uri=" + REDIRECT_URI + "&client_id=" + API_KEY + "&client_secret=" + SECRET_KEY);
//                }
//                return true;
//
//            }
//
//            @Override
//            public void onReceivedError(WebView view, int errorCode, String description, String
//                    failingUrl) {
//                super.onReceivedError(view, errorCode, description, failingUrl);
//            }
//        };
//        pCallback.getClient(client, URL);
//
//    }
//
//
    private void executePostRequest(final String pUrl) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpost = new HttpPost(pUrl);
                try {
                    HttpResponse response = httpClient.execute(httpost);
                    if (response != null) {
                        if (response.getStatusLine().getStatusCode() == 200) {
                            String result = EntityUtils.toString(response.getEntity());
                            JSONObject resultJson = new JSONObject(result);
                            String accessToken = resultJson.has("access_token") ? resultJson.getString("access_token") : null;
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
