package com.example.sociallib.app.model;

public class TwitterSocialObject extends SocialObject {
    @Override
    public Boolean isParseResponseSuccess(String response) {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }

//    private RequestQueue mRequestQueue;
//    private Context mContext;
//
//    @Override
//    public void getWebViewClient(LoginActivity.ClientCallback pCallback, Context pContext) {
//
//    }
//
//    private void prepareCreateWebView() {
//        mRequestQueue = Volley.newRequestQueue(mContext);
//        Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject pJSONObject) {
//            }
//        };
//
//        Response.ErrorListener errorListener = new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError pVolleyError) {
//
//            }
//        };
//
////        VolleyUnicodeRequest request = new VolleyUnicodeRequest(Request.Method.POST, "",
////                getParams(), responseListener, errorListener);
////
////        mRequestQueue.add(request);
//    }
//
//    private JSONObject getParams() {
//        return null;
//    }
}
