package com.applicastertest.alecmedina.mylocalposts.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.applicastertest.alecmedina.mylocalposts.R;

/**
 * Created by alec.medina on 8/1/17.
 */

public class InstagramAuthActivity extends AppCompatActivity {
    private static final String TAG = InstagramAuthActivity.class.getSimpleName();

    public static final String ACCESS_TOKEN_VALUE = "access_token_value";

    private static final String CLIENT_ID = "ed27a91d56534c72a18d62a46121efe0";
    private static final String REDIRECT_URI = "https://www.github.com/alecmedina24/oauth/callback";
    private static final String ACCESS_TOKEN = "access_token=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_layout);
        logout();
        authorize();
    }

    private void authorize() {
        WebView webView = (WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.contains(ACCESS_TOKEN)) {
                    String accessToken = url.substring(url.indexOf(ACCESS_TOKEN) +
                            ACCESS_TOKEN.length());
                    Intent data = new Intent();
                    data.putExtra(ACCESS_TOKEN_VALUE, accessToken);
                    setResult(0, data);
                    finish();
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.loadUrl(getUrl());
    }

    private void logout() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }

    public static String getUrl() {
        return String.format("https://instagram.com/oauth/authorize/?client_id=%s" +
                "&redirect_uri=%s" +
                "&response_type=token&" +
                "&scope=public_content", CLIENT_ID, REDIRECT_URI);
    }
}
